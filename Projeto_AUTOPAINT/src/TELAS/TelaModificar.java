package TELAS;

// Importações necessárias para componentes visuais e banco de dados
import TELAS.TelaLista;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TelaModificar extends javax.swing.JFrame {

    public TelaModificar() {
        initComponents(); // Inicializa os componentes visuais da tela
    }

    // Referência à tela principal para permitir atualização após modificação
    private TelaLista telaLista;

    // Construtor principal que recebe a tela principal como parâmetro
    public TelaModificar(TelaLista telaLista) {
        initComponents(); // Inicializa os componentes visuais
        this.telaLista = telaLista; // Armazena referência da tela principal

        bloquearCamposModificacao(); // Bloqueia os campos até que um ID válido seja consultado

        // Configurações da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        setResizable(false); // Impede redimensionamento da janela
        setSize(500, 600); // Define tamanho fixo da tela
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(null); // Permite posicionamento manual dos componentes

        // Estilização do campo de ID
        jtfModSolicitarID.setOpaque(false);
        jtfModSolicitarID.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModSolicitarID.setForeground(Color.WHITE);
        jtfModSolicitarID.setBackground(new Color(0, 0, 0, 0));
        jtfModSolicitarID.setFont(new Font("SansSerif", Font.BOLD, 18));

        // Estilização do botão de confirmação de ID
        jbtModConfirmarID.setContentAreaFilled(true);
        jbtModConfirmarID.setBorderPainted(false);
        jbtModConfirmarID.setForeground(Color.WHITE);
        jbtModConfirmarID.setOpaque(false);
        jbtModConfirmarID.setFont(new Font("SansSerif", Font.BOLD, 20));
        jbtModConfirmarID.setBackground(new Color(10, 20, 40));

        // Estilização dos campos de modificação
        jtfModNomeCliente.setOpaque(false);
        jtfModNomeCliente.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModNomeCliente.setForeground(Color.WHITE);
        jtfModNomeCliente.setBackground(new Color(0, 0, 0, 0));
        jtfModNomeCliente.setFont(new Font("SansSerif", Font.BOLD, 18));

        jtfModDescricao.setOpaque(false);
        jtfModDescricao.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModDescricao.setForeground(Color.WHITE);
        jtfModDescricao.setBackground(new Color(0, 0, 0, 0));
        jtfModDescricao.setFont(new Font("SansSerif", Font.BOLD, 18));

        jtfModModeloVei.setOpaque(false);
        jtfModModeloVei.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModModeloVei.setForeground(Color.WHITE);
        jtfModModeloVei.setBackground(new Color(0, 0, 0, 0));
        jtfModModeloVei.setFont(new Font("SansSerif", Font.BOLD, 18));

        jtfModPlaca.setOpaque(false);
        jtfModPlaca.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModPlaca.setForeground(Color.WHITE);
        jtfModPlaca.setBackground(new Color(0, 0, 0, 0));
        jtfModPlaca.setFont(new Font("SansSerif", Font.BOLD, 18));

        jtfModValor.setOpaque(false);
        jtfModValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModValor.setForeground(Color.WHITE);
        jtfModValor.setBackground(new Color(0, 0, 0, 0));
        jtfModValor.setFont(new Font("SansSerif", Font.BOLD, 18));

        jtfModTempoEst.setOpaque(false);
        jtfModTempoEst.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfModTempoEst.setForeground(Color.WHITE);
        jtfModTempoEst.setBackground(new Color(0, 0, 0, 0));
        jtfModTempoEst.setFont(new Font("SansSerif", Font.BOLD, 18));

        // Estilização do botão de modificação
        jbtModificarPedido.setContentAreaFilled(true);
        jbtModificarPedido.setBorderPainted(false);
        jbtModificarPedido.setOpaque(false);
        jbtModificarPedido.setForeground(Color.WHITE);
        jbtModificarPedido.setFont(new Font("SansSerif", Font.BOLD, 30));
        jbtModificarPedido.setBackground(new Color(10, 20, 40));

        // Carregamento da imagem de fundo da tela
        ImageIcon imagemOriginal = DAO.ImagemTelas.getImagem("telamodificar");

        if (imagemOriginal != null) {
            // Redimensiona imagem para caber na tela
            Image imagem = imagemOriginal.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            JLabel fundo = new JLabel(new ImageIcon(imagem));
            fundo.setBounds(0, 0, getWidth(), getHeight());

            // Adiciona imagem como fundo da tela
            getContentPane().add(fundo);
            getContentPane().setComponentZOrder(fundo, getContentPane().getComponentCount() - 1);
        } else {
            // Mensagem de erro caso imagem não seja encontrada
            System.out.println("Imagem de fundo não encontrada.");
        }
    }

    // Habilita os campos de modificação após validação do ID
    private void habilitarCamposModificacao() {
        jtfModNomeCliente.setEnabled(true);
        jtfModDescricao.setEnabled(true);
        jtfModModeloVei.setEnabled(true);
        jtfModPlaca.setEnabled(true);
        jtfModValor.setEnabled(true);
        jtfModTempoEst.setEnabled(true);
        jbtModificarPedido.setEnabled(true);
    }

    // Bloqueia os campos de modificação até que um ID válido seja consultado
    private void bloquearCamposModificacao() {
        jtfModNomeCliente.setEnabled(false);
        jtfModDescricao.setEnabled(false);
        jtfModModeloVei.setEnabled(false);
        jtfModPlaca.setEnabled(false);
        jtfModValor.setEnabled(false);
        jtfModTempoEst.setEnabled(false);
        jbtModificarPedido.setEnabled(false);
    }

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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtModificarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfModValor)
                                .addGap(29, 29, 29)
                                .addComponent(jtfModTempoEst, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfModModeloVei, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(jtfModSolicitarID)
                                    .addComponent(jtfModNomeCliente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jbtModConfirmarID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jtfModDescricao, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfModPlaca))
                                        .addGap(9, 9, 9)))))))
                .addGap(183, 183, 183))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfModSolicitarID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtModConfirmarID, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jbtModificarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
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
            // Tenta converter o texto do campo para um número inteiro (ID do pedido)
            int idSolicitado = Integer.parseInt(jtfModSolicitarID.getText().trim());

            // Abre conexão com o banco de dados
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_autopaint", "root", "")) {
                // Consulta o pedido pelo ID informado
                String sql = "SELECT * FROM servicos WHERE id_servico = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, idSolicitado);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    // Obtém o status do pedido
                    String status = rs.getString("status_servico");

                    // Verifica se o pedido está em estado modificável
                    if (!"PENDENTE".equalsIgnoreCase(status)) {
                        new TelaErroAdd("Este pedido não pode ser modificado.<br>Status atual: " + status).setVisible(true);
                        jtfModSolicitarID.setText(""); // Limpa o campo de ID
                        jtfModSolicitarID.requestFocus(); // Foca novamente no campo
                        bloquearCamposModificacao(); // Bloqueia os campos de edição
                        return;
                    }

                    // Status é PENDENTE → libera os campos e preenche os dados
                    habilitarCamposModificacao();

                    // Captura os dados do pedido
                    String cliente = rs.getString("nome_cliente");
                    String descricao = rs.getString("descricao");
                    String modelo = rs.getString("modelo_carro");
                    String placa = rs.getString("placa");
                    double valor = rs.getDouble("valor");
                    String tempoEstimado = rs.getString("tempo_estimado");

                    // Formata o valor como moeda brasileira
                    NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                    String valorFormatado = formatoMoeda.format(valor); // Ex: R$ 100,00

                    // Preenche os campos com os dados do pedido
                    jtfModNomeCliente.setText(cliente);
                    jtfModDescricao.setText(descricao);
                    jtfModModeloVei.setText(modelo);
                    jtfModPlaca.setText(placa);
                    jtfModValor.setText(valorFormatado);
                    jtfModTempoEst.setText(String.valueOf(tempoEstimado));

                } else {
                    // Nenhum pedido encontrado com o ID informado
                    new TelaErroAdd("ID não encontrado.").setVisible(true);
                    jtfModSolicitarID.setText("");
                    jtfModSolicitarID.requestFocus();
                    bloquearCamposModificacao();
                }

            }

        } catch (NumberFormatException e) {
            // Erro ao converter o ID para número
            new TelaErroAdd("Digite um número válido para o ID.").setVisible(true);
            jtfModSolicitarID.setText("");
            jtfModSolicitarID.requestFocus();
            bloquearCamposModificacao();
        } catch (SQLException e) {
            // Erro de conexão ou execução de SQL
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + e.getMessage());
            bloquearCamposModificacao();
        }

    }//GEN-LAST:event_jbtModConfirmarIDActionPerformed

    private void jbtModificarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtModificarPedidoActionPerformed
        try {
            // Tenta converter o texto do campo para um número inteiro (ID do pedido)
            int idSolicitado = Integer.parseInt(jtfModSolicitarID.getText().trim());

            // Captura dos dados dos campos de texto
            String cliente = jtfModNomeCliente.getText().trim();
            String descricao = jtfModDescricao.getText().trim();
            String modelo = jtfModModeloVei.getText().trim();
            String placa = jtfModPlaca.getText().trim();
            String textoValor = jtfModValor.getText().trim();
            String textoTempo = jtfModTempoEst.getText().trim();

            // Validação dos campos obrigatórios
            if (cliente.isEmpty()) {
                new TelaErroAdd("O campo 'Cliente' não pode estar vazio.").setVisible(true);
                return;
            }
            if (descricao.isEmpty()) {
                new TelaErroAdd("O campo 'Descrição' não pode estar vazio.").setVisible(true);
                return;
            }
            if (modelo.isEmpty()) {
                new TelaErroAdd("O campo 'Modelo do Carro' não pode estar vazio.").setVisible(true);
                return;
            }
            if (placa.isEmpty()) {
                new TelaErroAdd("O campo 'Placa' não pode estar vazio.").setVisible(true);
                return;
            }
            if (textoValor.isEmpty()) {
                new TelaErroAdd("O campo 'Valor' não pode estar vazio.").setVisible(true);
                return;
            }
            if (textoTempo.isEmpty()) {
                new TelaErroAdd("O campo 'Tempo Estimado' não pode estar vazio.").setVisible(true);
                return;
            }

            // Conversão segura do valor para tipo double
            double valor;
            try {
                String valorLimpo = textoValor.replace("R$", "").replace(".", "").replace(",", ".").trim();
                valor = Double.parseDouble(valorLimpo);
            } catch (NumberFormatException e) {
                new TelaErroAdd("Valor inválido. Use o formato R$ 100,00.").setVisible(true);
                return;
            }

            // Tempo estimado permanece como texto livre
            String tempo = textoTempo;

            // Atualiza os dados no banco de dados
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_autopaint", "root", "")) {
                String sql = "UPDATE servicos SET nome_cliente = ?, descricao = ?, modelo_carro = ?, placa = ?, valor = ?, tempo_estimado = ? WHERE id_servico = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, cliente);
                stmt.setString(2, descricao);
                stmt.setString(3, modelo);
                stmt.setString(4, placa);
                stmt.setDouble(5, valor);
                stmt.setString(6, tempo);
                stmt.setInt(7, idSolicitado);

                int linhasAfetadas = stmt.executeUpdate();

                // Verifica se a atualização foi bem-sucedida
                if (linhasAfetadas > 0) {
                    new TelaAddSucesso("Pedido Modificado Com Sucesso!").setVisible(true);
                    telaLista.carregarPedidos(); // Atualiza a lista na tela principal
                    this.dispose(); // Fecha a tela de modificação
                } else {
                    new TelaErroAdd("Nenhum pedido foi modificado. Verifique o ID.").setVisible(true);
                }
            }

        } catch (NumberFormatException e) {
            // Erro ao converter o ID para número
            new TelaErroAdd("ID inválido.").setVisible(true);
        } catch (SQLException e) {
            // Erro de conexão ou execução de SQL
            new TelaErroAdd("Erro ao modificar pedido: " + e.getMessage()).setVisible(true);
        }
    }//GEN-LAST:event_jbtModificarPedidoActionPerformed

    public static void main(String args[]) {

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
