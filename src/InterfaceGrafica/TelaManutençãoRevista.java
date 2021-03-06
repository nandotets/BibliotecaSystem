/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import TipoDados.Revista;
import java.awt.event.ActionEvent;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * a
 *
 * @author Fernando TeTz
 */
public class TelaManutençãoRevista extends ModeloManutenção {

    ArrayList<Revista> revistas = new ArrayList<>();
    public static Revista revista;
    String[] pesquisa = {"Título", "Data de edição", "ID"},
            meses = {"Mês", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    int cont = 0;

    public TelaManutençãoRevista() throws Exception {
        try {
            lerArquivo();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Arquivo 'ArqRevistas.dad' não encontrado. Um novo arquivo será criado.",
                    "Tela de erro", JOptionPane.ERROR_MESSAGE);
            gravaArquivo();
        }
        montaCombo();
        initComponents();
        tabelaRevistas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tPesquisa.setSize(6, 35);
    }

    private void montaCombo() {
        cbPesquisa.removeAllItems();
        for (String pesquisa1 : pesquisa) {
            cbPesquisa.addItem(pesquisa1);
        }
        cbPesquisa.setSelectedIndex(0);
    }

    private void montaComboDia() {
        cbDiaPesquisa.removeAllItems();
        cbDiaPesquisa.addItem("Dia");
        for (int dia = 1; dia < 32; dia++) {
            cbDiaPesquisa.addItem(Integer.toString(dia));
        }
        cbDiaPesquisa.setSelectedIndex(0);
    }

    private void montaComboMes() {
        cbMesPesquisa.removeAllItems();
        for (int mes = 0; mes < 13; mes++) {
            cbMesPesquisa.addItem(meses[mes]);
        }
        cbDiaPesquisa.setSelectedIndex(0);
    }

    private void montaComboAno() {
        cbAnoPesquisa.removeAllItems();
        cbAnoPesquisa.addItem("Ano");
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 0; i < 35; i++) {
            cbAnoPesquisa.addItem(Integer.toString(anoAtual - i));
        }
        cbAnoPesquisa.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRevistas = new javax.swing.JTable();

        setResizable(true);
        setTitle("Manutenção de revistas");
        setToolTipText("");

        tabelaRevistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Título", "Quantidade", "Data de edição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaRevistas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabelaRevistas.getTableHeader().setReorderingAllowed(false);
        tabelaRevistas.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabelaRevistas.getColumnModel().getColumn(1).setPreferredWidth(200);
        jScrollPane1.setViewportView(tabelaRevistas);
        if (tabelaRevistas.getColumnModel().getColumnCount() > 0) {
            tabelaRevistas.getColumnModel().getColumn(0).setResizable(false);
            tabelaRevistas.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabelaRevistas.getColumnModel().getColumn(1).setPreferredWidth(345);
            tabelaRevistas.getColumnModel().getColumn(2).setResizable(false);
            tabelaRevistas.getColumnModel().getColumn(2).setPreferredWidth(85);
            tabelaRevistas.getColumnModel().getColumn(3).setResizable(false);
            tabelaRevistas.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lerArquivo() throws Exception {
        Revista revistax = null;
        revistas.clear();
        ObjectInputStream arquivo = null;
        try {
            arquivo = new ObjectInputStream(new FileInputStream("ArqRevistas.dad"));
            do {
                revistax = (Revista) arquivo.readObject();
                revistas.add(revistax);
            } while (revistax != null);
        } catch (EOFException e) {
            arquivo.close();
        }
    }

    @Override
    public void bNovoActionListener(ActionEvent evt) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaRevistas.getModel();
        TelaAdicionarRevista telaadd = new TelaAdicionarRevista();
        telaadd.setVisible(true);
        for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
            modelo.removeRow(k);
        }
        try {
            lerArquivo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        for (int x = 0; x < revistas.size(); x++) { //Percorre todos os revistas
            Object[] linhax = {revistas.get(x).getIDAcervo(), revistas.get(x).getTitulo(),
                revistas.get(x).getQtdeExemplar(), revistas.get(x).getDataEdicao().toString()};
            modelo.addRow(linhax);
        }
    }

