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

public class TelaFinalizar extends javax.swing.JFrame {

    public TelaFinalizar() {
        initComponents(); // Inicializa os componentes visuais da tela
    }

    // Referência à tela principal para permitir atualização após finalização
    private TelaLista telaLista;

    // Construtor principal que recebe a tela principal como parâmetro
    public TelaFinalizar(TelaLista telaLista) {
        initComponents(); // Inicializa os componentes visuais
        this.telaLista = telaLista; // Armazena referência da tela principal

        // Configurações da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        setSize(500, 550); // Define tamanho fixo da tela
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(null); // Permite posicionamento manual dos componentes
        setResizable(false); // Impede redimensionamento da janela

        // Estilização do campo de texto para ID do pedido
        jtfIdPedidoFim.setOpaque(false); // Permite transparência
        jtfIdPedidoFim.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Remove borda padrão
        jtfIdPedidoFim.setForeground(Color.BLACK); // Define cor do texto
        jtfIdPedidoFim.setBackground(new Color(0, 0, 0, 0)); // Fundo totalmente transparente
        jtfIdPedidoFim.setFont(new Font("SansSerif", Font.BOLD, 22)); // Define fonte e tamanho

        // Estilização do botão de finalização
        jbtFinalizarServico.setContentAreaFilled(true); // Ativa fundo do botão
        jbtFinalizarServico.setBorderPainted(false); // Remove borda padrão
        jbtFinalizarServico.setOpaque(false); // Permite transparência
        jbtFinalizarServico.setFont(new Font("SansSerif", Font.BOLD, 20)); // Define fonte e tamanho
        jbtFinalizarServico.setForeground(Color.WHITE); // Define cor do texto
        jbtFinalizarServico.setBackground(new Color(20, 40, 60)); // Define cor de fundo (azul escuro)

        // Carregamento da imagem de fundo da tela
        ImageIcon imagemOriginal = DAO.ImagemTelas.getImagem("telafinalizar");

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

        jbtFinalizarServico = new javax.swing.JButton();
        jtfIdPedidoFim = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtFinalizarServico.setText("Finalizar Serviço");
        jbtFinalizarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtFinalizarServicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jtfIdPedidoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jbtFinalizarServico, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(288, Short.MAX_VALUE)
                .addComponent(jtfIdPedidoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jbtFinalizarServico, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtFinalizarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtFinalizarServicoActionPerformed
        try {
            // Tenta converter o texto do campo para um número inteiro (ID do pedido)
            int idFinalizar = Integer.parseInt(jtfIdPedidoFim.getText());

            // Abre conexão com o banco de dados
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_autopaint", "root", "")) {

                // Consulta o status atual do pedido com base no ID
                String sqlVerifica = "SELECT status_servico FROM servicos WHERE id_servico = ?";
                PreparedStatement stmtVerifica = conn.prepareStatement(sqlVerifica);
                stmtVerifica.setInt(1, idFinalizar);
                ResultSet resultado = stmtVerifica.executeQuery();

                if (resultado.next()) {
                    // Obtém o status atual do pedido
                    String statusAtual = resultado.getString("status_servico");

                    // Verifica se o pedido já está finalizado
                    if ("Finalizado".equalsIgnoreCase(statusAtual)) {
                        new TelaErroAdd("Este pedido já está finalizado.<br>Status atual: Finalizado").setVisible(true);
                        return;
                    }

                    // Verifica se o pedido foi cancelado
                    if ("Cancelado".equalsIgnoreCase(statusAtual)) {
                        new TelaErroAdd("Este pedido já foi cancelado.<br>Status atual: Cancelado").setVisible(true);
                        return;
                    }

                    // Se o status for "Pendente", procede com a finalização
                    if ("Pendente".equalsIgnoreCase(statusAtual)) {
                        // Atualiza o status do pedido para "Finalizado"
                        String sqlAtualiza = "UPDATE servicos SET status_servico = 'Finalizado' WHERE id_servico = ?";
                        PreparedStatement stmtAtualiza = conn.prepareStatement(sqlAtualiza);
                        stmtAtualiza.setInt(1, idFinalizar);

                        int linhasAfetadas = stmtAtualiza.executeUpdate();

                        // Verifica se a atualização foi bem-sucedida
                        if (linhasAfetadas > 0) {
                            new TelaAddSucesso("Pedido finalizado com sucesso.<br>Status atualizado: Finalizado").setVisible(true);
                            telaLista.carregarPedidos(); // Atualiza a lista na tela principal
                            this.dispose(); // Fecha a tela atual
                        } else {
                            new TelaErroAdd("Erro ao finalizar pedido. Nenhum registro foi alterado.").setVisible(true);
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
            new TelaErroAdd("Erro ao finalizar pedido: " + e.getMessage()).setVisible(true);
        }
    }//GEN-LAST:event_jbtFinalizarServicoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFinalizar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtFinalizarServico;
    private javax.swing.JTextField jtfIdPedidoFim;
    // End of variables declaration//GEN-END:variables
}
