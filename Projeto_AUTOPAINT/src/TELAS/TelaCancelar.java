package TELAS;

// Importações necessárias para componentes visuais e banco de dados
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

public class TelaCancelar extends javax.swing.JFrame {

    public TelaCancelar() {
        initComponents(); // Inicializa os componentes visuais da tela
    }

    // Referência à tela principal para permitir atualização após cancelamento
    private TelaLista telaLista;

    // Construtor principal que recebe a tela principal como parâmetro
    public TelaCancelar(TelaLista telaLista) {
        initComponents(); // Inicializa os componentes visuais
        this.telaLista = telaLista; // Armazena referência da tela principal

        // Configurações da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        setSize(500, 550); // Define tamanho fixo da tela
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(null); // Permite posicionamento manual dos componentes
        setResizable(false); // Impede redimensionamento da janela

        // Estilização do campo de texto para ID do pedido
        jtfIdPedidoCancel.setOpaque(false); // Permite transparência
        jtfIdPedidoCancel.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Remove borda padrão
        jtfIdPedidoCancel.setForeground(Color.BLACK); // Define cor do texto
        jtfIdPedidoCancel.setBackground(new Color(0, 0, 0, 0)); // Fundo totalmente transparente
        jtfIdPedidoCancel.setFont(new Font("SansSerif", Font.BOLD, 22)); // Define fonte e tamanho

        // Estilização do botão de confirmação de cancelamento
        jbtConfirmarCancelamento.setContentAreaFilled(true); // Ativa fundo do botão
        jbtConfirmarCancelamento.setBorderPainted(false); // Remove borda padrão
        jbtConfirmarCancelamento.setOpaque(false); // Permite transparência
        jbtConfirmarCancelamento.setFont(new Font("SansSerif", Font.BOLD, 20)); // Define fonte e tamanho
        jbtConfirmarCancelamento.setForeground(Color.WHITE); // Define cor do texto
        jbtConfirmarCancelamento.setBackground(new Color(20, 40, 60)); // Define cor de fundo (azul escuro)

        // Carregamento da imagem de fundo da tela
        ImageIcon imagemOriginal = DAO.ImagemTelas.getImagem("telacancelar");

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

        jtfIdPedidoCancel = new javax.swing.JTextField();
        jbtConfirmarCancelamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtfIdPedidoCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdPedidoCancelActionPerformed(evt);
            }
        });

        jbtConfirmarCancelamento.setText("Confirmar Cancelamento");
        jbtConfirmarCancelamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmarCancelamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(jtfIdPedidoCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jbtConfirmarCancelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(261, Short.MAX_VALUE)
                .addComponent(jtfIdPedidoCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jbtConfirmarCancelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfIdPedidoCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdPedidoCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdPedidoCancelActionPerformed

    private void jbtConfirmarCancelamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmarCancelamentoActionPerformed
        try {
            // Tenta converter o texto do campo para um número inteiro (ID do pedido)
            int idCancelar = Integer.parseInt(jtfIdPedidoCancel.getText());

            // Abre conexão com o banco de dados
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_autopaint", "root", "")) {

                // Consulta o status atual do pedido com base no ID
                String sqlVerifica = "SELECT status_servico FROM servicos WHERE id_servico = ?";
                PreparedStatement stmtVerifica = conn.prepareStatement(sqlVerifica);
                stmtVerifica.setInt(1, idCancelar);
                ResultSet resultado = stmtVerifica.executeQuery();

                if (resultado.next()) {
                    // Obtém o status atual do pedido
                    String statusAtual = resultado.getString("status_servico");

                    // Verifica se o pedido já está cancelado
                    if ("Cancelado".equalsIgnoreCase(statusAtual)) {
                        new TelaErroAdd("Este pedido já está cancelado.<br>Status atual: Cancelado").setVisible(true);
                        return;
                    }

                    // Verifica se o pedido já foi finalizado
                    if ("Finalizado".equalsIgnoreCase(statusAtual)) {
                        new TelaErroAdd("Este pedido já foi finalizado.<br>Status atual: Finalizado").setVisible(true);
                        return;
                    }

                    // Se o status for "Pendente", procede com o cancelamento
                    if ("Pendente".equalsIgnoreCase(statusAtual)) {
                        // Atualiza o status do pedido para "Cancelado"
                        String sqlAtualiza = "UPDATE servicos SET status_servico = 'Cancelado' WHERE id_servico = ?";
                        PreparedStatement stmtAtualiza = conn.prepareStatement(sqlAtualiza);
                        stmtAtualiza.setInt(1, idCancelar);

                        int linhasAfetadas = stmtAtualiza.executeUpdate();

                        // Verifica se a atualização foi bem-sucedida
                        if (linhasAfetadas > 0) {
                            new TelaAddSucesso("Pedido cancelado com sucesso.<br>Status atualizado: Cancelado").setVisible(true);
                            telaLista.carregarPedidos(); // Atualiza a lista na tela principal
                            this.dispose(); // Fecha a tela atual
                        } else {
                            new TelaErroAdd("Erro ao cancelar pedido. Nenhum registro foi alterado.").setVisible(true);
                        }
                    } else {
                        // Caso o status não seja reconhecido
                        new TelaErroAdd("Status do pedido não reconhecido: " + statusAtual).setVisible(true);
                    }

                } else {
                    // Nenhum pedido encontrado com o ID informado
                    new TelaErroAdd("ID não encontrado. Nenhum pedido corresponde.").setVisible(true);
                }

            }

        } catch (NumberFormatException e) {
            // Erro ao converter o ID para número
            new TelaErroAdd("Digite um número válido para o ID.").setVisible(true);
        } catch (SQLException e) {
            // Erro de conexão ou execução de SQL
            new TelaErroAdd("Erro ao cancelar pedido: " + e.getMessage()).setVisible(true);
        }
    }//GEN-LAST:event_jbtConfirmarCancelamentoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCancelar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtConfirmarCancelamento;
    private javax.swing.JTextField jtfIdPedidoCancel;
    // End of variables declaration//GEN-END:variables
}
