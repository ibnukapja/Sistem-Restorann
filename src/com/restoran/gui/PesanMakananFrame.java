/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.restoran.gui;

import com.restoran.model.Admin;
import com.restoran.model.DetailPesanan;
import com.restoran.model.Menu;
import com.restoran.model.Pesanan;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JComboBox; 


/**
 *
 * @author ADVAN
 */
public class PesanMakananFrame extends javax.swing.JFrame {
    private Pesanan currentPesanan;
    private List<Menu> availableMenus;
    private boolean isCancelled = false;
    
    /**
     * Creates new form PesanMakananFrame
     */
    
    public PesanMakananFrame(Pesanan existingPesanan) {
        this.currentPesanan = existingPesanan;
        this.availableMenus = new ArrayList<>(); 
        initComponents();
        loadMenu();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.isCancelled = false;
    }
    
    public PesanMakananFrame() {
        this(new Pesanan());
    }
    
    private void loadMenu() {
    jComboBoxMenuMakanan.removeAllItems();
    availableMenus.clear();

    Admin admin = new Admin("dummy", "dummy");
    List<Menu> loadedMenus = admin.getDaftarMenuAdmin();

    if (loadedMenus.isEmpty()) {
        jComboBoxMenuMakanan.addItem("Menu Kosong");
        btnPesan.setEnabled(false);
        JOptionPane.showMessageDialog(this, "Maaf, belum ada menu yang tersedia saat ini.", "Menu Kosong", JOptionPane.INFORMATION_MESSAGE);
    } else {
        for (Menu menu : loadedMenus) {
            availableMenus.add(menu);
            jComboBoxMenuMakanan.addItem(menu.getNama() + " (Rp" + menu.getHarga() + ")");
        }
        btnPesan.setEnabled(true);
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxMenuMakanan = new javax.swing.JComboBox<>();
        btnPesan = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSelesai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pesan Makanan");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Pilih Makanan:");

        jComboBoxMenuMakanan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxMenuMakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMenuMakananActionPerformed(evt);
            }
        });

        btnPesan.setText("Tambah");
        btnPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesanActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSelesai.setText("Selesai");
        btnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxMenuMakanan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPesan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSelesai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxMenuMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesan)
                    .addComponent(btnCancel)
                    .addComponent(btnSelesai))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesanActionPerformed
        int selectedIndex = jComboBoxMenuMakanan.getSelectedIndex();
        if (selectedIndex == -1 || jComboBoxMenuMakanan.getSelectedItem().equals("Menu Kosong")) {
            JOptionPane.showMessageDialog(this, "Pilih menu terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Menu selectedMenu = availableMenus.get(selectedIndex);

        String kuantitasStr = JOptionPane.showInputDialog(this, 
                                                          "Masukkan jumlah untuk " + selectedMenu.getNama() + ":", 
                                                          "Input Kuantitas", 
                                                          JOptionPane.PLAIN_MESSAGE);

        if (kuantitasStr == null || kuantitasStr.trim().isEmpty()) {
            return;
        }

        try {
            int kuantitas = Integer.parseInt(kuantitasStr.trim());
            if (kuantitas <= 0) {
                JOptionPane.showMessageDialog(this, "Kuantitas harus lebih dari 0.", "Error Kuantitas", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DetailPesanan detail = new DetailPesanan(selectedMenu, kuantitas);
            currentPesanan.tambahDetailPesanan(detail);

            JOptionPane.showMessageDialog(this, 
                                          kuantitas + "x " + selectedMenu.getNama() + " berhasil ditambahkan ke pesanan.", 
                                          "Sukses", 
                                          JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Kuantitas tidak valid. Masukkan angka bulat.", "Error Kuantitas", JOptionPane.ERROR_MESSAGE);
        }                                       
    }//GEN-LAST:event_btnPesanActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.isCancelled = true;
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void jComboBoxMenuMakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMenuMakananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMenuMakananActionPerformed

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSelesaiActionPerformed
    
    public boolean isCancelled() {
        return isCancelled;
    }
    public Pesanan getPesanan() {
        return this.currentPesanan;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PesanMakananFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesanMakananFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesanMakananFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesanMakananFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesanMakananFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnPesan;
    private javax.swing.JButton btnSelesai;
    private javax.swing.JComboBox<String> jComboBoxMenuMakanan;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
