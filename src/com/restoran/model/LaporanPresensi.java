package com.restoran.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LaporanPresensi {
    private static final String NAMA_FILE_PRESENSI = "presensi.txt";

    public static void buatContohFilePresensi() {
        File file = new File(NAMA_FILE_PRESENSI);
        if (file.exists() && file.length() > 0) {
            return;
        }
        String[] dataContoh = {
            "Budi Gunawan,2024-06-03,07:58,Masuk",
            "Siti Lestari,2024-06-03,08:01,Masuk",
            "Ahmad Dahlan,2024-06-03,08:05,Masuk",
            "Budi Gunawan,2024-06-03,17:02,Keluar",
            "Siti Lestari,2024-06-04,08:00,Masuk",
            "Ahmad Dahlan,2024-06-04,17:00,Keluar"
        };
        try (FileWriter writer = new FileWriter(NAMA_FILE_PRESENSI)) {
            for (String baris : dataContoh) {
                writer.write(baris + System.lineSeparator());
            }
            System.out.println("[INFO] Contoh file '" + NAMA_FILE_PRESENSI + "' berhasil dibuat (LaporanPresensi).");
        } catch (IOException e) {
            System.err.println("[ERROR] Gagal membuat file contoh '" + NAMA_FILE_PRESENSI + "': " + e.getMessage());
        }
    }

    public static String getLaporanPresensiString() {
        buatContohFilePresensi();
        StringBuilder reportContent = new StringBuilder();
        File filePresensi = new File(NAMA_FILE_PRESENSI);
        reportContent.append("--- LAPORAN PRESENSI KARYAWAN ---\n\n");
        if (!filePresensi.exists()) {
            reportContent.append("[INFO] File '").append(NAMA_FILE_PRESENSI).append("' tidak ditemukan.\n");
            reportContent.append("-".repeat(70)).append("\n");
            return reportContent.toString();
        }
        reportContent.append(String.format("%-4s | %-25s | %-12s | %-8s | %-10s%n", "No.", "Nama Karyawan", "Tanggal", "Waktu", "Status"));
        reportContent.append("-".repeat(70)).append("\n");
        try (BufferedReader reader = new BufferedReader(new FileReader(NAMA_FILE_PRESENSI))) {
            String baris;
            boolean adaData = false;
            int nomor = 1;
            while ((baris = reader.readLine()) != null) {
                baris = baris.trim();
                if (baris.isEmpty()) {
                    continue;
                }
                adaData = true;
                String[] bagian = baris.split(",");
                if (bagian.length == 4) {
                    String nama = bagian[0].trim();
                    String tanggal = bagian[1].trim();
                    String waktu = bagian[2].trim();
                    String status = bagian[3].trim();
                    reportContent.append(String.format("%-4d | %-25s | %-12s | %-8s | %-10s%n", nomor++, nama, tanggal, waktu, status));
                } else {
                    reportContent.append("[WARNING] Baris data tidak valid: ").append(baris).append("\n");
                }
            }
            if (!adaData) {
                reportContent.append("\nBelum ada data presensi yang tercatat dalam file.\n");
            }
        } catch (IOException e) {
            reportContent.append("\n[ERROR] Gagal membaca file presensi: ").append(e.getMessage()).append("\n");
        }
        reportContent.append("-".repeat(70)).append("\n");
        return reportContent.toString();
    }
}