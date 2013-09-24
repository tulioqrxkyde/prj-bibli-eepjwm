/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.telas;

import fvsosp.biblioteca.Biblioteca;
import fvsosp.biblioteca.BibliotecaRN;
import fvsosp.biblioteca.BibliotecaTableModel;
import fvsosp.sessao.SessaoRN;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author TÚLIO
 */
public class TelaCadastroBiblioteca extends javax.swing.JDialog {

    Biblioteca biblioteca;
    BibliotecaRN bibliotecaRN = new BibliotecaRN();

    /**
     * Creates new form TelaCadastroBiblioteca
     */
    public TelaCadastroBiblioteca() {
        initComponents();
        this.setTitle("OSBiblio - Biblioteca");
        this.setLocationRelativeTo(null);
        btRemover.setEnabled(false);
        setModal(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        Descricao_Biblioteca = new javax.swing.JLabel();
        tfNomeBiblioteca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(432, 177));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/save_1.png"))); // NOI18N
        btSalvar.setToolTipText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/remove_1.png"))); // NOI18N
        btRemover.setToolTipText("Excluir");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/novo_1.png"))); // NOI18N
        btNovo.setToolTipText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/SA.png"))); // NOI18N
        btSair.setToolTipText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/procurar_1.png"))); // NOI18N
        btPesquisar.setToolTipText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(59, 89, 152));
        jPanel3.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Biblioteca");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(0, 0, 170, 30);

        Descricao_Biblioteca.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Descricao_Biblioteca.setText("Descrição.:");

        tfNomeBiblioteca.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfNomeBiblioteca.setToolTipText("Digite aqui a descrição da biblioteca");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Descricao_Biblioteca)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSair))
                    .addComponent(tfNomeBiblioteca))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Descricao_Biblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(tfNomeBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSair)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        // TODO add your handling code here:
        List<Biblioteca> bibliotecas = null;
        if (tfNomeBiblioteca.getText() != null) {
            bibliotecas = bibliotecaRN.pesquisaDescricaoLike(tfNomeBiblioteca.getText());
        } else {
            bibliotecas = bibliotecaRN.listar();
        }
        BibliotecaTableModel btm = new BibliotecaTableModel(bibliotecas);
        Object o = TelaPesquisa.exibeTela(btm, "Biblioteca");
        biblioteca = new Biblioteca();
        if (o != null) {
            int id = (int) o;
            biblioteca = bibliotecaRN.pesquisarCodigo(id);
            tfNomeBiblioteca.setText(biblioteca.getDescricao().toString());
            btRemover.setEnabled(true);
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btSairActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:
        limpaCampos();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        // TODO add your handling code here:
        if (biblioteca != null) {
            if (biblioteca.getIdBiblioteca() != 0) {
                if (JOptionPane.showConfirmDialog(rootPane, "Deseja excluir a biblioteca " + biblioteca.getDescricao()
                        + "?", "OSBiblio", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                    if (bibliotecaRN.remove(biblioteca)) {
                        JOptionPane.showMessageDialog(rootPane, "Biblioteca " + biblioteca.getDescricao()
                                + ", excluída com sucesso!", "Biblioteca", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Não foi possível excluir a Biblioteca "
                                + biblioteca.getDescricao(),
                                "Erro ao Excluir", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        limpaCampos();
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:
        if (biblioteca == null) {
            biblioteca = new Biblioteca();
        }

        biblioteca.setDescricao(tfNomeBiblioteca.getText().toString());
        int idBiblioteca = biblioteca.getIdBiblioteca();
        if (bibliotecaRN.salvar(biblioteca)) {
            if (idBiblioteca == 0) {
                JOptionPane.showMessageDialog(rootPane, "Biblioteca " + biblioteca.getDescricao()
                        + ", cadastrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Biblioteca " + biblioteca.getDescricao()
                        + ", alterada com sucesso!");
            }
            limpaCampos();
            btRemover.setEnabled(false);
        }
    }//GEN-LAST:event_btSalvarActionPerformed
    public void limpaCampos() {
        tfNomeBiblioteca.setText("");
        biblioteca = null;
        tfNomeBiblioteca.requestFocus();
        btRemover.setEnabled(false);
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroBiblioteca().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Descricao_Biblioteca;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tfNomeBiblioteca;
    // End of variables declaration//GEN-END:variables
}
