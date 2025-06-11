/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restoran.model;

/**
 *
 * @author ADVAN
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pesanan {
    private String idPesanan;
    private Date tanggalPemesanan;
    private double totalHarga;
    private String statusPesanan;
    private String metodePembayaran;
    private boolean isFixed;
    private List<DetailPesanan> detailPesananList;

    public Pesanan(String idPesanan, Date tanggalPemesanan, String statusPesanan) {
        this.idPesanan = idPesanan;
        this.tanggalPemesanan = tanggalPemesanan;
        this.statusPesanan = statusPesanan;
        this.totalHarga = 0.0;
        this.metodePembayaran = "Belum Dipilih";
        this.isFixed = false;
        this.detailPesananList = new ArrayList<>();
    }
    
    public Pesanan() {
        this("ORD-" + System.currentTimeMillis(), new Date(), "Baru"); 
    }

    public String getIdPesanan() { 
        return idPesanan; 
    }
    public Date getTanggalPemesanan() { 
        return tanggalPemesanan; 
    }
    public double getTotalHarga() { 
        double calculatedTotal = 0.0;
        for (DetailPesanan detail : detailPesananList) {
            calculatedTotal += detail.hitungSubTotal();
        }
        this.totalHarga = calculatedTotal;
        return totalHarga;
    }
    public String getStatusPesanan() { 
        return statusPesanan; 
    }
    public String getMetodePembayaran() { 
        return metodePembayaran; }
    public boolean isFixed() { 
        return isFixed; 
    }
    public List<DetailPesanan> getDetailPesananList() { 
        return new ArrayList<>(detailPesananList); 
    }

    public void setIdPesanan(String idPesanan) { 
        this.idPesanan = idPesanan; 
    }
    public void setTanggalPemesanan(Date tanggalPemesanan) { 
        this.tanggalPemesanan = tanggalPemesanan; 
    }
    public void setStatusPesanan(String statusPesanan) { 
        this.statusPesanan = statusPesanan; 
    }
    public void setMetodePembayaran(String metodePembayaran) { 
        this.metodePembayaran = metodePembayaran; 
    }
    public void setFixed(boolean fixed) { 
        isFixed = fixed; 
    }
    public void setDetailPesananList(List<DetailPesanan> detailPesananList) { 
        this.detailPesananList = detailPesananList;
        this.totalHarga = getTotalHarga();
    }
 
    public void tambahDetailPesanan(DetailPesanan detailPesanan) {
        if (!isFixed) {
            this.detailPesananList.add(detailPesanan);
            this.totalHarga = getTotalHarga();
        } else {
            System.err.println("Tidak bisa menambah item ke pesanan yang sudah difinalisasi.");
        }
    }

    public void hapusDetailPesanan(DetailPesanan detailPesanan) {
        if (!isFixed) {
            boolean removed = this.detailPesananList.remove(detailPesanan);
            if (removed) {
                this.totalHarga = getTotalHarga();
            }
        } else {
            System.err.println("Tidak bisa menghapus item dari pesanan yang sudah difinalisasi.");
        }
    }
    
    public boolean updateKuantitasDetailPesanan(DetailPesanan detailToUpdate, int newKuantitas) {
        if (isFixed) {
            System.err.println("Tidak bisa mengupdate item di pesanan yang sudah difinalisasi.");
            return false;
        }
        if (detailToUpdate == null || newKuantitas < 0) {
            return false;
        }

        for (int i = 0; i < detailPesananList.size(); i++) {
            DetailPesanan existingDetail = detailPesananList.get(i);
            if (existingDetail == detailToUpdate) {
                existingDetail.setKuantitas(newKuantitas);
                existingDetail.hitungSubTotal();
                if (newKuantitas == 0) {
                    detailPesananList.remove(i);
                }
                this.totalHarga = getTotalHarga();
                return true;
            }
        }
        return false;
    }

    public String generateLaporanString() {
        StringBuilder sb = new StringBuilder();
        sb.append("STRUK PEMESANAN\n");
        sb.append("===========================\n");
        if (detailPesananList.isEmpty()) {
            sb.append("Tidak ada item dalam pesanan ini.\n");
        } else {
            for (DetailPesanan detail : detailPesananList) {
                sb.append(String.format("%s x%d = Rp%,.0f%n",
                                        detail.getMenu().getNama(),
                                        detail.getKuantitas(),
                                        detail.getSubTotal()));
            }
        }
        sb.append("===========================\n");
        sb.append(String.format("Total Bayar:    Rp%,.0f%n", getTotalHarga()));
        sb.append(String.format("Metode Pembayaran: %s%n", getMetodePembayaran()));
        sb.append(String.format("Tanggal Transaksi: %s%n", new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(getTanggalPemesanan())));
        sb.append("TERIMA KASIH\n");
        return sb.toString();
    }
}