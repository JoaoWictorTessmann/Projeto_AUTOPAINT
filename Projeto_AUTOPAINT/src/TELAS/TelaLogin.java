package TELAS;

// Importações necessárias para componentes visuais e banco de dados
import DAO.ImagemTelas;
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
import javax.swing.JLabel;

public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {

        initComponents(); // Inicializa os componentes visuais da tela

        // Configurações da janela
        setSize(500, 550); // Define tamanho fixo da tela
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(null); // Permite posicionamento manual dos componentes
        setResizable(false); // Impede redimensionamento da janela

        // Estilização do campo de texto para nome de usuário
        jtfUsername.setOpaque(false); // Permite transparência
        jtfUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Remove borda padrão
        jtfUsername.setForeground(Color.BLACK); // Define cor do texto
        jtfUsername.setBackground(new Color(0, 0, 0, 0)); // Fundo totalmente transparente
        jtfUsername.setFont(new Font("SansSerif", Font.BOLD, 18)); // Define fonte e tamanho

        // Estilização do campo de senha
        jpfPassword.setOpaque(false);
        jpfPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jpfPassword.setForeground(Color.BLACK);
        jpfPassword.setBackground(new Color(0, 0, 0, 0));
        jpfPassword.setFont(new Font("SansSerif", Font.BOLD, 18));

        // Cores e estilo botão Login
        jbtLogIn.setFocusPainted(false);       // Sem destaque no foco
        jbtLogIn.setContentAreaFilled(true);  // Não usa o fundo padrão
        jbtLogIn.setOpaque(true);             // Permite transparência
        jbtLogIn.setForeground(Color.WHITE);   // Texto branco
        jbtLogIn.setFont(new Font("SansSerif", Font.BOLD, 36));
        jbtLogIn.setBackground(new Color(20, 40, 60));

        // Carregamento da imagem de fundo da tela
        ImageIcon imagemOriginal = DAO.ImagemTelas.getImagem("telalogin");

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

        jtfUsername = new javax.swing.JTextField();
        jpfPassword = new javax.swing.JPasswordField();
        jbtLogIn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUsernameActionPerformed(evt);
            }
        });

        jpfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfPasswordActionPerformed(evt);
            }
        });

        jbtLogIn.setText("Log In");
        jbtLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLogInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                    .addComponent(jpfPassword))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbtLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(308, Short.MAX_VALUE)
                .addComponent(jtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jpfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfUsernameActionPerformed

    private void jpfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpfPasswordActionPerformed

    private void jbtLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLogInActionPerformed
        // Captura os dados digitados pelo usuário
        String usuario = jtfUsername.getText(); // Nome de usuário
        String senha = new String(jpfPassword.getPassword()); // Senha convertida de char[] para String

        try {
            // Estabelece conexão com o banco de dados
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_autopaint", "root", "");

            // Prepara a consulta SQL para verificar credenciais
            String sql = "SELECT * FROM usuarios WHERE nome = ? AND senha = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario); // Define parâmetro do nome
            stmt.setString(2, senha);   // Define parâmetro da senha

            ResultSet rs = stmt.executeQuery(); // Executa a consulta

            if (rs.next()) {
                // Se encontrou o usuário, abre a tela principal
                TelaLista listas = new TelaLista();
                listas.carregarPedidos(); // Carrega os dados na tabela
                listas.setVisible(true); // Exibe a tela principal

                this.dispose(); // Fecha a tela de login
            } else {
                // Se não encontrou, exibe aviso de falha no login
                TelaAvisoUsu aviso = new TelaAvisoUsu();
                aviso.setVisible(true);
            }

            // Fecha recursos de banco de dados
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            // Exibe mensagem de erro em caso de falha na conexão ou consulta
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco: " + e.getMessage());
        }

    }//GEN-LAST:event_jbtLogInActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtLogIn;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JTextField jtfUsername;
    // End of variables declaration//GEN-END:variables
}
