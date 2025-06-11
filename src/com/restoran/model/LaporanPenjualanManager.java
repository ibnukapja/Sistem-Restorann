/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.restoran.model;

/**
 *
 * @author WIN10
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;

public class LaporanPenjualanManager {
    private static final String FILE_LAPORAN_PENJUALAN = "laporan_penjualan.txt";

    public static boolean tulisLaporanPesanan(Pesanan pesanan) {
        if (pesanan == null || pesanan.getDetailPesananList().isEmpty()) {
            System.err.println("ERROR: Tidak ada pesanan untuk ditulis ke laporan.");
            return false;
        }

        try (FileWriter fw = new FileWriter(FILE_LAPORAN_PENJUALAN, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            out.println("ID:" + pesanan.getIdPesanan() + 
                        "|Tanggal:" + sdf.format(pesanan.getTanggalPemesanan()) +
                        "|Total:" + pesanan.getTotalHarga() +
                        "|Metode:" + pesanan.getMetodePembayaran() +
                        "|Status:" + pesanan.getStatusPesanan());

            for (DetailPesanan detail : pesanan.getDetailPesananList()) {
                out.println("ITEM:" + detail.getMenu().getNama() + ";" + 
                            detail.getKuantitas() + ";" + 
                            detail.getMenu().getHarga());
            }
            out.println("---END_PESANAN---"); 

            return true;
        } catch (IOException e) {
            System.err.println("ERROR: Gagal menulis laporan penjualan ke file " + FILE_LAPORAN_PENJUALAN + ": " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static String bacaSemuaLaporan() {
        StringBuilder reportContent = new StringBuilder();
        reportContent.append("--- LAPORAN PENJUALAN ---\n\n");
        reportContent.append("===========================\n");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_LAPORAN_PENJUALAN))) {
            String line;
            boolean inPesananBlock = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ID:")) {
                    if (inPesananBlock) {
                        reportContent.append("===========================\n");
                    }
                    inPesananBlock = true;
                    String[] parts = line.substring(3).split("\\|");
                    String id = parts[0].substring(3);
                    String tanggal = parts[1].substring(8);
                    String total = parts[2].substring(6);
                    String metode = parts[3].substring(7);
                    String status = parts[4].substring(7);

                    reportContent.append("STRUK PEMESANAN\n");
                    reportContent.append(String.format("ID Pesanan: %s%n", id));
                    reportContent.append(String.format("Tanggal: %s%n", tanggal));
                    reportContent.append("---------------------------\n");
                    reportContent.append("Item Pesanan:\n");

                } else if (line.startsWith("ITEM:")) {
                    String[] itemParts = line.substring(5).split(";");
                    String nama = itemParts[0];
                    int kuantitas = Integer.parseInt(itemParts[1]);
                    double hargaSatuan = Double.parseDouble(itemParts[2]);
                    reportContent.append(String.format("  %s x%d = Rp%,.0f%n", nama, kuantitas, (kuantitas * hargaSatuan)));
                } else if (line.equals("---END_PESANAN---")) {
                    reportContent.append("===========================\n");
                    String[] parts = line.substring(3).split("\\|"); 
                    String total = "";
                    String metode = "";
                    if (line.startsWith("ID:")) {
                         parts = line.substring(3).split("\\|");
                         total = parts[2].substring(6);
                         metode = parts[3].substring(7);
                    } else {
                        
                    }
                    reportContent.append("\n"); 
                    inPesananBlock = false;
                } else {
                    reportContent.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            System.err.println("ERROR: Gagal membaca laporan penjualan dari file " + FILE_LAPORAN_PENJUALAN + ": " + e.getMessage());
            e.printStackTrace();
            reportContent.append("\n[ERROR] Gagal membaca laporan penjualan: ").append(e.getMessage()).append("\n");
        }
        reportContent.append("===========================\n");
        return reportContent.toString();
    }

    public static boolean tulisStrukString(String strukContent) {
        try (FileWriter fw = new FileWriter(FILE_LAPORAN_PENJUALAN, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            
            out.println(strukContent);
            out.println("\n---END_STRUK---\n");
            return true;
        } catch (IOException e) {
            System.err.println("ERROR: Gagal menulis struk ke laporan penjualan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}