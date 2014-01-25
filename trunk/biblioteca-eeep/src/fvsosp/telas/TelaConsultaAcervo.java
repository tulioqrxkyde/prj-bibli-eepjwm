package fvsosp.telas;

import fvsosp.acervo.Acervo;
import fvsosp.acervo.AcervoRN;
import fvsosp.autor.Autor;
import fvsosp.autor.AutorRN;
import fvsosp.editora.Editora;
import fvsosp.editora.EditoraRN;
import fvsosp.idioma.Idioma;
import fvsosp.idioma.IdiomaRN;
import fvsosp.palavraschaves.PalavrasChaves;
import fvsosp.palavraschaves.PalavrasChavesRN;
import fvsosp.sessao.Sessao;
import fvsosp.sessao.SessaoRN;
import fvsosp.tipoitem.TipoItem;
import fvsosp.tipoitem.TipoItemRN;
import fvsosp.util.Util;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 *
 * @author Tulio
 */
public class TelaConsultaAcervo extends javax.swing.JDialog {

    /**
     * Construtor
     */
    public TelaConsultaAcervo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn1 = new javax.swing.JPanel();
        labelConsultaAcervos = new javax.swing.JLabel();
        pn2 = new javax.swing.JPanel();
        btPesquisar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tbConsulta = new javax.swing.JTable();
        labelConsultarAcervo1 = new javax.swing.JLabel();
        labelConsultarAcervo2 = new javax.swing.JLabel();
        labelConsultarAcervo3 = new javax.swing.JLabel();
        labelConsultarAcervo4 = new javax.swing.JLabel();
        labelConsultarAcervo5 = new javax.swing.JLabel();
        tfTipoItem = new javax.swing.JTextField();
        tfAutor = new javax.swing.JTextField();
        tfTitulo = new javax.swing.JTextField();
        tfSessao = new javax.swing.JTextField();
        labelConsultarAcervo6 = new javax.swing.JLabel();
        labelConsultarAcervo7 = new javax.swing.JLabel();
        tfPalavrasChaves = new javax.swing.JTextField();
        tfIdioma = new javax.swing.JTextField();
        labelConsultarAcervo8 = new javax.swing.JLabel();
        tfIsbn = new javax.swing.JFormattedTextField();
        tfAnoEdicao = new javax.swing.JFormattedTextField();
        labelConsultarAcervo9 = new javax.swing.JLabel();
        tfEditora = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("OSBiblio - Consulta de Acervos");
        setModal(true);
        setResizable(false);

        pn1.setBackground(new java.awt.Color(59, 89, 152));
        pn1.setLayout(null);

        labelConsultaAcervos.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        labelConsultaAcervos.setForeground(new java.awt.Color(255, 255, 255));
        labelConsultaAcervos.setText("Consulta de Acervos");
        pn1.add(labelConsultaAcervos);
        labelConsultaAcervos.setBounds(0, 0, 280, 30);