    @Override
    public void bEditarActionListener(ActionEvent evt) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaRevistas.getModel();
        int linha = tabelaRevistas.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Nenhuma revista selecionada.\n"
                    + "Por favor selecione uma revista para ser editada.", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int idEdit = Integer.parseInt(modelo.getValueAt(linha, 0).toString());
        for (int x = 0; x < revistas.size(); x++) {
            if (revistas.get(x).getIDAcervo() == idEdit) {
                revista = revistas.get(x);
                break;
            }
        }
        try {
            TelaEditarRevista telaedit = new TelaEditarRevista();
            telaedit.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir tela de editar revista." + ex.getMessage(),
                    "Tela de erro", JOptionPane.ERROR_MESSAGE);
        }

        try {
            lerArquivo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
            modelo.removeRow(k);
        }
        for (int x = 0; x < revistas.size(); x++) { //Percorre todos os revistas
            Object[] linhax = {revistas.get(x).getIDAcervo(), revistas.get(x).getTitulo(),
                revistas.get(x).getQtdeExemplar(), revistas.get(x).getDataEdicao().toString()};
            modelo.addRow(linhax);
        }
    }

    public static Revista getRevista() {
        return revista;
    }

    @Override
    public void bSairActionListener(ActionEvent evt) {
        int result;
        try {
            result = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "SAIR", JOptionPane.YES_NO_OPTION);
            if (result == 0) {
                TelaInicial.max = 0;
                this.dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Tela de erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void mudouCB() {
        if (cbPesquisa.getSelectedIndex() == 1) { //Pesquisa por data de edicao
            tPesquisa.setEnabled(false);;
            cbDiaPesquisa.setEnabled(true);
            montaComboDia();
            cbDiaPesquisa.setSelectedIndex(0);
            cbMesPesquisa.setEnabled(true);
            montaComboMes();
            cbMesPesquisa.setSelectedIndex(0);
            cbAnoPesquisa.setEnabled(true);
            montaComboAno();
            cbAnoPesquisa.setSelectedIndex(0);
        } else {
            tPesquisa.setEnabled(true);
            cbDiaPesquisa.setEnabled(false);
            cbMesPesquisa.setEnabled(false);
            cbAnoPesquisa.setEnabled(false);
        }
    }

    @Override
    public void txPesquisa() {
        try {
            lerArquivo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        int tipoPesquisa = cbPesquisa.getSelectedIndex();
        DefaultTableModel modelo = (DefaultTableModel) tabelaRevistas.getModel();
        for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
            modelo.removeRow(k);
        }
        switch (tipoPesquisa) {
            case 0: //Pesquisa por titulo
                for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
                    modelo.removeRow(k);
                }
                if (!(tPesquisa.getText().isEmpty())) {
                    for (int x = 0; x < revistas.size(); x++) {
                        if (revistas.get(x).getTitulo().contains(tPesquisa.getText())) {
                            Object[] linhax = {revistas.get(x).getIDAcervo(), revistas.get(x).getTitulo(),
                                revistas.get(x).getQtdeExemplar(), revistas.get(x).getDataEdicao().toString()};
                            modelo.addRow(linhax);
                        }
                    }
                }
                break;
            case 1: //Pesquisa por data de edição
                for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
                    modelo.removeRow(k);
                }
                short ano = 0;
                byte dia = (byte) cbDiaPesquisa.getSelectedIndex();
                byte mes = (byte) cbMesPesquisa.getSelectedIndex();
                if (cbAnoPesquisa.getSelectedIndex() != 0 && cbAnoPesquisa.getSelectedIndex() != -1) {
                    ano = (short) Integer.parseInt(cbAnoPesquisa.getSelectedItem().toString());
                }
                for (int x = 0; x < revistas.size(); x++) {
                    if (revistas.get(x).getDataEdicao().getDia() == dia && mes == 0
                            && cbAnoPesquisa.getSelectedIndex() == 0) { //BUSCA DO DIA
                        for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
                            modelo.removeRow(k);
                        }
                        Object[] linhax = {revistas.get(x).getIDAcervo(), revistas.get(x).getTitulo(),
                            revistas.get(x).getQtdeExemplar(), revistas.get(x).getDataEdicao().toString()};
                        modelo.addRow(linhax);
                    }
                    if (revistas.get(x).getDataEdicao().getDia() == dia && revistas.get(x).getDataEdicao().getMes() == mes
                            && cbAnoPesquisa.getSelectedIndex() == 0) { //BUSCA DO DIA/MES
                        for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
                            modelo.removeRow(k);
                        }
                        Object[] linhax = {revistas.get(x).getIDAcervo(), revistas.get(x).getTitulo(),
                            revistas.get(x).getQtdeExemplar(), revistas.get(x).getDataEdicao().toString()};
                        modelo.addRow(linhax);
                    }
                    if (revistas.get(x).getDataEdicao().getDia() == dia
                            && revistas.get(x).getDataEdicao().getMes() == mes
                            && revistas.get(x).getDataEdicao().getAno() == ano) { //BUSCA DO DIA/MES/ANO
                        for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
                            modelo.removeRow(k);
                        }
                        Object[] linhax = {revistas.get(x).getIDAcervo(), revistas.get(x).getTitulo(),
                            revistas.get(x).getQtdeExemplar(), revistas.get(x).getDataEdicao().toString()};
                        modelo.addRow(linhax);
                    }
                    if (revistas.get(x).getDataEdicao().getDia() == dia
                            && revistas.get(x).getDataEdicao().getAno() == ano
                            && cbAnoPesquisa.getSelectedIndex() == 0) { //BUSCA DO DIA/ANO
                        for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
                            modelo.removeRow(k);
                        }
                        Object[] linhax = {revistas.get(x).getIDAcervo(), revistas.get(x).getTitulo(),
                            revistas.get(x).getQtdeExemplar(), revistas.get(x).getDataEdicao().toString()};
                        modelo.addRow(linhax);
                    }
                    if (revistas.get(x).getDataEdicao().getMes() == mes
                            && revistas.get(x).getDataEdicao().getAno() == ano
                            && dia == 0) { //BUSCA DO MES/ANO
                        for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
                            modelo.removeRow(k);
                        }
                        Object[] linhax = {revistas.get(x).getIDAcervo(), revistas.get(x).getTitulo(),
                            revistas.get(x).getQtdeExemplar(), revistas.get(x).getDataEdicao().toString()};
                        modelo.addRow(linhax);
                    }
                    if (revistas.get(x).getDataEdicao().getMes() == mes
                            && dia == 0 && cbAnoPesquisa.getSelectedIndex() == 0) { //BUSCA DO MES
                        for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
                            modelo.removeRow(k);
                        }
                        Object[] linhax = {revistas.get(x).getIDAcervo(), revistas.get(x).getTitulo(),
                            revistas.get(x).getQtdeExemplar(), revistas.get(x).getDataEdicao().toString()};
                        modelo.addRow(linhax);
                    }
                    if (revistas.get(x).getDataEdicao().getAno() == ano
                            && dia == 0 && mes == 0) { //BUSCA DO ANO
                        for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
                            modelo.removeRow(k);
                        }
                        Object[] linhax = {revistas.get(x).getIDAcervo(), revistas.get(x).getTitulo(),
                            revistas.get(x).getQtdeExemplar(), revistas.get(x).getDataEdicao().toString()};
                        modelo.addRow(linhax);
                    }
                }
                break;
            case 2: //Pesquisa por ID
                for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
                    modelo.removeRow(k);
                }
                if (!(tPesquisa.getText().isEmpty())) {
                    for (int x = 0; x < revistas.size(); x++) {
                        if (revistas.get(x).getIDAcervo() == Integer.parseInt(tPesquisa.getText())) {
                            Object[] linhax = {revistas.get(x).getIDAcervo(), revistas.get(x).getTitulo(),
                                revistas.get(x).getQtdeExemplar(), revistas.get(x).getDataEdicao().toString()};
                            modelo.addRow(linhax);
                            break;
                        }
                    }
                }
                break;
        }
    }

    @Override
    public void bMostrarTodosActionListener(ActionEvent evt) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaRevistas.getModel();

        try {
            lerArquivo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não existe cadastros de revistas.", "Não encontrado", JOptionPane.ERROR_MESSAGE);
        }
        for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
            modelo.removeRow(k);
        }
        for (int x = 0; x < revistas.size(); x++) { //Percorre todos os revistas
            Object[] linhax = {revistas.get(x).getIDAcervo(), revistas.get(x).getTitulo(),
                revistas.get(x).getQtdeExemplar(), revistas.get(x).getDataEdicao().toString()};
            modelo.addRow(linhax);
        }
    }

    @Override
    public void bLimparTudoActionListener(ActionEvent evt) {
        int result = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja limpar tudo?");
        if (result == 0) { //Resposta SIM
            limpaTudo();
        }
    }

    public void limpaTudo() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaRevistas.getModel();

        for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
            modelo.removeRow(k);
        }
        tabelaRevistas.setModel(modelo);
        tPesquisa.setText("");
        cbDiaPesquisa.setSelectedIndex(0);
        cbMesPesquisa.setSelectedIndex(0);
        cbAnoPesquisa.setSelectedIndex(0);
    }

    @Override
    public void bExcluirActionListener(ActionEvent evt) {
        try {
            lerArquivo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        DefaultTableModel modelo = (DefaultTableModel) tabelaRevistas.getModel();
        int linha = tabelaRevistas.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Nenhuma revista selecionada.\n"
                    + "Por favor selecione uma revista para ser excluída.", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int idRemove = Integer.parseInt(modelo.getValueAt(linha, 0).toString());
        for (int x = 0; x < revistas.size(); x++) {
            if (revistas.get(x).getIDAcervo() == idRemove) {
                int result = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir '"
                        + revistas.get(x).getTitulo() + "' ?", "EXCLUIR REVISTA", JOptionPane.YES_NO_OPTION);
                if (result == 0) {
                    JOptionPane.showMessageDialog(null, "Revista '" + revistas.get(x).getTitulo()
                            + "' excluída com sucesso.", "EXCLUIR REVISTA", JOptionPane.INFORMATION_MESSAGE);
                    revistas.remove(x);
                    try {
                        gravaArquivo();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao gravar no arquivo.", "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
            }
        }
        limpaTudo();
        try {
            lerArquivo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        for (int x = 0; x < revistas.size(); x++) { //Percorre todos os revistas
            Object[] linhax = {revistas.get(x).getIDAcervo(), revistas.get(x).getTitulo(),
                revistas.get(x).getQtdeExemplar(), revistas.get(x).getDataEdicao().toString()};
            modelo.addRow(linhax);
        }
    }

    private void gravaArquivo() throws Exception {
        try (ObjectOutputStream arquivo = new ObjectOutputStream(new FileOutputStream("ArqRevistas.dad"))) {
            for (Revista revistax : revistas) {
                arquivo.writeObject(revistax);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tabelaRevistas;
    // End of variables declaration//GEN-END:variables

}
