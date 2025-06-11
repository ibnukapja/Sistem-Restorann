/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restoran.model;

/**
 *
 * @author ADVAN
 */
import java.awt.Menu;
import java.util.List;
import java.util.Map;

public class Pelanggan {

    public Pelanggan() {
    }

    public List<Menu> lihatMenu() {
        return null;
    }

    public Pesanan pesanMakanan(Menu menu, int kuantitas) {
        return null;
    }

    public List<Pesanan> lihatPesanan() {
        return null;
    }

    public boolean editPesanan(Pesanan pesanan, Map<String, Object> newDetails) {
        return false;
    }

    public boolean hapusPesanan(Pesanan pesanan) {
        return false;
    }

    public boolean pilihMetodePembayaran(Pesanan pesanan, String metode) {
        return false;
    }

    public Struk cetakStruk(String idPesanan) {
        return null;
    }
}