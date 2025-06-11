package com.restoran.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Admin {
    private String username;
    private String password;
    private List<Menu> daftarMenu;
    private static final String FILE_MENU = "menu_makanan.txt";
    private static final String FILE_LAPORAN_PENJUALAN = "laporan_penjualan.txt";

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.daftarMenu = new ArrayList<>();
        loadMenuFromFile();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public boolean loginAdmin(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    private void loadMenuFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_MENU))) {
            String line;
            this.daftarMenu.clear();
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(";");
                if (parts.length == 2) {
                    try {
                        Menu menu = new Menu();
                        menu.setNama(parts[0].trim());
                        menu.setHarga(Integer.parseInt(parts[1].trim()));
                        this.daftarMenu.add(menu);
                    } catch (NumberFormatException e) {
                        System.err.println("Gagal parsing harga untuk baris: " + line + " di " + FILE_MENU + ": " + e.getMessage());
                    }
                } else {
                    System.err.println("Format baris menu tidak valid (bukan Nama;Harga): " + line + " di " + FILE_MENU);
                }
            }
        } catch (IOException e) {
            System.err.println("Error memuat menu dari file " + FILE_MENU + ": " + e.getMessage());
        }
    }

    private boolean saveMenuToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_MENU))) {
            for (Menu menu : daftarMenu) {
                String line = (menu.getNama() == null ? "" : menu.getNama().replace(";", ",")) + ";" +
                              menu.getHarga();
                writer.write(line);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error menyimpan menu ke file " + FILE_MENU + ": " + e.getMessage());
            return false;
        }
    }

    public boolean tambahMenu(String nama, int harga) { 
        for (Menu menuExist : daftarMenu) {
            if (menuExist.getNama() != null && menuExist.getNama().equalsIgnoreCase(nama)) {
                return false;
            }
        }

        Menu menuBaru = new Menu();
        menuBaru.setNama(nama);
        menuBaru.setHarga(harga);
        
        this.daftarMenu.add(menuBaru);
        return saveMenuToFile();
    }

    public List<Menu> getDaftarMenuAdmin() {
        loadMenuFromFile();
        return new ArrayList<>(this.daftarMenu);
    }

    public boolean catatWaktuMasuk(String nama, Date waktu) { 
        return true; 
    }
    public boolean editMenu(String nama, Map<String, Object> newDetails) { 
        return true; 
    }
    public boolean hapusMenu(String namaMenu) {
        if (namaMenu == null || namaMenu.trim().isEmpty()) {
            return false;
        }

        Menu menuToDelete = null;
        for (Menu menu : daftarMenu) {
            if (menu.getNama() != null && menu.getNama().equalsIgnoreCase(namaMenu)) {
                menuToDelete = menu;
                break;
            }
        }

        if (menuToDelete != null) {
            this.daftarMenu.remove(menuToDelete);
            return saveMenuToFile();
        }
        return false;
    }
    public List<Object> lihatLaporanPresensi(String periode) { 
        return null; 
    }
    public String generateLaporanKeuangan() { 
        return null; 
    }
}