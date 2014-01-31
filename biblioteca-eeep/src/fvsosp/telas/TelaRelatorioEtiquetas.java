/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.telas;

import fvsosp.biblioteca.BibliotecaRN;
import fvsosp.exemplar.Exemplar;
import fvsosp.exemplar.ExemplarRN;
import fvsosp.exemplar.ExemplarTableModel;
import fvsosp.sessao.Sessao;
import fvsosp.sessao.SessaoRN;
import fvsosp.tipoitem.TipoItem;
import fvsosp.tipoitem.TipoItemRN;
import fvsosp.util.ConnectionFactory;
import fvsosp.util.FormataTamanhoColunasJTable;
import fvsosp.util.OnlyNumberField;
import fvsosp.util.Util;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaRelatorioEtiquetas extends javax.swing.JDialog {

    /**
     * Creates new form TelaRelatorioAcervo
     */
    public TelaRelatorioEtiquetas() {
        initComponents();
        atualizaTabela();
        setLocationRelativeTo(null);
        setModal(true);
        tfTomboFinal.setDocument(new OnlyNumberField());
        tfTomboInicial.setDocument(new OnlyNumberField());
        tfTomboInicial.grabFocus();
        
    }
    private List<Exemplar> exemplares = new ArrayList<Exemplar>();

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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tfTomboInicial = new javax.swing.JTextField();
        tfTomboFinal = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório Etiquetas");
        setModal(true);
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
        jPanel1.add(btSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, -1, -1));

        jPanel3.setBackground(new java.awt.Color(59, 89, 152));
        jPanel3.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Etiquetas");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(0, 0, 330, 30);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 492, 35));

        btImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/imprimir2.png"))); // NOI18N
        btImprimir.setToolTipText("Sair");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Exemplar");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Tombo Inicial.:");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Tombo Final.:");

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tfTomboInicial.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        tfTomboFinal.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jButton2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton2.setText("Limpar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTomboInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTomboFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jButton1)
                    .addComponent(tfTomboInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTomboFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 46, -1, -1));

        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tb);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 470, 210));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );

        Util.setAcessibilidade(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        // TODO add your handling code here:
        if (exemplares.size() > 0) {
            JasperReport pathjrxml;
            HashMap parametros = new HashMap();
            String sql = "", texto = "";

            
            sql+=" where exe.tombo in (";
            
            Iterator<Exemplar> iterator = exemplares.iterator();
            while(iterator.hasNext()){
                Exemplar exe = iterator.next();
                sql+=exe.getTombo();
                if(iterator.hasNext()){
                    sql+=",";
                }
            }
            sql+=") order by exe.tombo,a.idacervo";
            parametros.put("sql", sql);
            
            BibliotecaRN bRN = new BibliotecaRN();
            try {
                parametros.put("biblioteca", bRN.listar().get(0).getDescricao());
            } catch (Exception e) {
            }



            Connection connection = new ConnectionFactory().getConnection();
            try {
                JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
                viewer.setSize(1000, 600);
                viewer.setLocationRelativeTo(null);
                viewer.setModal(true);
                pathjrxml = JasperCompileManager.compileReport("src/relatorios/RelEtiquetas.jrxml");
                JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, parametros,
                        connection);
                JasperViewer jv = new JasperViewer(printReport, false);
                viewer.getContentPane().add(jv.getContentPane());
                viewer.setVisible(true);
                //JasperExportManager.exportReportToPdfFile(printReport, "src/relatorios/RelAcervo.pdf");

                //jv.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Não existem exemplares listados!");
        }
        //dispose();
        exemplares.clear();
        atualizaTabela();
        tfTomboFinal.setText("");
        tfTomboInicial.setText("");
        tfTomboInicial.grabFocus();

    }//GEN-LAST:event_btImprimirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (tfTomboInicial.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o tombo inicial!");
        } else if (tfTomboFinal.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o tombo final!");
        } else if (Integer.parseInt(tfTomboInicial.getText())
                > Integer.parseInt(tfTomboFinal.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Tombo Inicial não pode ser maior que o final!");
        } else {
           
            for (int i = Integer.parseInt(tfTomboInicial.getText()); i <= Integer.parseInt(tfTomboFinal.getText()); i++) {
                ExemplarRN eRN = new ExemplarRN();
                Exemplar exemplar = eRN.pesquisarTombo(Short.valueOf(String.valueOf(i)));
                if ((exemplar != null) && (exemplar.isAtivo())) {
                    exemplares.add(exemplar);
                }
            }
            atualizaTabela();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         exemplares.clear();
         atualizaTabela();
         tfTomboFinal.setText("");
         tfTomboInicial.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRelatorioEtiquetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioEtiquetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioEtiquetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioEtiquetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorioEtiquetas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btSair;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb;
    private javax.swing.JTextField tfTomboFinal;
    private javax.swing.JTextField tfTomboInicial;
    // End of variables declaration//GEN-END:variables

    private void atualizaTabela() {
        Collections.sort(exemplares);
        ExemplarTableModel etm = new ExemplarTableModel(exemplares);
        tb.setModel(etm);
        FormataTamanhoColunasJTable.packColumns(tb, 1);
    }
}
