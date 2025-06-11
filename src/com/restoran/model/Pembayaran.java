/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restoran.model;

/**
 *
 * @author ADVAN
 */
import java.util.Date;

public class Pembayaran {
    private String idPembayaran;
    private Date tanggalBayar;
    private String metodePembayaran;
    private double jumlahBayar;
    private String statusPembayaran;
    private Pesanan pesanan;

    public Pembayaran(String idPembayaran, Date tanggalBayar, String metodePembayaran, double jumlahBayar, String statusPembayaran, Pesanan pesanan) {
        this.idPembayaran = idPembayaran;
        this.tanggalBayar = tanggalBayar;
        this.metodePembayaran = metodePembayaran;
        this.jumlahBayar = jumlahBayar;
        this.statusPembayaran = statusPembayaran;
        this.pesanan = pesanan;
    }

    public String getIdPembayaran() {
        return idPembayaran;
    }

    public void setIdPembayaran(String idPembayaran) {
        this.idPembayaran = idPembayaran;
    }

    public Date getTanggalBayar() {
        return tanggalBayar;
    }

    public void setTanggalBayar(Date tanggalBayar) {
        this.tanggalBayar = tanggalBayar;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public double getJumlahBayar() {
        return jumlahBayar;
    }

    public void setJumlahBayar(double jumlahBayar) {
        this.jumlahBayar = jumlahBayar;
    }

    public String getStatusPembayaran() {
        return statusPembayaran;
    }

    public void setStatusPembayaran(String statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }

    public Pesanan getPesanan() {
        return pesanan;
    }

    public void setPesanan(Pesanan pesanan) {
        this.pesanan = pesanan;
    }

    public boolean prosesPembayaran(double jumlah, String metode) {
        if (jumlah >= this.pesanan.getTotalHarga() && this.statusPembayaran.equals("Menunggu Pembayaran")) {
            this.jumlahBayar = jumlah;
            this.metodePembayaran = metode;
            this.statusPembayaran = "Lunas";
            return true;
        } else {
            return false;
        }
    }

    public Struk cetakBuktiPembayaran() {
        return null;
    }
}
