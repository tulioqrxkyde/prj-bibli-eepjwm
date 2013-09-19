/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.telas;

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
        jPanel2 = new javax.swing.JPanel();
        botaoSairPrincipal = new javax.swing.JButton();
        BarradeMenuPrincipal = new javax.swing.JMenuBar();
        menuCadastrado = new javax.swing.JMenu();
        itemCadAcervo = new javax.swing.JMenuItem();
        itemCadAluno = new javax.swing.JMenuItem();
        itemBiblioteca = new javax.swing.JMenuItem();
        itemGrupoLeitores = new javax.swing.JMenuItem();
        itemCadProfessor = new javax.swing.JMenuItem();
        itemCadSessao = new javax.swing.JMenuItem();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        botaoSairPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/SA.png"))); // NOI18N
        botaoSairPrincipal.setText("SAIR");
        botaoSairPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(427, Short.MAX_VALUE)
                .addComponent(botaoSairPrincipal)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(310, Short.MAX_VALUE)
                .addComponent(botaoSairPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        BarradeMenuPrincipal.setBackground(new java.awt.Color(102, 102, 255));
        BarradeMenuPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        menuCadastrado.setText("Cadastro");
        menuCadastrado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuCadastrado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        itemCadAcervo.setText("Acervo");
        menuCadastrado.add(itemCadAcervo);

        itemCadAluno.setText("Aluno");
        menuCadastrado.add(itemCadAluno);

        itemBiblioteca.setText("Biblioteca");
        menuCadastrado.add(itemBiblioteca);

        itemGrupoLeitores.setText("Grupo Leitores");
        itemGrupoLeitores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGrupoLeitoresActionPerformed(evt);
            }
        });
        menuCadastrado.add(itemGrupoLeitores);

        itemCadProfessor.setText("Professor");
        menuCadastrado.add(itemCadProfessor);

        itemCadSessao.setText("Sessão");
        itemCadSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadSessaoActionPerformed(evt);
            }
        });
        menuCadastrado.add(itemCadSessao);

        itemCadUsuario.setText("Usuário");
        menuCadastrado.add(itemCadUsuario);

        BarradeMenuPrincipal.add(menuCadastrado);

        itemEmprestar.setText("Emprestimos");

        jMenuItem1.setText("Emprestar");
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        setJMenuBar(BarradeMenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSairPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairPrincipalActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_botaoSairPrincipalActionPerformed
    
    private void itemCadSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadSessaoActionPerformed
        TelaCadastroSessao telacadsessao = new TelaCadastroSessao();
        telacadsessao.setVisible(true);
        
    }//GEN-LAST:event_itemCadSessaoActionPerformed

    private void itemGrupoLeitoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGrupoLeitoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemGrupoLeitoresActionPerformed

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
    private javax.swing.JButton botaoSairPrincipal;
    private javax.swing.JMenuItem itemBiblioteca;
    private javax.swing.JMenuItem itemCadAcervo;
    private javax.swing.JMenuItem itemCadAluno;
    private javax.swing.JMenuItem itemCadProfessor;
    private javax.swing.JMenuItem itemCadSessao;
    private javax.swing.JMenuItem itemCadUsuario;
    private javax.swing.JMenuItem itemConsultarAcervo;
    private javax.swing.JMenu itemEmprestar;
    private javax.swing.JMenuItem itemGrupoLeitores;
    private javax.swing.JMenuItem itemRelatorioCatalogacao;
    private javax.swing.JMenuItem itemRelatorioEmprestimo;
    private javax.swing.JMenuItem itemRelatorioFinanceiro;
    private javax.swing.JMenu itemRelatorioUsuario;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenu menuCadastrado;
    private javax.swing.JMenu menuConsulta;
    // End of variables declaration//GEN-END:variables
}