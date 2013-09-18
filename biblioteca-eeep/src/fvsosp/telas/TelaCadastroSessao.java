/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.telas;

import fvsosp.sessao.Sessao;
import fvsosp.sessao.SessaoRN;
import fvsosp.sessao.SessaoTableModel;
import fvsosp.usuario.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author TULIO
 */
public class TelaCadastroSessao extends javax.swing.JDialog {

    private Sessao sessao;
    private SessaoRN sessaoRN = new SessaoRN();

    /**
     * Creates new form Tela_Cadastro_Sessao
     */
    public TelaCadastroSessao() {
        initComponents();
        this.setTitle("OSBilio - Sessão");
        this.setLocationRelativeTo(null);
        /*desabilita o o botão remover, o mesmo deve ser habilitado
         * quando for pesquisado algum item, 
         */
        lbRemover.setEnabled(false);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        tfNomeSessao = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lbNovo = new javax.swing.JLabel();
        lbSalvar = new javax.swing.JLabel();
        lbRemover = new javax.swing.JLabel();
        lbPesquisar = new javax.swing.JLabel();
        btSair = new javax.swing.JButton();

        setResizable(false);

        jLabel24.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel24.setText("Descrição.:");

        tfNomeSessao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(59, 89, 152));
        jPanel3.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Sessão");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(0, 0, 170, 30);

        lbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/novo_1.png"))); // NOI18N
        lbNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNovoMouseClicked(evt);
            }
        });
        jPanel3.add(lbNovo);
        lbNovo.setBounds(250, 0, 30, 30);

        lbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/save_1.png"))); // NOI18N
        lbSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSalvarMouseClicked(evt);
            }
        });
        jPanel3.add(lbSalvar);
        lbSalvar.setBounds(290, 0, 30, 30);

        lbRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/remove_1.png"))); // NOI18N
        lbRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRemoverMouseClicked(evt);
            }
        });
        jPanel3.add(lbRemover);
        lbRemover.setBounds(330, 0, 30, 30);

        lbPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/procurar_1.png"))); // NOI18N
        lbPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPesquisarMouseClicked(evt);
            }
        });
        jPanel3.add(lbPesquisar);
        lbPesquisar.setBounds(370, 0, 30, 30);

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/SA.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btSair)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel24)
                            .addGap(330, 330, 330)))
                    .addComponent(tfNomeSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNomeSessao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btSairActionPerformed

    private void lbNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNovoMouseClicked
        // TODO add your handling code here:
        limpaCampos();
    }//GEN-LAST:event_lbNovoMouseClicked

    private void lbSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSalvarMouseClicked
        // TODO add your handling code here:
        if (sessao == null) {
            sessao = new Sessao();
        }


        sessao.setDescricao(tfNomeSessao.getText().toString());

        if (sessaoRN.salvar(sessao)) {
            JOptionPane.showMessageDialog(rootPane, "Sessão " + sessao.getDescricao()
                    + ", cadastrada com sucesso!");
            limpaCampos();
        }
    }//GEN-LAST:event_lbSalvarMouseClicked

    private void lbRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRemoverMouseClicked
        // TODO add your handling code here:
        if (sessao != null) {
            if (sessao.getIdSessao() != 0) {
                if (sessaoRN.remove(sessao)) {
                    JOptionPane.showMessageDialog(rootPane, "Sessão " + sessao.getDescricao()
                            + ", excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possível excluir a sessão "
                            + sessao.getDescricao(),
                            "Erro ao Excluir", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Não existe Sessão para excluir!",
                    "Erro ao Excluir", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lbRemoverMouseClicked

    private void lbPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPesquisarMouseClicked
        // TODO add your handling code here:
        SessaoTableModel stm = new SessaoTableModel(sessaoRN.listar());
        Object o = TelaPesquisa.exibeTela(stm);
        sessao = new Sessao();
        if (o != null) {
            sessao = sessaoRN.pesquisarCodigo((short) o);
            tfNomeSessao.setText(sessao.getDescricao().toString());
            lbRemover.setEnabled(true);
        }
    }//GEN-LAST:event_lbPesquisarMouseClicked

    public void limpaCampos() {
        tfNomeSessao.setText("");
        sessao = null;
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroSessao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroSessao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroSessao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroSessao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroSessao().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbNovo;
    private javax.swing.JLabel lbPesquisar;
    private javax.swing.JLabel lbRemover;
    private javax.swing.JLabel lbSalvar;
    private javax.swing.JTextField tfNomeSessao;
    // End of variables declaration//GEN-END:variables
}
