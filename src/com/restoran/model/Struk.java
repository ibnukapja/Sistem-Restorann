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

public class Struk {
    private String idStruk;
    private Pesanan pesanan;
    private Pembayaran pembayaran;
    private Date tanggalCetak;
    private String kontenStruk;

    public Struk(String idStruk, Pesanan pesanan, Pembayaran pembayaran, Date tanggalCetak, String kontenStruk) {
        this.idStruk = idStruk;
        this.pesanan = pesanan;
        this.pembayaran = pembayaran;
        this.tanggalCetak = tanggalCetak;
        this.kontenStruk = kontenStruk;
    }

    public String getIdStruk() {
        return idStruk;
    }

    public void setIdStruk(String idStruk) {
        this.idStruk = idStruk;
    }

    public Pesanan getPesanan() {
        return pesanan;
    }

    public void setPesanan(Pesanan pesanan) {
        this.pesanan = pesanan;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    public Date getTanggalCetak() {
        return tanggalCetak;
    }

    public void setTanggalCetak(Date tanggalCetak) {
        this.tanggalCetak = tanggalCetak;
    }

    public String getKontenStruk() {
        return kontenStruk;
    }

    public void setKontenStruk(String kontenStruk) {
        this.kontenStruk = kontenStruk;
    }
}