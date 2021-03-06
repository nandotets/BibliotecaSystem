/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando TeTz
 */
public abstract class ModeloEmprestimos extends javax.swing.JInternalFrame implements ActionListener {

    /**
     * Creates new form ModeloAdicionar
     */
    public ModeloEmprestimos() {
        try {
            initComponents();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    e.getMessage(), "Tela de erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelS1 = new javax.swing.JPanel();
        bLimpar = new javax.swing.JButton();
        bSalvar = new javax.swing.JButton();
        bSair = new javax.swing.JButton();

        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icone.png"))); // NOI18N

        bLimpar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bLimpar.setForeground(new java.awt.Color(51, 102, 255));
        bLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Clear-icon.png"))); // NOI18N
        bLimpar.setText("Limpar");
        bLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimparActionPerformed(evt);
            }
        });

        bSalvar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bSalvar.setForeground(new java.awt.Color(51, 102, 255));
        bSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/floppy-icon.png"))); // NOI18N
        bSalvar.setText("Salvar");
        bSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvarActionPerformed(evt);
            }
        });

        bSair.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bSair.setForeground(new java.awt.Color(51, 102, 255));
        bSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sair.png"))); // NOI18N
        bSair.setText("Sair");
        bSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelS1Layout = new javax.swing.GroupLayout(painelS1);
        painelS1.setLayout(painelS1Layout);
        painelS1Layout.setHorizontalGroup(
            painelS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelS1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(bSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(bLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(104, 104, 104)
                .addComponent(bSair)
                .addContainerGap())
        );
        painelS1Layout.setVerticalGroup(
            painelS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelS1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(bLimpar)
                    .addComponent(bSalvar))
                .addContainerGap())
            .addGroup(painelS1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(bSair)
                .addGap(11, 11, 11))
        );

        getContentPane().add(painelS1, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimparActionPerformed
        bLimparActionListener(evt);
    }//GEN-LAST:event_bLimparActionPerformed

    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarActionPerformed
        bSalvarActionListener(evt);
    }//GEN-LAST:event_bSalvarActionPerformed

    private void bSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSairActionPerformed
        bSairActionListener(evt);
    }//GEN-LAST:event_bSairActionPerformed

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == bSair) {
            this.bSairActionPerformed(evt);
        } else if (evt.getSource() == bLimpar) {
            this.bLimparActionPerformed(evt);
        } else if (evt.getSource() == bSalvar) {
            this.bSalvarActionPerformed(evt);
        }
    }

    public abstract void bSairActionListener(ActionEvent evt);

    public abstract void bSalvarActionListener(ActionEvent evt);

    public abstract void bLimparActionListener(ActionEvent evt);

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton bLimpar;
    protected javax.swing.JButton bSair;
    protected javax.swing.JButton bSalvar;
    private javax.swing.JPanel painelS1;
    // End of variables declaration//GEN-END:variables
}
