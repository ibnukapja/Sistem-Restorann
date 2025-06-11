/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restoran.model;

/**
 *
 * @author ADVAN
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class Presensi {
    private String namaKaryawan;
    private Date tanggalWaktu;

    public Presensi(String namaKaryawan, Date tanggalWaktu) {
        this.namaKaryawan = namaKaryawan;
        this.tanggalWaktu = tanggalWaktu;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public Date getTanggalWaktu() {
        return tanggalWaktu;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return namaKaryawan + " - " + sdf.format(tanggalWaktu);
    }
}