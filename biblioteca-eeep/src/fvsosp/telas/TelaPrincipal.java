/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.telas;

import fvsosp.util.UsuarioAtivo;

/**
 *
 * @author ADRIANO
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Tela_Principal
     */
    public TelaPrincipal() {
        initComponents();
        //setExtendedState( MAXIMIZED_BOTH ); ;   //( iniciar tela cheia )
        setTitle("OSBiblio");
        setLocationRelativeTo(null);
        jlUsuarioLogado.setText(jlUsuarioLogado.getText().replace("?",((UsuarioAtivo.getLogin() != null) ? UsuarioAtivo.getLogin() : "?")));
        itemCadUsuario.setVisible(UsuarioAtivo.isAdministrador());
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
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jlUsuarioLogado = new javax.swing.JLabel();
        labelVersao = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        BarradeMenuPrincipal = new javax.swing.JMenuBar();
        menuCadastrado = new javax.swing.JMenu();
        itemCadAcervo = new javax.swing.JMenuItem();
        itemCadAutor = new javax.swing.JMenuItem();
        itemCadBiblioteca = new javax.swing.JMenuItem();
        itemCadCidade = new javax.swing.JMenuItem();
        itemCadEditora = new javax.swing.JMenuItem();
        itemCadGrupoLeitores = new javax.swing.JMenuItem();
        itemCadIdioma = new javax.swing.JMenuItem();
        itemCadLeitor = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        itemCadSessao = new javax.swing.JMenuItem();
        itemCadTipoItem = new javax.swing.JMenuItem();
        itemCadUsuario = new javax.swing.JMenuItem();
        itemEmprestar = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuConsulta = new javax.swing.JMenu();
        itemConsultarAcervo = new javax.swing.JMenuItem();
        itemRelatorioUsuario = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        itemRelatorioFinanceiro = new javax.swing.JMenuItem();
        itemRelatorioEmprestimo = new javax.swing.JMenuItem();
        itemRelatorioCatalogacao = new javax.swing.JMenuItem();
        ItemSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OSBiblio");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(826, 0, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/logoosp.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 20, 960, -1));

        jPanel3.setBackground(new java.awt.Color(59, 89, 159));

        jlUsuarioLogado.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jlUsuarioLogado.setForeground(new java.awt.Color(255, 255, 255));
        jlUsuarioLogado.setText("Logado como: ?");

        labelVersao.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        labelVersao.setForeground(new java.awt.Color(255, 255, 255));
        labelVersao.setText("Versão: 1.0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelVersao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 554, Short.MAX_VALUE)
                .addComponent(jlUsuarioLogado)
                .addGap(121, 121, 121))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlUsuarioLogado)
                    .addComponent(labelVersao))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 840, -1));

        jPanel4.setBackground(new java.awt.Color(59, 89, 159));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, -1));

        BarradeMenuPrincipal.setBackground(new java.awt.Color(51, 51, 255));
        BarradeMenuPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        menuCadastrado.setText("Cadastro");
        menuCadastrado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuCadastrado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        itemCadAcervo.setText("Acervo");
        itemCadAcervo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadAcervoActionPerformed(evt);
            }
        });
        menuCadastrado.add(itemCadAcervo);

        itemCadAutor.setText("Autor");
        itemCadAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadAutorActionPerformed(evt);
            }
        });
        menuCadastrado.add(itemCadAutor);

        itemCadBiblioteca.setText("Biblioteca");
        itemCadBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadBibliotecaActionPerformed(evt);
            }
        });
        menuCadastrado.add(itemCadBiblioteca);

        itemCadCidade.setText("Cidade");
        itemCadCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadCidadeActionPerformed(evt);
            }
        });
        menuCadastrado.add(itemCadCidade);

        itemCadEditora.setText("Editora");
        itemCadEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadEditoraActionPerformed(evt);
            }
        });
        menuCadastrado.add(itemCadEditora);

        itemCadGrupoLeitores.setText("Grupo Leitores");
        itemCadGrupoLeitores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadGrupoLeitoresActionPerformed(evt);
            }
        });
        menuCadastrado.add(itemCadGrupoLeitores);

        itemCadIdioma.setText("Idioma");
        itemCadIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadIdiomaActionPerformed(evt);
            }
        });
        menuCadastrado.add(itemCadIdioma);

        itemCadLeitor.setText("Leitor");
        itemCadLeitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadLeitorActionPerformed(evt);
            }
        });
        menuCadastrado.add(itemCadLeitor);

        jMenuItem2.setText("Palavras Chaves");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuCadastrado.add(jMenuItem2);

        itemCadSessao.setText("Sessão");
        itemCadSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadSessaoActionPerformed(evt);
            }
        });
        menuCadastrado.add(itemCadSessao);

        itemCadTipoItem.setText("Tipo Item");
        itemCadTipoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadTipoItemActionPerformed(evt);
            }
        });
        menuCadastrado.add(itemCadTipoItem);

        itemCadUsuario.setText("Usuário");
        itemCadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadUsuarioActionPerformed(evt);
            }
        });
        menuCadastrado.add(itemCadUsuario);

        BarradeMenuPrincipal.add(menuCadastrado);

        itemEmprestar.setText("Movimentação");

        jMenuItem1.setText("Empréstimo/Devolução");
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        itemEmprestar.add(jMenuItem1);

        BarradeMenuPrincipal.add(itemEmprestar);

        menuConsulta.setText("Consulta");

        itemConsultarAcervo.setText("Acervo");
        menuConsulta.add(itemConsultarAcervo);

        BarradeMenuPrincipal.add(menuConsulta);

        itemRelatorioUsuario.setText("Relatórios");

        jMenuItem3.setText("Usuário");
        itemRelatorioUsuario.add(jMenuItem3);

        itemRelatorioFinanceiro.setText("Financeiro");
        itemRelatorioUsuario.add(itemRelatorioFinanceiro);

        itemRelatorioEmprestimo.setText("Emprestimo");
        itemRelatorioUsuario.add(itemRelatorioEmprestimo);

        itemRelatorioCatalogacao.setText("Catalogação");
        itemRelatorioUsuario.add(itemRelatorioCatalogacao);

        BarradeMenuPrincipal.add(itemRelatorioUsuario);

        ItemSair.setText("Sair");
        ItemSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ItemSairMouseClicked(evt);
            }
        });
        BarradeMenuPrincipal.add(ItemSair);

        setJMenuBar(BarradeMenuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemCadAcervoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadAcervoActionPerformed
        new TelaCadastroAcervo().setVisible(true);
    }//GEN-LAST:event_itemCadAcervoActionPerformed

    private void itemCadAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadAlunoActionPerformed
        // Instancie sua Tela
    }//GEN-LAST:event_itemCadAlunoActionPerformed

    private void itemCadAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadAutorActionPerformed
        new TelaCadastroAutor().setVisible(true);
    }//GEN-LAST:event_itemCadAutorActionPerformed

    private void itemCadBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadBibliotecaActionPerformed
        new TelaCadastroBiblioteca().setVisible(true);
    }//GEN-LAST:event_itemCadBibliotecaActionPerformed

    private void itemCadGrupoLeitoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadGrupoLeitoresActionPerformed
        // Instancie sua Tela
        TelaCadastroGruposLeitores tGrupLeitores = new TelaCadastroGruposLeitores();
        tGrupLeitores.setVisible(true);
    }//GEN-LAST:event_itemCadGrupoLeitoresActionPerformed

    private void itemCadSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadSessaoActionPerformed
        new TelaCadastroSessao().setVisible(true);
    }//GEN-LAST:event_itemCadSessaoActionPerformed

    private void itemCadUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadUsuarioActionPerformed
        // Instancie sua Tela
        TelaCadastroUsuario tCU = new TelaCadastroUsuario();
        tCU.setVisible(true);
    }//GEN-LAST:event_itemCadUsuarioActionPerformed

    private void ItemSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemSairMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ItemSairMouseClicked

    private void itemCadLeitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadLeitorActionPerformed
        // Instancie sua Tela
        TelaCadastroLeitor tCadLeitor = new TelaCadastroLeitor();
        tCadLeitor.setVisible(true);
    }//GEN-LAST:event_itemCadLeitorActionPerformed

    private void itemCadCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadCidadeActionPerformed
        // TODO add your handling code here:
        TelaCadastroCidade tcadCidade = new TelaCadastroCidade();
        tcadCidade.setVisible(true);
    }//GEN-LAST:event_itemCadCidadeActionPerformed

    private void itemCadEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadEditoraActionPerformed
        // TODO add your handling code here:
        TelaCadastroEditora tcadEditora = new TelaCadastroEditora();
        tcadEditora.setVisible(true);
    }//GEN-LAST:event_itemCadEditoraActionPerformed

    private void itemCadIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadIdiomaActionPerformed
        // TODO add your handling code here:
        TelaCadastroIdioma tCadIdioma = new TelaCadastroIdioma();
        tCadIdioma.setVisible(true);
    }//GEN-LAST:event_itemCadIdiomaActionPerformed

    private void itemCadTipoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadTipoItemActionPerformed
        // TODO add your handling code here:
        TelaCadastroTipoItem tCadTipoItem = new TelaCadastroTipoItem();
        tCadTipoItem.setVisible(true);
    }//GEN-LAST:event_itemCadTipoItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        TelaCadastroPalavasChaves tCPC = new TelaCadastroPalavasChaves();
        tCPC.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        TelaCadastroEmprestimos TCE = new TelaCadastroEmprestimos();
        TCE.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarradeMenuPrincipal;
    private javax.swing.JMenu ItemSair;
    private javax.swing.JMenuItem itemCadAcervo;
    private javax.swing.JMenuItem itemCadAutor;
    private javax.swing.JMenuItem itemCadBiblioteca;
    private javax.swing.JMenuItem itemCadCidade;
    private javax.swing.JMenuItem itemCadEditora;
    private javax.swing.JMenuItem itemCadGrupoLeitores;
    private javax.swing.JMenuItem itemCadIdioma;
    private javax.swing.JMenuItem itemCadLeitor;
    private javax.swing.JMenuItem itemCadSessao;
    private javax.swing.JMenuItem itemCadTipoItem;
    private javax.swing.JMenuItem itemCadUsuario;
    private javax.swing.JMenuItem itemConsultarAcervo;
    private javax.swing.JMenu itemEmprestar;
    private javax.swing.JMenuItem itemRelatorioCatalogacao;
    private javax.swing.JMenuItem itemRelatorioEmprestimo;
    private javax.swing.JMenuItem itemRelatorioFinanceiro;
    private javax.swing.JMenu itemRelatorioUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jlUsuarioLogado;
    private javax.swing.JLabel labelVersao;
    private javax.swing.JMenu menuCadastrado;
    private javax.swing.JMenu menuConsulta;
    // End of variables declaration//GEN-END:variables
}
