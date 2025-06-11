/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restoran.model;

/**
 *
 * @author ADVAN
 */
public class Menu {
    private int id;
    private String nama;
    private int harga;
    
    // Constructor
    public Menu() {
    }
    
    public Menu(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }
    
    public String getNama() {
        return nama;
    }
    
    public int getHarga() {
        return harga;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    @Override
    public String toString() {
        return nama + " - Rp" + harga;
    }
}