        pn2.setBackground(new java.awt.Color(255, 255, 255));
        pn2.setPreferredSize(new java.awt.Dimension(432, 177));
        pn2.setLayout(null);

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/procurar_1.png"))); // NOI18N
        btPesquisar.setToolTipText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });
        pn2.add(btPesquisar);
        btPesquisar.setBounds(170, 350, 37, 33);

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/SA.png"))); // NOI18N
        btSair.setToolTipText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        pn2.add(btSair);
        btSair.setBounds(210, 350, 57, 33);

        tbConsulta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Consulta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbConsulta.setSurrendersFocusOnKeystroke(true);
        tbConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbConsultaMouseClicked(evt);
            }
        });
        tbConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbConsultaKeyPressed(evt);
            }
        });
        scrollPane.setViewportView(tbConsulta);

        pn2.add(scrollPane);
        scrollPane.setBounds(20, 200, 390, 140);

        labelConsultarAcervo1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelConsultarAcervo1.setText("Tipo de Item.:");
        pn2.add(labelConsultarAcervo1);
        labelConsultarAcervo1.setBounds(190, 100, 90, 16);

        labelConsultarAcervo2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelConsultarAcervo2.setText("Autor.:");
        pn2.add(labelConsultarAcervo2);
        labelConsultarAcervo2.setBounds(20, 10, 43, 16);

        labelConsultarAcervo3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelConsultarAcervo3.setText("Título.:");
        pn2.add(labelConsultarAcervo3);
        labelConsultarAcervo3.setBounds(20, 40, 50, 16);

        labelConsultarAcervo4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelConsultarAcervo4.setText("Isbn.:");
        pn2.add(labelConsultarAcervo4);
        labelConsultarAcervo4.setBounds(20, 70, 40, 16);

        labelConsultarAcervo5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelConsultarAcervo5.setText("Ano de Edição.:");
        pn2.add(labelConsultarAcervo5);
        labelConsultarAcervo5.setBounds(190, 70, 100, 16);
        pn2.add(tfTipoItem);
        tfTipoItem.setBounds(310, 100, 100, 20);
        pn2.add(tfAutor);
        tfAutor.setBounds(80, 10, 100, 20);

        tfTitulo.setToolTipText("");
        pn2.add(tfTitulo);
        tfTitulo.setBounds(80, 40, 210, 20);
        pn2.add(tfSessao);
        tfSessao.setBounds(80, 100, 100, 20);

        labelConsultarAcervo6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelConsultarAcervo6.setText("Sessão.:");
        pn2.add(labelConsultarAcervo6);
        labelConsultarAcervo6.setBounds(20, 100, 60, 16);

        labelConsultarAcervo7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelConsultarAcervo7.setText("Palavras Chaves.:");
        pn2.add(labelConsultarAcervo7);
        labelConsultarAcervo7.setBounds(190, 130, 130, 16);
        pn2.add(tfPalavrasChaves);
        tfPalavrasChaves.setBounds(310, 130, 100, 20);
        pn2.add(tfIdioma);
        tfIdioma.setBounds(80, 130, 100, 20);

        labelConsultarAcervo8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelConsultarAcervo8.setText("Idioma.:");
        pn2.add(labelConsultarAcervo8);
        labelConsultarAcervo8.setBounds(20, 130, 60, 16);

        try {
            tfIsbn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfIsbn.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        pn2.add(tfIsbn);
        tfIsbn.setBounds(80, 70, 100, 20);

        try {
            tfAnoEdicao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfAnoEdicao.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        pn2.add(tfAnoEdicao);
        tfAnoEdicao.setBounds(310, 70, 100, 20);

        labelConsultarAcervo9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelConsultarAcervo9.setText("Editora.:");
        pn2.add(labelConsultarAcervo9);
        labelConsultarAcervo9.setBounds(20, 160, 54, 16);
        pn2.add(tfEditora);
        tfEditora.setBounds(80, 160, 100, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pn1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pn2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        Util.setAcessibilidade(this);     this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "ENTER");         this.getRootPane().getRootPane().getActionMap().put("ENTER", new AbstractAction("ENTER") {             @Override             public void actionPerformed(ActionEvent e) {                 if (JOptionPane.showConfirmDialog(null, "Deseja pesquisar?", "Pesquisar por Acervo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {                     btPesquisarActionPerformed(null);                 }             }         });

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        if (tfAutor.getText().isEmpty() && tfTitulo.getText().isEmpty() && tfIsbn.getText().isEmpty()
                && tfAnoEdicao.getText().isEmpty() && tfSessao.getText().isEmpty() && tfTipoItem.getText().isEmpty()
                && tfIdioma.getText().isEmpty() && tfPalavrasChaves.getText().isEmpty() && tfEditora.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha pelo menos um campo!");
            return;
        }
        limpar(false);
        AcervoRN acervoRN = new AcervoRN();
        List<Autor> autores = new ArrayList<>();
        List<PalavrasChaves> palavrasChaves = new ArrayList<>();
        List<String> camposStr = new ArrayList<>(), sqlFields = new ArrayList<>();
        List resultadosAutor = new ArrayList<>(), resultadosPalavrasChaves = new ArrayList<>();
        List<JTextField> tfs = new ArrayList<>();
        if (!tfAutor.getText().isEmpty()) {
            AutorRN autorRN = new AutorRN();
            autores = autorRN.pesquisarNome(tfAutor.getText());
            if (!Util.chkSize(autores, "Autor")) {
                return;
            }
            for (Autor a : autores) {
                resultadosAutor = acervoRN.pesquisarAutorQuery("SELECT autoresacervo.idAcervo FROM autoresacervo INNER JOIN autor ON autoresacervo.idAutor= "
                        + a.getIdAutor() + " AND autor.idAutor = " + a.getIdAutor() + "");
            }
        }
        if (!tfTitulo.getText().isEmpty()) {
            List<Acervo> listaTitulos = (List<Acervo>) acervoRN.pesquisarTitulodaObra(tfTitulo.getText());
            if (!Util.chkSize(listaTitulos, "Título da Obra")) {
                return;
            }
            camposStr.add(0, tfTitulo.getText());
            sqlFields.add("tituloObra");
            tfs.add(tfs.size(), tfTitulo);
        }
        if (!tfAnoEdicao.getText().replaceAll(" ", "").isEmpty()) {
            Short s = new Short(tfAnoEdicao.getText().replaceAll(" ", ""));
            List<Acervo> listaAnoEdicao = (List<Acervo>) acervoRN.pesquisaranoEdicao(s.shortValue());
            if (!Util.chkSize(listaAnoEdicao, "Ano de Edição")) {
                return;
            }
            sqlFields.add("anoEdicao");
            camposStr.add(camposStr.size(), s.toString());
            tfs.add(tfs.size(), tfAnoEdicao);
        }
        if (!tfIsbn.getText().replaceAll(" ", "").isEmpty()) {
            String s = String.valueOf((tfIsbn.getText().replaceAll(" ", "")));
            List<Acervo> listaIsbns = acervoRN.pesquisarIsbn(s);
            if (!Util.chkSize(listaIsbns, "Isbn")) {
                return;
            }
            sqlFields.add("isbn");
            camposStr.add(camposStr.size(), s);
            tfs.add(tfs.size(), tfIsbn);
        }
        if (!tfSessao.getText().isEmpty()) {
            SessaoRN sessoes = new SessaoRN();
            List<Sessao> listaSessao = (List<Sessao>) sessoes.pesquisarDescricaoLike(tfSessao.getText());
            if (!Util.chkSize(listaSessao, "Sessão")) {
                return;
            }
            camposStr.add(camposStr.size(), String.valueOf(listaSessao.get(0).getIdSessao()));
            sqlFields.add("idsessao");
            tfs.add(tfs.size(), tfSessao);
        }
        if (!tfTipoItem.getText().isEmpty()) {
            TipoItemRN tiposItens = new TipoItemRN();
            List<TipoItem> listaTipos = (List<TipoItem>) tiposItens.pesquisaDescricao(tfTipoItem.getText());
            if (!Util.chkSize(listaTipos, "Tipo de Item")) {
                return;
            }
            sqlFields.add("idtipoitem");
            camposStr.add(camposStr.size(), tfTipoItem.getText());
            tfs.add(tfs.size(), tfTipoItem);
        }
        if (!tfIdioma.getText().isEmpty()) {
            IdiomaRN idiomas = new IdiomaRN();
            List<Idioma> listaIdiomas = (List<Idioma>) idiomas.pesquisaDescricao(tfIdioma.getText());
            if (!Util.chkSize(listaIdiomas, "Idioma")) {
                return;
            }
            sqlFields.add("ididioma");
            camposStr.add(camposStr.size(), tfIdioma.getText());
            tfs.add(tfs.size(), tfIdioma);
        }
        if (!tfPalavrasChaves.getText().isEmpty()) {
            PalavrasChavesRN palavrasChavesRN = new PalavrasChavesRN();
            palavrasChaves = palavrasChavesRN.pesquisarDescricao(tfPalavrasChaves.getText());
            if (!Util.chkSize(palavrasChaves, "PalavrasChaves")) {
                return;
            }
            for (PalavrasChaves p : palavrasChaves) {
                resultadosPalavrasChaves = acervoRN.pesquisarPalavrasChavesQuery("SELECT palavraschavesacervo.idAcervo FROM palavraschavesacervo INNER JOIN palavraschaves ON palavraschavesacervo.idPalavrasChaves= "
                        + p.getIdPalavrasChaves() + " AND palavraschaves.idPalavrasChaves = " + p.getIdPalavrasChaves() + "");
            }
        }
        if (!tfEditora.getText().isEmpty()) {
            EditoraRN editoras = new EditoraRN();
            List<Editora> listaEditoras = (List<Editora>) editoras.pesquisarNomeEditora(tfEditora.getText());
            if (!Util.chkSize(listaEditoras, "Editora")) {
                return;
            }
            sqlFields.add("ideditora");
            camposStr.add(camposStr.size(), String.valueOf(listaEditoras.get(0).getIdEditora()));
            tfs.add(tfs.size(), tfEditora);
        }
        String sql = "";
        if (!tfs.isEmpty()) {
            sql += " SELECT * FROM acervo WHERE ";
            for (int j = 0; j < tfs.size(); j++) {
                sql += sqlFields.get(j);
                if (j == 0 && !tfTitulo.getText().isEmpty()) {
                    sql += " LIKE '" + tfTitulo.getText() + "%'";
                } else {
                    sql += " = " + Short.parseShort(camposStr.get(j));
                }
                if (j + 1 < tfs.size()) {
                    if (!tfs.get(j + 1).toString().isEmpty()) {
                        sql += " AND ";
                    }
                } else {
                    break;
                }
            }
        }

        List<Acervo> resultados;
        if (!camposStr.isEmpty()) {
            resultados = (List<Acervo>) acervoRN.consultaAcervo(sql);
            if (!resultados.isEmpty()) {
                if (autores.size() > 0) {
                    for (int h = 0; h < resultados.size(); h++) {
                        for (int i = 0; i < autores.size(); i++) {
                            if (!resultados.get(h).getAutores().contains(autores.get(i))) {
                                JOptionPane.showMessageDialog(rootPane, "Nenhum acervo foi encontrado.");
                                return;
                            }
                        }
                    }
                }
                if (palavrasChaves.size() > 0) {
                    for (int h = 0; h < resultados.size(); h++) {
                        for (int i = 0; i < palavrasChaves.size(); i++) {
                            if (!resultados.get(h).getPalavrasChaves().contains(palavrasChaves.get(i))) {
                                JOptionPane.showMessageDialog(rootPane, "Nenhum acervo foi encontrado.");
                                return;
                            }
                        }
                    }
                }
                tbConsulta.setValueAt(resultados.get(0), 0, 0);
            }
        } else if (resultadosAutor.size() > 0) {
            boolean finded = false;
            if (!resultadosPalavrasChaves.isEmpty()) {

                loops:
                for (Object autor : resultadosAutor) {
                    for (Object palavra : resultadosPalavrasChaves) {
                        if (acervoRN.pesquisarCodigo(Short.parseShort(palavra.toString()))
                                .getAutores().contains(acervoRN.pesquisarCodigo(
                                Short.parseShort(autor.toString())).getAutores().iterator().next())) {
                            finded = true;
                            break loops;
                        }
                    }
                }
            }
            if (finded) {
                for (int x = 0; x < resultadosAutor.size(); x++) {
                    tbConsulta.setValueAt((Acervo) acervoRN.pesquisarCodigo(Short.parseShort(resultadosAutor
                            .get(x).toString())), x, 0);
                }
            }
        } else if (resultadosPalavrasChaves.size() > 0 && tfAutor.getText().isEmpty()) {
            for (int x = 0; x < resultadosPalavrasChaves.size(); x++) {
                tbConsulta.setValueAt((Acervo) acervoRN.pesquisarCodigo(Short.parseShort(resultadosPalavrasChaves.get(x).toString())),
                        x, 0);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nenhum acervo foi encontrado.");
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void tbConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbConsultaKeyPressed
        tbConsulta.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "none");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 0) != null) {
            TelaConsultaResultados t = new TelaConsultaResultados((tbConsulta.
                    getValueAt((tbConsulta.getSelectedRow()), 0).toString()));
            t.setVisible(true);
        }
    }//GEN-LAST:event_tbConsultaKeyPressed

    private void tbConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbConsultaMouseClicked
        if (evt.getClickCount() == 2 && tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 0) != null) {
            TelaConsultaResultados t = new TelaConsultaResultados((tbConsulta.
                    getValueAt((tbConsulta.getSelectedRow()), 0).toString()));
            t.setVisible(true);
        }
    }//GEN-LAST:event_tbConsultaMouseClicked

    private void limpar(boolean... clearFields) {
        for (int x = 0; x < tbConsulta.getRowCount(); x++) {
            tbConsulta.setValueAt("", x, 0);
        }
        if (clearFields[0]) {
            JTextField[] tfs = {tfAutor, tfTitulo, tfIsbn, tfAnoEdicao, tfSessao, tfTipoItem, tfIdioma, tfPalavrasChaves, tfEditora};
            for (JTextField tf : tfs) {
                tf.setText("");
            }
        }
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
            java.util.logging.Logger.getLogger(TelaConsultaAcervo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaAcervo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaAcervo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaAcervo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaConsultaAcervo dialog = new TelaConsultaAcervo();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel labelConsultaAcervos;
    private javax.swing.JLabel labelConsultarAcervo1;
    private javax.swing.JLabel labelConsultarAcervo2;
    private javax.swing.JLabel labelConsultarAcervo3;
    private javax.swing.JLabel labelConsultarAcervo4;
    private javax.swing.JLabel labelConsultarAcervo5;
    private javax.swing.JLabel labelConsultarAcervo6;
    private javax.swing.JLabel labelConsultarAcervo7;
    private javax.swing.JLabel labelConsultarAcervo8;
    private javax.swing.JLabel labelConsultarAcervo9;
    private javax.swing.JPanel pn1;
    private javax.swing.JPanel pn2;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tbConsulta;
    private javax.swing.JFormattedTextField tfAnoEdicao;
    private javax.swing.JTextField tfAutor;
    private javax.swing.JTextField tfEditora;
    private javax.swing.JTextField tfIdioma;
    private javax.swing.JFormattedTextField tfIsbn;
    private javax.swing.JTextField tfPalavrasChaves;
    private javax.swing.JTextField tfSessao;
    private javax.swing.JTextField tfTipoItem;
    private javax.swing.JTextField tfTitulo;
    // End of variables declaration//GEN-END:variables
}
