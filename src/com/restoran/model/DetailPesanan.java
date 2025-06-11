/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restoran.model;

/**
 *
 * @author ADVAN
 */
public class DetailPesanan {
    private Menu menu;
    private int kuantitas;
    private double subTotal;

    public DetailPesanan(Menu menu, int kuantitas) {
        this.menu = menu;
        this.kuantitas = kuantitas;
        this.subTotal = hitungSubTotal();
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
        this.subTotal = hitungSubTotal();
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
        this.subTotal = hitungSubTotal();
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double hitungSubTotal() {
        if (menu != null) {
            this.subTotal = menu.getHarga() * kuantitas;
            return this.subTotal;
        }
        return 0.0;
    }
}