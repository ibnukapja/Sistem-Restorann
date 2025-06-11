/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restoran.model;

/**
 *
 * @author ADVAN
 */
import com.restoran.model.Presensi;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class PresensiManager {
    private static PresensiManager instance;
    private final String FILE_PRESENSI = "presensi.txt";
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    private PresensiManager() {
    }

    public static PresensiManager getInstance() {
        if (instance == null) {
            instance = new PresensiManager();
        }
        return instance;
    }

    public Presensi catatPresensi(String namaKaryawan, Date tanggalWaktu) {
        Presensi presensiBaru = new Presensi(namaKaryawan, tanggalWaktu);
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_PRESENSI, true))) {
            out.println(presensiBaru.toString());
        } catch (IOException ex) {
            System.err.println("Error saat menulis presensi ke file: " + ex.getMessage());
    }
    return presensiBaru;
}

    public List<Presensi> muatSemuaPresensi() {
        List<Presensi> daftarPresensi = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PRESENSI))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(" - ");
                    if (parts.length == 2) {
                        String nama = parts[0].trim();
                        Date tanggal = sdf.parse(parts[1].trim());
                        daftarPresensi.add(new Presensi(nama, tanggal));
                    }
                } catch (ParseException e) {
                    System.err.println("Gagal parsing baris presensi: " + line + " - " + e.getMessage());
                }
            }
        } catch (IOException ex) {
            System.err.println("File presensi tidak ditemukan atau error saat memuat: " + ex.getMessage());
        }
        return daftarPresensi;
    }
}