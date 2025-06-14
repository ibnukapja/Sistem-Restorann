/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.restoran.gui;

/**
 *
 * @author ADVAN
 */
import com.restoran.gui.LaporanPresensiFrame;
import com.restoran.gui.MenuKaryawanFrame;
import com.restoran.model.Presensi;
import com.restoran.model.PresensiManager;
import java.util.Date;
import javax.swing.JOptionPane;
import java.lang.String;

public class InputPresensiFrame extends javax.swing.JFrame {

    /**
     * Creates new form InputPresensiFrame
     */
    public InputPresensiFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNamaInput = new javax.swing.JTextField();
        btnOKInput = new javax.swing.JButton();
        btnCancelInput = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Karyawan");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Masukkan Nama Anda:");

        txtNamaInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaInputActionPerformed(evt);
            }
        });

        btnOKInput.setText("OK");
        btnOKInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKInputActionPerformed(evt);
            }
        });

        btnCancelInput.setText("Cancel");
        btnCancelInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnOKInput)
                        .addGap(28, 28, 28)
                        .addComponent(btnCancelInput))
                    .addComponent(txtNamaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtNamaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOKInput)
                    .addComponent(btnCancelInput))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaInputActionPerformed
        btnOKInputActionPerformed(evt);
    }//GEN-LAST:event_txtNamaInputActionPerformed

    private void btnOKInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKInputActionPerformed
    String nama = txtNamaInput.getText().trim();

    if (nama.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Nama tidak boleh kosong!",
            "Error Input",
            JOptionPane.ERROR_MESSAGE);
        return;
    }

    PresensiManager manager = PresensiManager.getInstance();
    java.util.Date tanggalWaktuSekarang = new java.util.Date();
    Presensi presensiYangDicatat = manager.catatPresensi(nama, tanggalWaktuSekarang);
    this.dispose();

    LaporanPresensiFrame laporanFrame = new LaporanPresensiFrame();
    laporanFrame.setVisible(true);
    }//GEN-LAST:event_btnOKInputActionPerformed

    private void btnCancelInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelInputActionPerformed
        this.setVisible(false);
        this.dispose();

        // Kembali ke MenuKaryawanFrame
        MenuKaryawanFrame menuKaryawan = new MenuKaryawanFrame();
        menuKaryawan.setVisible(true);
    }//GEN-LAST:event_btnCancelInputActionPerformed

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
            java.util.logging.Logger.getLogger(InputPresensiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputPresensiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputPresensiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputPresensiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputPresensiFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelInput;
    private javax.swing.JButton btnOKInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtNamaInput;
    // End of variables declaration//GEN-END:variables
}
