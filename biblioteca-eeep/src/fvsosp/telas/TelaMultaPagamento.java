/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.telas;

import fvsosp.biblioteca.BibliotecaRN;
import fvsosp.multa.Multa;
import fvsosp.multa.MultaRN;
import fvsosp.util.ConnectionFactory;
import fvsosp.util.Util;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
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
public class TelaMultaPagamento extends javax.swing.JDialog {

    private static Multa multa = null;

    public static void pagamentoMulta(Multa multa) {
        TelaMultaPagamento.multa = multa;
        TelaMultaPagamento tMP = new TelaMultaPagamento();
        tMP.setVisible(true);
    }

    /**
     * Creates new form TelaMultaPagamento
     */
    public TelaMultaPagamento() {
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        setTitle("Pagamento Multa");
        tfLeitor.setText(multa.getExemplarEmprestimo().getEmprestimo().getLeitor().getNome());
        tfTitulo.setText(multa.getExemplarEmprestimo().getExemplar().getAcervo().getTituloObra());
        tfTombo.setText(String.valueOf(multa.getExemplarEmprestimo().getExemplar().getTombo()));
        tfValor.setText(String.valueOf(multa.getValor()));
        Date dtPagamento = new Date();
        SimpleDateFormat dfdtPagamento;
        dfdtPagamento = new SimpleDateFormat("dd/MM/yyyy");
        tfDtpagamento.setText(dfdtPagamento.format(dtPagamento));
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

        jPanel3 = new javax.swing.JPanel();
        btSalvar2 = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        Descricao_Biblioteca = new javax.swing.JLabel();
        tfLeitor = new javax.swing.JTextField();
        tfTombo = new javax.swing.JTextField();
        Descricao_Biblioteca1 = new javax.swing.JLabel();
        tfTitulo = new javax.swing.JTextField();
        Descricao_Biblioteca2 = new javax.swing.JLabel();
        tfValor = new javax.swing.JTextField();
        Descricao_Biblioteca3 = new javax.swing.JLabel();
        tfDtpagamento = new javax.swing.JTextField();
        Descricao_Biblioteca4 = new javax.swing.JLabel();
        cbPago = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(432, 177));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btSalvar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/save_1.png"))); // NOI18N
        btSalvar2.setToolTipText("Salvar");
        btSalvar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvar2ActionPerformed(evt);
            }
        });
        jPanel3.add(btSalvar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 40, 33));

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/SA.png"))); // NOI18N
        btSair.setToolTipText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel3.add(btSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, -1));

        jPanel4.setBackground(new java.awt.Color(59, 89, 152));
        jPanel4.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Pagamento Multa");
        jPanel4.add(jLabel23);
        jLabel23.setBounds(0, 0, 260, 30);

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 35));

        Descricao_Biblioteca.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Descricao_Biblioteca.setText("Leitor:");
        jPanel3.add(Descricao_Biblioteca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 46, -1, 29));

        tfLeitor.setEditable(false);
        tfLeitor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfLeitor.setToolTipText("");
        jPanel3.add(tfLeitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 76, 380, -1));

        tfTombo.setEditable(false);
        tfTombo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfTombo.setToolTipText("");
        jPanel3.add(tfTombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 80, -1));

        Descricao_Biblioteca1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Descricao_Biblioteca1.setText("Tombo.:");
        jPanel3.add(Descricao_Biblioteca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 29));

        tfTitulo.setEditable(false);
        tfTitulo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfTitulo.setToolTipText("");
        jPanel3.add(tfTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 290, -1));

        Descricao_Biblioteca2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Descricao_Biblioteca2.setText("Título");
        jPanel3.add(Descricao_Biblioteca2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, 29));

        tfValor.setEditable(false);
        tfValor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfValor.setToolTipText("");
        jPanel3.add(tfValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 80, -1));

        Descricao_Biblioteca3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Descricao_Biblioteca3.setText("Valor.:");
        jPanel3.add(Descricao_Biblioteca3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 29));

        tfDtpagamento.setEditable(false);
        tfDtpagamento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfDtpagamento.setToolTipText("");
        jPanel3.add(tfDtpagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 110, -1));

        Descricao_Biblioteca4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Descricao_Biblioteca4.setText("Dt.Pagamento.:");
        jPanel3.add(Descricao_Biblioteca4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, 29));

        cbPago.setBackground(new java.awt.Color(255, 255, 255));
        cbPago.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbPago.setText("Pago");
        jPanel3.add(cbPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvar2ActionPerformed
        MultaRN multaRN = new MultaRN();
        multa.setPago(cbPago.isSelected());
        multa.setDataPagamento(new Date());
        multaRN.salvar(multa);
        if (cbPago.isSelected()) {
            JasperReport pathjrxml;
            HashMap parametros = new HashMap();
            String sql = "", texto = "";
            sql += " where m.idmulta=" + multa.getIdMulta();
            parametros.put("sql", sql);
            BibliotecaRN bRN = new BibliotecaRN();
            try {
                parametros.put("biblioteca", bRN.listar().get(0).getDescricao());
            } catch (Exception e) {
            }
            parametros.put("leitor", multa.getExemplarEmprestimo().getEmprestimo().getLeitor().getNome());
            Connection connection = new ConnectionFactory().getConnection();
            try {
                JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
                viewer.setSize(1000, 600);
                viewer.setLocationRelativeTo(null);
                viewer.setModal(true);
                pathjrxml = JasperCompileManager.compileReport("src/relatorios/RelReciboMulta.jrxml");
                JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, parametros,
                        connection);
                //JasperExportManager.exportReportToPdfFile(printReport, "src/relatorios/RelMulta.pdf");
                JasperViewer jv = new JasperViewer(printReport, false);
                viewer.getContentPane().add(jv.getContentPane());
                viewer.setVisible(true);
                //jv.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dispose();
    }//GEN-LAST:event_btSalvar2ActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMultaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMultaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMultaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMultaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMultaPagamento().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Descricao_Biblioteca;
    private javax.swing.JLabel Descricao_Biblioteca1;
    private javax.swing.JLabel Descricao_Biblioteca2;
    private javax.swing.JLabel Descricao_Biblioteca3;
    private javax.swing.JLabel Descricao_Biblioteca4;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar2;
    private javax.swing.JCheckBox cbPago;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField tfDtpagamento;
    private javax.swing.JTextField tfLeitor;
    private javax.swing.JTextField tfTitulo;
    private javax.swing.JTextField tfTombo;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables
}
