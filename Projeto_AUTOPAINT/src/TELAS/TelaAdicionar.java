package TELAS;

// Importações necessárias para componentes visuais e banco de dados
import DAO.Cons_Servico;
import TELAS.TelaLista;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class TelaAdicionar extends javax.swing.JFrame {

    // Construtor padrão (não utilizado diretamente neste contexto)
    public TelaAdicionar() {
        initComponents();
    }

    // Referência à tela principal para comunicação entre janelas
    private TelaLista telaLista;

    // Construtor principal que recebe a tela principal como parâmetro
    public TelaAdicionar(TelaLista telaLista) {
        initComponents(); // Inicializa os componentes visuais
        this.telaLista = telaLista; // Armazena referência da tela principal

        // Configurações da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        setSize(500, 550); // Define tamanho fixo da tela
        setLocationRelativeTo(null); // Centraliza na tela
        setLayout(null); // Permite posicionamento manual dos componentes
        setResizable(false); // Impede redimensionamento da janela

        // Estilização dos campos de texto (transparência, fonte, cor)
        jtfAddNomeCliente.setOpaque(false);
        jtfAddNomeCliente.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfAddNomeCliente.setForeground(Color.BLACK);
        jtfAddNomeCliente.setBackground(new Color(0, 0, 0, 0)); // Fundo totalmente transparente
        jtfAddNomeCliente.setFont(new Font("SansSerif", Font.BOLD, 14));

        jtfAddDescricao.setOpaque(false);
        jtfAddDescricao.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfAddDescricao.setForeground(Color.BLACK);
        jtfAddDescricao.setBackground(new Color(0, 0, 0, 0));
        jtfAddDescricao.setFont(new Font("SansSerif", Font.BOLD, 14));

        jtfAddModeloVei.setOpaque(false);
        jtfAddModeloVei.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfAddModeloVei.setForeground(Color.BLACK);
        jtfAddModeloVei.setBackground(new Color(0, 0, 0, 0));
        jtfAddModeloVei.setFont(new Font("SansSerif", Font.BOLD, 14));

        jtfAddPlaca.setOpaque(false);
        jtfAddPlaca.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfAddPlaca.setForeground(Color.BLACK);
        jtfAddPlaca.setBackground(new Color(0, 0, 0, 0));
        jtfAddPlaca.setFont(new Font("SansSerif", Font.BOLD, 14));

        jtfAddValor.setOpaque(false);
        jtfAddValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfAddValor.setForeground(Color.BLACK);
        jtfAddValor.setBackground(new Color(0, 0, 0, 0));
        jtfAddValor.setFont(new Font("SansSerif", Font.BOLD, 14));

        jtfAddTempoEst.setOpaque(false);
        jtfAddTempoEst.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jtfAddTempoEst.setForeground(Color.BLACK);
        jtfAddTempoEst.setBackground(new Color(0, 0, 0, 0));
        jtfAddTempoEst.setFont(new Font("SansSerif", Font.BOLD, 14));

        // Estilização do botão de adicionar pedido
        jbtAdicionarPedido.setBackground(new Color(20, 40, 60)); // Azul escuro
        jbtAdicionarPedido.setContentAreaFilled(true); // Ativa fundo do botão
        jbtAdicionarPedido.setBorderPainted(false); // Remove borda padrão
        jbtAdicionarPedido.setForeground(Color.WHITE); // Texto branco
        jbtAdicionarPedido.setOpaque(false); // Permite transparência
        jbtAdicionarPedido.setFont(new Font("SansSerif", Font.BOLD, 25)); // Fonte grande e em negrito

        // Carrega imagem de fundo da tela
        ImageIcon imagemOriginal = DAO.ImagemTelas.getImagem("telaadicionar");

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtAdicionarPedido = new javax.swing.JButton();
        jtfAddValor = new javax.swing.JTextField();
        jtfAddTempoEst = new javax.swing.JTextField();
        jtfAddPlaca = new javax.swing.JTextField();
        jtfAddModeloVei = new javax.swing.JTextField();
        jtfAddDescricao = new javax.swing.JTextField();
        jtfAddNomeCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtAdicionarPedido.setText("Adicionar Pedido");
        jbtAdicionarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAdicionarPedidoActionPerformed(evt);
            }
        });

        jtfAddTempoEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAddTempoEstActionPerformed(evt);
            }
        });

        jtfAddNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAddNomeClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfAddPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jtfAddValor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(39, 39, 39)
                                    .addComponent(jtfAddTempoEst, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jtfAddModeloVei, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfAddDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfAddNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jbtAdicionarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jtfAddNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jtfAddDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jtfAddModeloVei, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jtfAddPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfAddValor, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfAddTempoEst, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtAdicionarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfAddTempoEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAddTempoEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAddTempoEstActionPerformed

    private void jbtAdicionarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAdicionarPedidoActionPerformed
        // Captura e limpa os dados dos campos de texto
        String cliente = jtfAddNomeCliente.getText().trim();
        String descricao = jtfAddDescricao.getText().trim();
        String modeloCarro = jtfAddModeloVei.getText().trim();
        String placa = jtfAddPlaca.getText().trim();
        String textoValor = jtfAddValor.getText().replace("R$", "").replace(",", ".").trim(); // Remove símbolo e formata decimal
        String tempoEstimado = jtfAddTempoEst.getText().trim(); // Ex: "10 Horas", "3 Dias"

        double valor;

        // Validação de campos obrigatórios
        if (cliente.isEmpty()) {
            new TelaErroAdd("O campo 'Cliente' não pode estar vazio.").setVisible(true);
            return;
        }

        if (descricao.isEmpty()) {
            new TelaErroAdd("O campo 'Descrição' não pode estar vazio.").setVisible(true);
            return;
        }

        if (modeloCarro.isEmpty()) {
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

        if (tempoEstimado.isEmpty()) {
            new TelaErroAdd("O campo 'Tempo Estimado' não pode estar vazio.").setVisible(true);
            return;
        }

        // Conversão segura do valor para tipo double
        try {
            valor = Double.parseDouble(textoValor);
        } catch (NumberFormatException e) {
            new TelaErroAdd("Valor inválido. Use apenas números.").setVisible(true);
            return;
        }

        // Criação do objeto com os dados preenchidos
        Cons_Servico pedido = new Cons_Servico(cliente, descricao, modeloCarro, tempoEstimado, placa, valor);

        // Envio dos dados para o banco de dados
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_autopaint", "root", "")) {
            String sql = "INSERT INTO servicos (nome_cliente, descricao, modelo_carro, placa, valor, tempo_estimado) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Preenche os parâmetros da query com os dados do objeto
            stmt.setString(1, pedido.getCliente());
            stmt.setString(2, pedido.getDescricao());
            stmt.setString(3, pedido.getModeloCarro());
            stmt.setString(4, pedido.getPlaca());
            stmt.setDouble(5, pedido.getValor());
            stmt.setString(6, pedido.getTempoEstimado());

            stmt.executeUpdate(); // Executa inserção no banco

            // Atualiza a tela principal e fecha esta janela
            telaLista.carregarPedidos(); // Recarrega lista de pedidos
            this.dispose(); // Fecha a tela de adicionar

            // Exibe mensagem de sucesso
            TelaAddSucesso sucesso = new TelaAddSucesso("Pedido adicionado com sucesso!");
            sucesso.setVisible(true);

        } catch (SQLException e) {
            // Exibe mensagem de erro caso falhe a conexão ou inserção
            new TelaErroAdd("Erro ao adicionar pedido: " + e.getMessage()).setVisible(true);
        }
    }//GEN-LAST:event_jbtAdicionarPedidoActionPerformed

    private void jtfAddNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAddNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAddNomeClienteActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdicionar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtAdicionarPedido;
    private javax.swing.JTextField jtfAddDescricao;
    private javax.swing.JTextField jtfAddModeloVei;
    private javax.swing.JTextField jtfAddNomeCliente;
    private javax.swing.JTextField jtfAddPlaca;
    private javax.swing.JTextField jtfAddTempoEst;
    private javax.swing.JTextField jtfAddValor;
    // End of variables declaration//GEN-END:variables
}
