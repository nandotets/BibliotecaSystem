/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import TipoDados.Associado;
import TipoDados.Endereco;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import TipoDados.TxtComUndoRedo;

/**
 *
 * @author Fernando TeTz
 */
public class TelaEditarAssociado extends ModeloAdicionar {

    ArrayList<Associado> associados = new ArrayList<>();
    Associado associado, associadoAux;
    String[] estados = {"", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO",
        "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR",
        "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO"};

    public TelaEditarAssociado() throws Exception {
        try {
            lerArquivo();
        } catch (Exception e) {
        }
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        montaCombo();
        int i = 0;
        for (i = 0; i < estados.length; i++) {
            if (cbEstado.getItemAt(i).equals(TelaManutençãoAssociado.getAssociado().getEndereco().getUF())) {
                break;
            }
        }
        tNome.setText(TelaManutençãoAssociado.getAssociado().getNome());
        labelCPF.setText(TelaManutençãoAssociado.getAssociado().getCpfAssociado());
        tTelefone.setText(TelaManutençãoAssociado.getAssociado().getTelefone());
        tEmail.setText(TelaManutençãoAssociado.getAssociado().getEmail());
        tCEP.setText(TelaManutençãoAssociado.getAssociado().getEndereco().getCEP());
        tCidade.setText(TelaManutençãoAssociado.getAssociado().getEndereco().getCidade());
        tEndereco.setText(TelaManutençãoAssociado.getAssociado().getEndereco().getRua());
        tNumero.setText(TelaManutençãoAssociado.getAssociado().getEndereco().getNumero());
        tComplemento.setText(TelaManutençãoAssociado.getAssociado().getEndereco().getComplemento());
        tBairro.setText(TelaManutençãoAssociado.getAssociado().getEndereco().getBairro());
        cbEstado.setSelectedIndex(i);
    }

//    public TelaEditarEditora(Associado associadox) {
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        tNome = new TxtComUndoRedo();
        labelTelefone = new javax.swing.JLabel();
        tTelefone = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        tEmail = new TxtComUndoRedo();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tEndereco = new TxtComUndoRedo();
        jLabel5 = new javax.swing.JLabel();
        tNumero = new TxtComUndoRedo();
        jLabel6 = new javax.swing.JLabel();
        tComplemento = new TxtComUndoRedo();
        jLabel8 = new javax.swing.JLabel();
        tCEP = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        tCidade = new TxtComUndoRedo();
        jLabel10 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        tBairro = new TxtComUndoRedo();
        labelCPF = new javax.swing.JLabel();

        setTitle("Editar Associado");

        jLabel7.setText("CPF:");

        labelNome.setText("* Nome:");

        tNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tNomeFocusGained(evt);
            }
        });

        labelTelefone.setText("* Telefone:");

        try {
            tTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tTelefoneFocusGained(evt);
            }
        });

        jLabel3.setText("Email:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jLabel4.setText("Endereço:");

        jLabel5.setText("Nº:");

        jLabel6.setText("Complemento:");

        jLabel8.setText("CEP:");

        try {
            tCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("Cidade:");

        jLabel10.setText("UF:");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Bairro:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tBairro))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tEndereco))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tNumero)
                            .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(tCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(tBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        labelCPF.setText("jLabel12");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTelefone)
                    .addComponent(labelNome)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tNome, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                        .addComponent(tEmail)
                        .addComponent(tTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelCPF))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(75, 75, 75))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(labelCPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefone)
                    .addComponent(tTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tNomeFocusGained
        labelNome.setForeground(Color.black);
    }//GEN-LAST:event_tNomeFocusGained

    private void tTelefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tTelefoneFocusGained
        labelTelefone.setForeground(Color.black);
    }//GEN-LAST:event_tTelefoneFocusGained

    private void montaCombo() {
        cbEstado.removeAllItems();
        for (String estadox : estados) {
            cbEstado.addItem(estadox);
        }
        cbEstado.setSelectedIndex(0);
    }

    private void lerArquivo() throws Exception {
        ObjectInputStream arquivo = null;
        Associado associadox = null;
        associados.clear();
        try {
            arquivo = new ObjectInputStream(new FileInputStream("ArqAssociados.dad"));
            do {
                associadox = (Associado) arquivo.readObject();
                associados.add(associadox);
            } while (associadox != null);
        } catch (EOFException e) {
            arquivo.close();
        }
    }

    @Override
    public void bSalvarActionListener(ActionEvent evt) {
        try {
            int result = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja salvar a edição?",
                    "EDITAR ASSOCIADO", JOptionPane.INFORMATION_MESSAGE);
            if (result == 0) { //REPOSTA SIM
                if (tNome.getText().isEmpty() || tTelefone.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!",
                            "CAMPOS OBRIGATÓRIOS!", JOptionPane.INFORMATION_MESSAGE);
                    if (tNome.getText().isEmpty()) {
                        labelNome.setForeground(Color.RED);
                    } else if (tTelefone.getText().isEmpty()) {
                        labelTelefone.setForeground(Color.RED);
                    }
                    return;
                }
                for (int i = 0; i < associados.size(); i++) {
                    if (associados.get(i).getCpfAssociado().equals(TelaManutençãoAssociado.getAssociado().getCpfAssociado())) { //Salva razao editada
                        Endereco endereco = new Endereco();
                        associados.get(i).setNome(tNome.getText());
                        associados.get(i).setTelefone(tTelefone.getText());
                        associados.get(i).setEmail(tEmail.getText());
                        endereco.setCEP(tCEP.getText());
                        endereco.setCidade(tCidade.getText());
                        endereco.setBairro(tBairro.getText());
                        endereco.setNumero(tNumero.getText());
                        endereco.setRua(tEndereco.getText());
                        endereco.setUF(cbEstado.getSelectedItem().toString());
                        endereco.setComplemento(tComplemento.getText());
                        associados.get(i).setEndereco(endereco);
                        break;
                    }
                }
                gravaArquivo();
                LimpaCampos();
                JOptionPane.showMessageDialog(null, "Associado modificado com sucesso.", "EDIÇÃO DE ASSOCIADO",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao gravar em ArqAssociados.biblio\n" + ex.getMessage(),
                    "Tela de erro", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }

    @Override
    public void bLimparActionListener(ActionEvent evt) {
        int result = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja limpar tudo?");
        if (result == 0) { //Resposta SIM
            LimpaCampos();
        }
    }

    public void LimpaCampos() {
        try {
            tTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#########")));
        } catch (java.text.ParseException ex) {
        }
        tBairro.setText("");
        tCidade.setText("");
        tComplemento.setText("");
        tEmail.setText("");
        tEndereco.setText("");
        tNome.setText("");
        tNumero.setText("");
    }

    @Override
    public void bCancelarActionListener(ActionEvent evt) {
        int result;
        result = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair da operação?",
                "CANCELAR", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            this.dispose();
        }
    }

    private void gravaArquivo() throws Exception {
        try {
            ObjectOutputStream arquivo = new ObjectOutputStream(new FileOutputStream("ArqAssociados.dad"));
            for (Associado editora1 : associados) {
                arquivo.writeObject(editora1);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JTextField tBairro;
    private javax.swing.JFormattedTextField tCEP;
    private javax.swing.JTextField tCidade;
    private javax.swing.JTextField tComplemento;
    private javax.swing.JTextField tEmail;
    private javax.swing.JTextField tEndereco;
    private javax.swing.JTextField tNome;
    private javax.swing.JTextField tNumero;
    private javax.swing.JFormattedTextField tTelefone;
    // End of variables declaration//GEN-END:variables

}
