package TELAS;

// Importações necessárias para componentes visuais e banco de dados
import DAO.ImagemTelas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class TelaLista extends javax.swing.JFrame {

    public TelaLista() {
        initComponents(); // Inicializa os componentes visuais da tela

        // Configurações da janela principal
        setSize(1500, 850); // Define tamanho fixo da tela
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(null); // Permite posicionamento manual dos componentes
        setResizable(false); // Impede redimensionamento da janela

        // Estilização do botão "Adicionar"
        jbtAdicionar.setContentAreaFilled(true); // Ativa fundo do botão
        jbtAdicionar.setBorderPainted(false); // Remove borda padrão
        jbtAdicionar.setForeground(Color.WHITE); // Define cor do texto
        jbtAdicionar.setOpaque(false); // Permite transparência
        jbtAdicionar.setFont(new Font("SansSerif", Font.BOLD, 40)); // Define fonte e tamanho
        jbtAdicionar.setBackground(new Color(20, 40, 60)); // Define cor de fundo (azul escuro)

        // Estilização do botão "Modificar"
        jbtModificar.setContentAreaFilled(true);
        jbtModificar.setBorderPainted(false);
        jbtModificar.setForeground(Color.WHITE);
        jbtModificar.setOpaque(false);
        jbtModificar.setFont(new Font("SansSerif", Font.BOLD, 40));
        jbtModificar.setBackground(new Color(20, 40, 60));

        // Estilização do botão "Cancelar"
        jbtCancelar.setContentAreaFilled(true);
        jbtCancelar.setBorderPainted(false);
        jbtCancelar.setForeground(Color.WHITE);
        jbtCancelar.setOpaque(false);
        jbtCancelar.setFont(new Font("SansSerif", Font.BOLD, 40));
        jbtCancelar.setBackground(new Color(20, 40, 60));

        // Estilização do botão "Finalizar"
        jbtFinalizar.setContentAreaFilled(true);
        jbtFinalizar.setBorderPainted(false);
        jbtFinalizar.setForeground(Color.WHITE);
        jbtFinalizar.setOpaque(false);
        jbtFinalizar.setFont(new Font("SansSerif", Font.BOLD, 40));
        jbtFinalizar.setBackground(new Color(20, 40, 60));

        // Estilização do botão "Sair"
        jbtSair.setContentAreaFilled(true);
        jbtSair.setBorderPainted(false);
        jbtSair.setForeground(Color.WHITE);
        jbtSair.setOpaque(false);
        jbtSair.setFont(new Font("SansSerif", Font.BOLD, 40));
        jbtSair.setBackground(new Color(20, 40, 60));

        // Carregamento da imagem de fundo da tela
        ImageIcon imagemOriginal = DAO.ImagemTelas.getImagem("telalista");

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtlLista = new javax.swing.JTable();
        jbtSair = new javax.swing.JButton();
        jbtAdicionar = new javax.swing.JButton();
        jbtModificar = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();
        jbtFinalizar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JtlLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cliente", "Descrição", "Carro", "Placa", "Valor", "Est. Tempo", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(JtlLista);

        jbtSair.setText("Sair");
        jbtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSairActionPerformed(evt);
            }
        });

        jbtAdicionar.setText("Adicionar");
        jbtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAdicionarActionPerformed(evt);
            }
        });

        jbtModificar.setText("Editar");
        jbtModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtModificarActionPerformed(evt);
            }
        });

        jbtCancelar.setText("Cancelar");
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });

        jbtFinalizar.setText("Finalizar");
        jbtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(jbtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1403, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(252, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(133, 133, 133))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Ação do botão "Sair"
    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        TelaLogin login = new TelaLogin(); // Cria nova instância da tela de login
        login.setVisible(true); // Exibe a tela de login
        login.setLocationRelativeTo(null); // Centraliza a tela de login
        this.dispose(); // Fecha a tela atual (TelaLista)
    }//GEN-LAST:event_jbtSairActionPerformed

    // Ação do botão "Finalizar"
    private void jbtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtFinalizarActionPerformed
        TelaFinalizar FinalizarPedido = new TelaFinalizar(this); // Cria tela de finalização, passando referência da tela atual
        FinalizarPedido.setVisible(true); // Exibe a tela de finalização
    }//GEN-LAST:event_jbtFinalizarActionPerformed

    // Ação do botão "Cancelar"
    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        TelaCancelar cancelarPedido = new TelaCancelar(this); // Cria tela de cancelamento, passando referência da tela atual
        cancelarPedido.setVisible(true); // Exibe a tela de cancelamento
    }//GEN-LAST:event_jbtCancelarActionPerformed

    // Ação do botão "Modificar"
    private void jbtModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtModificarActionPerformed
        TelaModificar modificarPedido = new TelaModificar(this); // Cria tela de modificação, passando referência da tela atual
        modificarPedido.setVisible(true); // Exibe a tela de modificação
    }//GEN-LAST:event_jbtModificarActionPerformed

    // Ação do botão "Adicionar"
    private void jbtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAdicionarActionPerformed
        TelaAdicionar adicionar = new TelaAdicionar(this); // Cria tela de adição de pedido, passando referência da tela atual
        adicionar.setVisible(true); // Exibe a tela de adição
    }//GEN-LAST:event_jbtAdicionarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLista().setVisible(false);
            }
        });
    }

    public void carregarPedidos() {
        // Cria modelo de tabela com células não editáveis
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Impede edição direta na tabela
            }
        };

        // Define os nomes das colunas da tabela
        model.setColumnIdentifiers(new Object[]{
            "ID", "Cliente", "Descrição", "Modelo", "Placa", "Valor", "Tempo", "Status"
        });

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_autopaint", "root", "")) {
            String sql = "SELECT * FROM servicos"; // Consulta todos os registros da tabela
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Formata valores como moeda brasileira (R$)
            NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

            // Itera sobre os resultados e adiciona à tabela
            while (rs.next()) {
                double valor = rs.getDouble("valor");
                String valorFormatado = formatoMoeda.format(valor); // Ex: R$ 100,00

                model.addRow(new Object[]{
                    rs.getInt("id_servico"),
                    rs.getString("nome_cliente"),
                    rs.getString("descricao"),
                    rs.getString("modelo_carro"),
                    rs.getString("placa"),
                    valorFormatado,
                    rs.getString("tempo_estimado"),
                    rs.getString("status_servico")
                });
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // Exibe mensagem de erro em caso de falha na consulta
            JOptionPane.showMessageDialog(null, "Erro ao carregar pedidos: " + e.getMessage());
        }

        // Estilização da tabela
        JtlLista.setBackground(Color.WHITE); // Fundo da tabela
        JtlLista.setForeground(Color.BLACK); // Cor do texto
        JtlLista.setFont(new Font("SansSerif", Font.PLAIN, 16)); // Fonte padrão

        // Estilização do cabeçalho da tabela
        JtlLista.getTableHeader().setBackground(new Color(30, 30, 40)); // Fundo do cabeçalho
        JtlLista.getTableHeader().setForeground(Color.BLACK); // Texto do cabeçalho
        JtlLista.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16)); // Fonte do cabeçalho
        JtlLista.getTableHeader().setOpaque(true);

        // Alternância de cor nas linhas (efeito zebra)
        JtlLista.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground((row % 2 == 0) ? new Color(41, 45, 62) : new Color(50, 55, 75)); // Alterna cores por linha
                c.setForeground(Color.WHITE); // Texto branco
                return c;
            }
        });

        // Aplica o modelo à tabela
        JtlLista.setModel(model);

        // Define largura preferencial das colunas
        TableColumnModel colunaModel = JtlLista.getColumnModel();
        colunaModel.getColumn(0).setPreferredWidth(15);   // ID
        colunaModel.getColumn(1).setPreferredWidth(120);  // Cliente
        colunaModel.getColumn(2).setPreferredWidth(305);  // Descrição
        colunaModel.getColumn(3).setPreferredWidth(120);  // Modelo
        colunaModel.getColumn(4).setPreferredWidth(100);  // Placa
        colunaModel.getColumn(5).setPreferredWidth(80);   // Valor
        colunaModel.getColumn(6).setPreferredWidth(90);   // Tempo
        colunaModel.getColumn(7).setPreferredWidth(120);  // Status

        // Impede que o usuário mova ou redimensione colunas
        JtlLista.getTableHeader().setReorderingAllowed(false);
        JtlLista.getTableHeader().setResizingAllowed(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtlLista;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtAdicionar;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtFinalizar;
    private javax.swing.JButton jbtModificar;
    private javax.swing.JButton jbtSair;
    // End of variables declaration//GEN-END:variables
}
