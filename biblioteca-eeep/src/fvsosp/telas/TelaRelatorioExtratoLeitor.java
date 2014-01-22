/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.telas;

import fvsosp.biblioteca.BibliotecaRN;
import fvsosp.leitor.Leitor;
import fvsosp.leitor.LeitorRN;
import fvsosp.leitor.LeitorTableModel;
import fvsosp.util.ConnectionFactory;
import fvsosp.util.Util;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
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
public class TelaRelatorioExtratoLeitor extends javax.swing.JDialog {

    Leitor leitor = null;

    /**
     * Creates new form TelaRelatorioAcervo
     */
    public TelaRelatorioExtratoLeitor() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        setTitle("Relatório Extrato de Leitor");
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
        Descricao_Biblioteca = new javax.swing.JLabel();
        btImprimir = new javax.swing.JButton();
        tfLeitor = new javax.swing.JTextField();
        btPesquisar6 = new javax.swing.JButton();
        tfDataInicial = new javax.swing.JFormattedTextField();
        Descricao_Biblioteca1 = new javax.swing.JLabel();
        Descricao_Biblioteca2 = new javax.swing.JLabel();
        tfDataFinal = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        jPanel1.add(btSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        jPanel3.setBackground(new java.awt.Color(59, 89, 152));
        jPanel3.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Relatório Leitor");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(0, 0, 300, 30);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 35));

        Descricao_Biblioteca.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Descricao_Biblioteca.setText("Data Final.:");
        jPanel1.add(Descricao_Biblioteca, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, 29));

        btImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/imprimir2.png"))); // NOI18N
        btImprimir.setToolTipText("Sair");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        tfLeitor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfLeitor.setToolTipText("Informe o leitor");
        tfLeitor.setEnabled(false);
        jPanel1.add(tfLeitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 280, -1));

        btPesquisar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/application-form-magnify-icon.png"))); // NOI18N
        btPesquisar6.setToolTipText("Pesquisar");
        btPesquisar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisar6ActionPerformed(evt);
            }
        });
        jPanel1.add(btPesquisar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 34, -1));

        try {
            tfDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataInicial.setToolTipText("Informe a Data Inicial ");
        tfDataInicial.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        tfDataInicial.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfDataInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 120, -1));

        Descricao_Biblioteca1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Descricao_Biblioteca1.setText("Leitor.:");
        jPanel1.add(Descricao_Biblioteca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 54, -1, 29));

        Descricao_Biblioteca2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Descricao_Biblioteca2.setText("Data Inicial.:");
        jPanel1.add(Descricao_Biblioteca2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 29));

        try {
            tfDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataFinal.setToolTipText("Informe a Data Final");
        tfDataFinal.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        tfDataFinal.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfDataFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        // TODO add your handling code here:
        if (tfLeitor.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o Leitor!");
        } else if (tfDataInicial.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a Data Inicial!");
        } else if (tfDataFinal.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a Data Final!");
        } else {

            JasperReport pathjrxml;
            HashMap parametros = new HashMap();
            String sql = "", texto = "";

            String dataInicial = "", dataFinal = "";
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = new java.sql.Date(format.parse(tfDataInicial.getText()).getTime());
                dataInicial = String.valueOf(data);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = new java.sql.Date(format.parse(tfDataFinal.getText()).getTime());
                dataFinal = String.valueOf(data);
            } catch (ParseException e) {
                e.printStackTrace();
            }


            sql += "where empr.idleitor="
                    + String.valueOf(leitor.getIdLeitor())
                    + " and exeem.dataEmprestimo between '" + dataInicial + "' and '"
                    + dataFinal + "'";



            texto += "Leitor: " + leitor.getNome() + "; Dt.Inicial: "
                    + tfDataInicial.getText() + "; Data Final: " + tfDataInicial.getText();
            sql += " order by exeem.dataEmprestimo,exeem.operacao,ac.tituloObra,ex.tombo";
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
                pathjrxml = JasperCompileManager.compileReport("src/relatorios/RelExtratoLeitor.jrxml");
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
            //dispose();
        }
        //tfLeitor = null;
        tfLeitor.setText("");
        tfDataFinal.setText("");
        tfDataInicial.setText("");

    }//GEN-LAST:event_btImprimirActionPerformed

    private void btPesquisar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisar6ActionPerformed
        LeitorRN lRn = new LeitorRN();
        List<Leitor> lista = lRn.listar();

        LeitorTableModel stm = new LeitorTableModel(lista);
        Object o = TelaPesquisa.exibeTela(stm, "Leitor");
        leitor = new Leitor();

        if (o != null) {
            short id = Short.valueOf(String.valueOf(o));
            leitor = lRn.pesquisarCodigo(id);
            tfLeitor.setText(leitor.getNome());

        }
    }//GEN-LAST:event_btPesquisar6ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRelatorioExtratoLeitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioExtratoLeitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioExtratoLeitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioExtratoLeitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorioExtratoLeitor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Descricao_Biblioteca;
    private javax.swing.JLabel Descricao_Biblioteca1;
    private javax.swing.JLabel Descricao_Biblioteca2;
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btPesquisar6;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JFormattedTextField tfDataFinal;
    private javax.swing.JFormattedTextField tfDataInicial;
    private javax.swing.JTextField tfLeitor;
    // End of variables declaration//GEN-END:variables
}
