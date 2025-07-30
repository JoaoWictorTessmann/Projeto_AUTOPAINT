/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TELAS;

import TELAS.TelaLista;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */

public class TelaModificar extends javax.swing.JFrame {

    public TelaModificar() {
        initComponents();

    }
    private TelaLista telaLista; // referência da tela principal

    public TelaModificar(TelaLista telaLista) {
        initComponents();
        this.telaLista = telaLista;
        bloquearCamposModificacao();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        // Garantir tamanho antes de escalar
        setSize(500, 600); // ou setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);//Centralizar na tela
        setLayout(null); // necessário para posicionamento manual

        jtfModSolicitarID.setOpaque(false);
        jtfModSolicitarID.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModSolicitarID.setForeground(java.awt.Color.WHITE);
        jtfModSolicitarID.setBackground(new Color(0, 0, 0, 0)); // Totalmente transparente
        jtfModSolicitarID.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));

        jbtModConfirmarID.setContentAreaFilled(false); // tira o fundo branco
        jbtModConfirmarID.setBorderPainted(false);     // tira a borda
        jbtModConfirmarID.setForeground(java.awt.Color.WHITE);
        jbtModConfirmarID.setOpaque(false);            // permite transparência
        jbtModConfirmarID.setFont(new Font("SansSerif", Font.BOLD, 20)); // ou outro tamanho
        jbtModConfirmarID.setForeground(new Color(255, 255, 255)); // cor branca ou como a cor do fundo

        jtfModNomeCliente.setOpaque(false);
        jtfModNomeCliente.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModNomeCliente.setForeground(java.awt.Color.WHITE);
        jtfModNomeCliente.setBackground(new Color(0, 0, 0, 0)); // Totalmente transparente
        jtfModNomeCliente.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));

        jtfModDescricao.setOpaque(false);
        jtfModDescricao.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModDescricao.setForeground(java.awt.Color.WHITE);
        jtfModDescricao.setBackground(new Color(0, 0, 0, 0)); // Totalmente transparente
        jtfModDescricao.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));

        jtfModModeloVei.setOpaque(false);
        jtfModModeloVei.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModModeloVei.setForeground(java.awt.Color.WHITE);
        jtfModModeloVei.setBackground(new Color(0, 0, 0, 0)); // Totalmente transparente
        jtfModModeloVei.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));

        jtfModPlaca.setOpaque(false);
        jtfModPlaca.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModPlaca.setForeground(java.awt.Color.WHITE);
        jtfModPlaca.setBackground(new Color(0, 0, 0, 0)); // Totalmente transparente
        jtfModPlaca.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));

        jtfModValor.setOpaque(false);
        jtfModValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModValor.setForeground(java.awt.Color.WHITE);
        jtfModValor.setBackground(new Color(0, 0, 0, 0)); // Totalmente transparente
        jtfModValor.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));

        jtfModTempoEst.setOpaque(false);
        jtfModTempoEst.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModTempoEst.setForeground(java.awt.Color.WHITE);
        jtfModTempoEst.setBackground(new Color(0, 0, 0, 0)); // Totalmente transparente
        jtfModTempoEst.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));

        jbtModificarPedido.setContentAreaFilled(false); // tira o fundo branco
        jbtModificarPedido.setBorderPainted(false);     // tira a borda
        jbtModificarPedido.setForeground(java.awt.Color.BLACK);
        jbtModificarPedido.setOpaque(false);            // permite transparência
        jbtModificarPedido.setFont(new Font("SansSerif", Font.BOLD, 30)); // ou outro tamanho
        jbtModificarPedido.setForeground(new Color(255, 255, 255)); // cor branca ou como a cor do fundo

        ImageIcon imagemOriginal = DAO.ImagemTelas.getImagem("telamodificar");

        if (imagemOriginal != null) {
            // Escala a imagem de acordo com a tela
            Image imagem = imagemOriginal.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            JLabel fundo = new JLabel(new ImageIcon(imagem));
            fundo.setBounds(0, 0, getWidth(), getHeight());

            // Adiciona a imagem atrás dos componentes
            getContentPane().add(fundo);
            getContentPane().setComponentZOrder(fundo, getContentPane().getComponentCount() - 1);
        } else {
            System.out.println("Imagem de fundo não encontrada.");
        }
    }

    private void habilitarCamposModificacao() {
        jtfModNomeCliente.setEnabled(true);
        jtfModDescricao.setEnabled(true);
        jtfModModeloVei.setEnabled(true);
        jtfModPlaca.setEnabled(true);
        jtfModValor.setEnabled(true);
        jtfModTempoEst.setEnabled(true);
        jbtModificarPedido.setEnabled(true); // botão de modificar
    }

    private void bloquearCamposModificacao() {
        jtfModNomeCliente.setEnabled(false);
        jtfModDescricao.setEnabled(false);
        jtfModModeloVei.setEnabled(false);
        jtfModPlaca.setEnabled(false);
        jtfModValor.setEnabled(false);
        jtfModTempoEst.setEnabled(false);
        jbtModificarPedido.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtModificarPedido = new javax.swing.JButton();
        jtfModValor = new javax.swing.JTextField();
        jtfModTempoEst = new javax.swing.JTextField();
        jtfModPlaca = new javax.swing.JTextField();
        jtfModModeloVei = new javax.swing.JTextField();
        jtfModDescricao = new javax.swing.JTextField();
        jtfModNomeCliente = new javax.swing.JTextField();
        jbtModConfirmarID = new javax.swing.JButton();
        jtfModSolicitarID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtModificarPedido.setText("Modificar Pedido");
        jbtModificarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtModificarPedidoActionPerformed(evt);
            }
        });

        jtfModTempoEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfModTempoEstActionPerformed(evt);
            }
        });

        jbtModConfirmarID.setText("Confirmar ID");
        jbtModConfirmarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtModConfirmarIDActionPerformed(evt);
            }
        });

        jtfModSolicitarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfModSolicitarIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jtfModValor)
                                .addGap(29, 29, 29)
                                .addComponent(jtfModTempoEst, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfModModeloVei, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(jtfModSolicitarID)
                                    .addComponent(jtfModNomeCliente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jtfModDescricao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                        .addComponent(jtfModPlaca))
                                    .addComponent(jbtModConfirmarID, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(73, Short.MAX_VALUE)
                        .addComponent(jbtModificarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(203, 203, 203))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfModSolicitarID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtModConfirmarID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfModNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfModDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfModModeloVei, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfModPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfModTempoEst, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jtfModValor))
                .addGap(18, 18, 18)
                .addComponent(jbtModificarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfModTempoEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfModTempoEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfModTempoEstActionPerformed

    private void jtfModSolicitarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfModSolicitarIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfModSolicitarIDActionPerformed

    private void jbtModConfirmarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtModConfirmarIDActionPerformed
        try {
            int idSolicitado = Integer.parseInt(jtfModSolicitarID.getText().trim());

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_autopaint", "root", "")) {
                String sql = "SELECT * FROM servicos WHERE id_servico = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, idSolicitado);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    String status = rs.getString("status_servico");

                    if (!"PENDENTE".equalsIgnoreCase(status)) {
                        new TelaErroAdd("Este pedido não pode ser modificado.<br>Status atual: " + status).setVisible(true);
                        jtfModSolicitarID.setText("");
                        jtfModSolicitarID.requestFocus();
                        bloquearCamposModificacao();
                        return;
                    }

                    // Status é PENDENTE → libera os campos e preenche os dados
                    habilitarCamposModificacao();

                    String cliente = rs.getString("nome_cliente");
                    String descricao = rs.getString("descricao");
                    String modelo = rs.getString("modelo_carro");
                    String placa = rs.getString("placa");
                    double valor = rs.getDouble("valor");
                    int tempo = rs.getInt("tempo_estimado");

                    jtfModNomeCliente.setText(cliente);
                    jtfModDescricao.setText(descricao);
                    jtfModModeloVei.setText(modelo);
                    jtfModPlaca.setText(placa);
                    jtfModValor.setText(String.valueOf(valor));
                    jtfModTempoEst.setText(String.valueOf(tempo));

                } else {
                    new TelaErroAdd("ID não encontrado.").setVisible(true);
                    jtfModSolicitarID.setText("");
                    jtfModSolicitarID.requestFocus();
                    bloquearCamposModificacao();
                }

            }

        } catch (NumberFormatException e) {
            new TelaErroAdd("Digite um número válido para o ID.").setVisible(true);
            jtfModSolicitarID.setText("");
            jtfModSolicitarID.requestFocus();
            bloquearCamposModificacao();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + e.getMessage());
            bloquearCamposModificacao();
        }

    }//GEN-LAST:event_jbtModConfirmarIDActionPerformed

    private void jbtModificarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtModificarPedidoActionPerformed
        try {
            int idSolicitado = Integer.parseInt(jtfModSolicitarID.getText());

            //  Captura dos dados como texto
            String cliente = jtfModNomeCliente.getText();
            String descricao = jtfModDescricao.getText();
            String modelo = jtfModModeloVei.getText();
            String placa = jtfModPlaca.getText();
            String textoValor = jtfModValor.getText();
            String textoTempo = jtfModTempoEst.getText();

            //  Validação dos campos de texto
            if (cliente == null || cliente.trim().isEmpty()) {
                new TelaErroAdd("O campo 'Cliente' não pode estar vazio.").setVisible(true);
                return;
            }
            if (descricao == null || descricao.trim().isEmpty()) {
                new TelaErroAdd("O campo 'Descrição' não pode estar vazio.").setVisible(true);
                return;
            }
            if (modelo == null || modelo.trim().isEmpty()) {
                new TelaErroAdd("O campo 'Modelo do Carro' não pode estar vazio.").setVisible(true);
                return;
            }
            if (placa == null || placa.trim().isEmpty()) {
                new TelaErroAdd("O campo 'Placa' não pode estar vazio.").setVisible(true);
                return;
            }
            if (textoValor == null || textoValor.trim().isEmpty()) {
                new TelaErroAdd("O campo 'Valor' não pode estar vazio.").setVisible(true);
                return;
            }
            if (textoTempo == null || textoTempo.trim().isEmpty()) {
                new TelaErroAdd("O campo 'Tempo Estimado' não pode estar vazio.").setVisible(true);
                return;
            }

            // Conversão segura
            double valor;
            int tempo;

            try {
                valor = Double.parseDouble(textoValor);
                tempo = Integer.parseInt(textoTempo);
            } catch (NumberFormatException e) {
                new TelaErroAdd("Valor ou tempo estimado inválido. Use apenas números.").setVisible(true);
                return;
            }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_autopaint", "root", "")) {
            String sql = "UPDATE servicos SET nome_cliente = ?, descricao = ?, modelo_carro = ?, placa = ?, valor = ?, tempo_estimado = ? WHERE id_servico = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente);
            stmt.setString(2, descricao);
            stmt.setString(3, modelo);
            stmt.setString(4, placa);
            stmt.setDouble(5, valor);
            stmt.setInt(6, tempo);
            stmt.setInt(7, idSolicitado);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                new TelaAddSucesso("Pedido Modificado Com Sucesso!").setVisible(true);
                telaLista.carregarPedidos();
                this.dispose();
            } else {
                new TelaErroAdd("Nenhum pedido foi modificado. Verifique o ID.").setVisible(true);
            }
        }

    }
    catch (NumberFormatException e

    
        ) {
            new TelaErroAdd("ID, valor ou tempo inválido.").setVisible(true);
    }
    catch (SQLException e

    
        ) {
        new TelaErroAdd("Erro ao modificar pedido: " + e.getMessage()).setVisible(true);
    }
    }//GEN-LAST:event_jbtModificarPedidoActionPerformed

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
        java.util.logging.Logger.getLogger(TelaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(TelaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(TelaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(TelaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new TelaModificar().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtModConfirmarID;
    private javax.swing.JButton jbtModificarPedido;
    private javax.swing.JTextField jtfModDescricao;
    private javax.swing.JTextField jtfModModeloVei;
    private javax.swing.JTextField jtfModNomeCliente;
    private javax.swing.JTextField jtfModPlaca;
    private javax.swing.JTextField jtfModSolicitarID;
    private javax.swing.JTextField jtfModTempoEst;
    private javax.swing.JTextField jtfModValor;
    // End of variables declaration//GEN-END:variables
}
