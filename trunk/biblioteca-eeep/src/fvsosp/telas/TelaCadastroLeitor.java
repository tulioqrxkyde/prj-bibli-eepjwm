package fvsosp.telas;

import fvsosp.cidade.Cidade;
import fvsosp.cidade.CidadeRN;
import fvsosp.grupoleitores.GruposLeitores;
import fvsosp.grupoleitores.GruposLeitoresRN;
import fvsosp.leitor.Leitor;
import fvsosp.leitor.LeitorRN;
import fvsosp.leitor.LeitorTableModel;
import fvsosp.util.Util;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaCadastroLeitor extends javax.swing.JDialog {

    Leitor leitor;
    LeitorRN leitorRN = new LeitorRN();

    /**
     * Creates new form TelaCadastroLeitor
     */
    public TelaCadastroLeitor() {
        initComponents();
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

        btGrSexo = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btPesquisar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        tbLeitor = new javax.swing.JTabbedPane();
        pn1 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        tfMatricula = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        tfCPF = new javax.swing.JFormattedTextField();
        jLabel26 = new javax.swing.JLabel();
        rbMasculino = new javax.swing.JRadioButton();
        rbFeminino = new javax.swing.JRadioButton();
        jLabel32 = new javax.swing.JLabel();
        tfDataNascimento = new javax.swing.JFormattedTextField();
        tfRG = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        pn2 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        tfCEP = new javax.swing.JFormattedTextField();
        tfCelular = new javax.swing.JFormattedTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        tfEndereco = new javax.swing.JTextField();
        tfBairro = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JFormattedTextField();
        jLabel34 = new javax.swing.JLabel();
        cbCidade = new javax.swing.JComboBox();
        pn3 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        tfNomePai = new javax.swing.JTextField();
        tfNomeMae = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        cbGrupoLeitores = new javax.swing.JComboBox();
        jLabel38 = new javax.swing.JLabel();

        setTitle("OSBiblio - Leitor");
        setModal(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(59, 89, 152));
        jPanel3.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Leitor");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(0, 0, 170, 30);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 35));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(432, 177));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/procurar_1.png"))); // NOI18N
        btPesquisar.setToolTipText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(btPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 37, 33));

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/SA.png"))); // NOI18N
        btSair.setToolTipText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel1.add(btSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, -1));

        btRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/remove_1.png"))); // NOI18N
        btRemover.setToolTipText("Excluir");
        btRemover.setEnabled(false);
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });
        jPanel1.add(btRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 37, 33));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/save_1.png"))); // NOI18N
        btSalvar.setToolTipText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 40, 33));

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fvsosp/imagens/novo_1.png"))); // NOI18N
        btNovo.setToolTipText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 42, 33));

        pn1.setBackground(new java.awt.Color(255, 255, 255));
        pn1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel31.setText("Matrícula");
        pn1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 29));

        tfMatricula.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfMatricula.setToolTipText("Digite aqui a descrição do autor");
        pn1.add(tfMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 150, -1));

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel25.setText("Nome.:");
        pn1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 29));

        tfNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfNome.setToolTipText("Digite aqui a descrição do autor");
        pn1.add(tfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 420, -1));

        jLabel28.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel28.setText("Data Nascimento.:");
        pn1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 29));

        try {
            tfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCPF.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCPFActionPerformed(evt);
            }
        });
        tfCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCPFFocusLost(evt);
            }
        });
        pn1.add(tfCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 150, -1));

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel26.setText("Sexo.:");
        pn1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, 29));

        rbMasculino.setBackground(new java.awt.Color(255, 255, 255));
        btGrSexo.add(rbMasculino);
        rbMasculino.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbMasculino.setText("Masculino");
        pn1.add(rbMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        rbFeminino.setBackground(new java.awt.Color(255, 255, 255));
        btGrSexo.add(rbFeminino);
        rbFeminino.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbFeminino.setText("Feminino");
        pn1.add(rbFeminino, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));

        jLabel32.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel32.setText("CPF.:");
        pn1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 29));

        try {
            tfDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataNascimento.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        tfDataNascimento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfDataNascimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftDataNascimentoFocusLost(evt);
            }
        });
        pn1.add(tfDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 150, -1));

        tfRG.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfRG.setToolTipText("Digite aqui a descrição do autor");
        pn1.add(tfRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 170, -1));

        jLabel33.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel33.setText("RG.:");
        pn1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, -1, 29));

        tbLeitor.addTab("Pessoais", pn1);

        pn2.setBackground(new java.awt.Color(255, 255, 255));
        pn2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel29.setText("Cidade.:");
        pn2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        try {
            tfCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCEP.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pn2.add(tfCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 150, -1));

        try {
            tfCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCelular.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pn2.add(tfCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 150, -1));

        jLabel30.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel30.setText("Celular.:");
        pn2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel27.setText("Email.:");
        pn2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 29));

        tfEmail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfEmail.setToolTipText("Digite aqui a descrição do autor");
        pn2.add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 380, -1));

        jLabel35.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel35.setText("Endereço.:");
        pn2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 29));

        tfEndereco.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfEndereco.setToolTipText("Digite aqui a descrição do autor");
        pn2.add(tfEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 380, -1));

        tfBairro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfBairro.setToolTipText("Digite aqui a descrição do autor");
        pn2.add(tfBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 150, -1));

        jLabel36.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel36.setText("Bairro.:");
        pn2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 29));

        jLabel37.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel37.setText("CEP.:");
        pn2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, 29));

        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfTelefone.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pn2.add(tfTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 150, -1));

        jLabel34.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel34.setText("Telefone.:");
        pn2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        cbCidade.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        CidadeRN cidRN = new CidadeRN();         for (Cidade cidade : cidRN.listar()) {             cbCidade.addItem(cidade);         }
        pn2.add(cbCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 230, -1));

        tbLeitor.addTab("Contato", pn2);

        pn3.setBackground(new java.awt.Color(255, 255, 255));
        pn3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel39.setText("Nome do Pai.:");
        pn3.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 29));

        tfNomePai.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfNomePai.setToolTipText("Digite aqui a descrição do autor");
        pn3.add(tfNomePai, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 380, -1));

        tfNomeMae.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfNomeMae.setToolTipText("Digite aqui a descrição do autor");
        pn3.add(tfNomeMae, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 380, -1));

        jLabel40.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel40.setText("Nome da Mãe.:");
        pn3.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 29));

        cbGrupoLeitores.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbGrupoLeitores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        GruposLeitoresRN grRN = new GruposLeitoresRN();         for (GruposLeitores gruposLeitores : grRN.listar()) {             cbGrupoLeitores.addItem(gruposLeitores);         }
        pn3.add(cbGrupoLeitores, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 380, -1));

        jLabel38.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel38.setText("Grupo de Leitores");
        pn3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        tbLeitor.addTab("Outras", pn3);

        jPanel1.add(tbLeitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 460, 310));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 460, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        List<Leitor> lista;
        lista = ((tfNome.getText() != null) ? leitorRN.pesquisaNome(tfNome.getText()) : leitorRN.listar());
        LeitorTableModel stm = new LeitorTableModel(lista);
        Object o = TelaPesquisa.exibeTela(stm, "leitor");
        if (o != null) {
            leitor = new Leitor();
            leitor = leitorRN.pesquisarCodigo((short) o);
            tfNome.setText(leitor.getNome());
            tfMatricula.setText(leitor.getMatricula().toString());
            tfDataNascimento.setText(String.valueOf(leitor.getDataCadastro()));
            if (leitor.getSexo() == 'F') {
                rbFeminino.setSelected(true);
            } else if (leitor.getSexo() == 'M') {
                rbMasculino.setSelected(true);
            }
            tfCPF.setText(leitor.getCpf());
            tfRG.setText(leitor.getRg());
            tfEndereco.setText(leitor.getEndereco());
            tfBairro.setText(leitor.getBairro());
            tfCEP.setText(leitor.getCep());
            cbCidade.setSelectedItem(((leitor.getCidade() != null) ? leitor.getCidade() : 0));
            tfTelefone.setText(leitor.getTelefone().toString());
            tfCelular.setText(leitor.getCelular().toString());
            tfEmail.setText(leitor.getEmail().toString());
            tfNomePai.setText(leitor.getNomePai().toString());
            tfNomeMae.setText(leitor.getNomeMae().toString());
            cbGrupoLeitores.setSelectedItem(((leitor.getGruposLeitores() != null) ? leitor.getGruposLeitores() : 0));
            limparCampos();
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        if (leitor != null) {
            if (leitor.getIdLeitor() != 0) {
                if (JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o leitor " + leitor.getNome()
                        + "?", "OSBiblio", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                    if (leitorRN.remove(leitor)) {
                        JOptionPane.showMessageDialog(rootPane, "Leitor " + leitor.getNome()
                                + ", excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Não foi possível excluir o leitor "
                                + leitor.getNome(),
                                "Erro ao Excluir", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        limparCampos();
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (leitor == null) {
            leitor = new Leitor();
        }
        leitor.setNome(tfNome.getText());
        leitor.setMatricula(tfMatricula.getText());
        String dataString = tfDataNascimento.getText();
        try {
            if (tfDataNascimento.getText().equals("  /  /    ")) {
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date data;
                data = new java.util.Date(fmt.parse(dataString).getTime());
                leitor.setDataNascimento(data);
            }
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        leitor.setSexo((rbFeminino.isSelected()) ? 'F' : 'M');
        leitor.setCpf(tfCPF.getText().replaceAll("\\D*", "")); //retira a máscara
        leitor.setRg(tfRG.getText());
        leitor.setEndereco(tfEndereco.getText());
        leitor.setBairro(tfBairro.getText());
        leitor.setCep(tfCEP.getText().replaceAll("\\D*", ""));
        if (cbCidade.getSelectedIndex() > 0) {
            Cidade cidade = (Cidade) cbCidade.getSelectedItem();
            leitor.setCidade(cidade);
        } else {
            leitor.setCidade(null);
        }
        leitor.setTelefone(tfTelefone.getText().replaceAll("\\D*", ""));
        leitor.setCelular(tfCelular.getText().replaceAll("\\D*", ""));
        leitor.setEmail(tfEmail.getText());
        leitor.setNomeMae(tfNomeMae.getText());
        leitor.setNomePai(tfNomeMae.getText());
        if (cbGrupoLeitores.getSelectedIndex() > 0) {
            GruposLeitores grupoLeitores = (GruposLeitores) cbGrupoLeitores.getSelectedItem();
            leitor.setGruposLeitores(grupoLeitores);
        } else {
            leitor.setGruposLeitores(null);
        }
        short tdLeitor = leitor.getIdLeitor();
        if (leitorRN.salvar(leitor)) {
            JOptionPane.showMessageDialog(rootPane, "Leitor " + leitor.getNome()
                    + ", " + ((tdLeitor == 0) ? "cadastrado" : "alterado") + " com sucesso!");
            limparCampos();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limparCampos();
    }//GEN-LAST:event_btNovoActionPerformed

    private void limparCampos() {
        leitor = null;
        btRemover.setEnabled(false);
        JTextField[] tfs = {tfBairro, tfCPF, tfNome, tfEmail, tfEndereco, tfMatricula, tfNomeMae, tfNomePai, tfRG,
            tfCelular, tfDataNascimento, tfCEP, tfTelefone};
        for (JTextField tf : tfs) {
            tf.setText("");
        }
        cbCidade.setSelectedIndex(0);
        cbGrupoLeitores.setSelectedIndex(0);
        btGrSexo.clearSelection();
    }

    private void tfCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCPFActionPerformed

    private void ftDataNascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftDataNascimentoFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ftDataNascimentoFocusLost

    private void tfCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCPFFocusLost
        // TODO add your handling code here:
        
        if(!Util.CPF(tfCPF.getText().toString().replaceAll("\\D*", ""))){
            JOptionPane.showMessageDialog(rootPane, "CPF Inválido!", 
                    "OSBiblio", JOptionPane.ERROR_MESSAGE);
            tfCPF.setText("");
        }
    }//GEN-LAST:event_tfCPFFocusLost
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
            java.util.logging.Logger.getLogger(TelaCadastroLeitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLeitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLeitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLeitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroLeitor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btGrSexo;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbCidade;
    private javax.swing.JComboBox cbGrupoLeitores;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel pn1;
    private javax.swing.JPanel pn2;
    private javax.swing.JPanel pn3;
    private javax.swing.JRadioButton rbFeminino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTabbedPane tbLeitor;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JFormattedTextField tfCEP;
    private javax.swing.JFormattedTextField tfCPF;
    private javax.swing.JFormattedTextField tfCelular;
    private javax.swing.JFormattedTextField tfDataNascimento;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfMatricula;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNomeMae;
    private javax.swing.JTextField tfNomePai;
    private javax.swing.JTextField tfRG;
    private javax.swing.JFormattedTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}