/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.telas;

import fvsosp.biblioteca.BibliotecaRN;
import fvsosp.util.ConnectionFactory;
import fvsosp.util.Util;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaRelatorioSituacaoExemplar extends javax.swing.JDialog {

    /**
     * Creates new form TelaRelatorioSituacaoExemplar
     */
    public TelaRelatorioSituacaoExemplar() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        Util.setAcessibilidade(this);
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
        btSair = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        btImprimir = new javax.swing.JButton();
        Descricao_Biblioteca2 = new javax.swing.JLabel();
        cbSituacao = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(432, 177));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/SA.png"))); // NOI18N
        btSair.setToolTipText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel1.add(btSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));

        jPanel3.setBackground(new java.awt.Color(59, 89, 152));
        jPanel3.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Situação Exemplar");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(0, 0, 300, 30);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 35));

        btImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/imprimir2.png"))); // NOI18N
        btImprimir.setToolTipText("Sair");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        Descricao_Biblioteca2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Descricao_Biblioteca2.setText("Situação Exemplar.:");
        jPanel1.add(Descricao_Biblioteca2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 29));

        cbSituacao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "Disponível", "Indisponível", "Emprestado" }));
        jPanel1.add(cbSituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 180, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Util.setAcessibilidade(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        // TODO add your handling code here:
        if(cbSituacao.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(rootPane, "Informe a Situação!");
        } else {
            JasperReport pathjrxml;
            HashMap parametros = new HashMap();
            String sql = "", texto = "";
            if(cbSituacao.getSelectedIndex()==1){
                sql += "where ex.situacao=1";
            } else if(cbSituacao.getSelectedIndex()==2){
                sql += "where ex.situacao=4";
            } else if(cbSituacao.getSelectedIndex()==3){
                sql += "where ex.situacao=3";
            }
            

            sql += " order by ac.tituloObra,ex.tombo";
            parametros.put("sql", sql);
            BibliotecaRN bRN = new BibliotecaRN();
            try {
                parametros.put("biblioteca", bRN.listar().get(0).getDescricao());
            } catch (Exception e) {
            }
            parametros.put("texto", texto);

            Connection connection = new ConnectionFactory().getConnection();
            try {
                JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
                viewer.setSize(1000, 600);
                viewer.setLocationRelativeTo(null);
                viewer.setModal(true);
                pathjrxml = JasperCompileManager.compileReport("src/relatorios/RelSitExemplar.jrxml");
                JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, parametros,
                        connection);
                // JasperExportManager.exportReportToPdfFile(printReport, "src/relatorios/RelExtratoLeitor.pdf");
                JasperViewer jv = new JasperViewer(printReport, false);
                viewer.getContentPane().add(jv.getContentPane());
                viewer.setVisible(true);
                //jv.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        cbSituacao.setSelectedIndex(0);
    }//GEN-LAST:event_btImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRelatorioSituacaoExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioSituacaoExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioSituacaoExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioSituacaoExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorioSituacaoExemplar().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Descricao_Biblioteca2;
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btSair;
    private javax.swing.JComboBox cbSituacao;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
