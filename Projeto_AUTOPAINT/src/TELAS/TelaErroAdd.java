package TELAS;

// Importações necessárias para componentes visuais e banco de dados
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaErroAdd extends javax.swing.JFrame {

    public TelaErroAdd(String mensagem) {
        initComponents(); // Inicializa os componentes visuais da tela

        // Configurações da janela
        setSize(450, 350); // Define tamanho fixo da tela
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(null); // Permite posicionamento manual dos componentes
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        setResizable(false); // Impede redimensionamento da janela

        // Configuração do JLabel com mensagem dinâmica
        jlbTextoErro.setText("<html>" + mensagem + "</html>"); // Define o texto com suporte a quebras de linha
        jlbTextoErro.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o texto horizontalmente
        jlbTextoErro.setFont(new Font("SansSerif", Font.BOLD, 15)); // Define fonte e tamanho
        jlbTextoErro.setForeground(Color.WHITE); // Define cor do texto

        // Estilização do botão OK
        jbtErroOk.setContentAreaFilled(true); // Ativa fundo do botão
        jbtErroOk.setBorderPainted(false); // Remove borda padrão
        jbtErroOk.setOpaque(false); // Permite transparência
        jbtErroOk.setFont(new Font("SansSerif", Font.BOLD, 25)); // Define fonte e tamanho
        jbtErroOk.setForeground(Color.WHITE); // Define cor do texto
        jbtErroOk.setBackground(new Color(10, 20, 40)); // Define cor de fundo (azul escuro acinzentado)

        // Carregamento da imagem de fundo
        ImageIcon imagemOriginal = DAO.ImagemTelas.getImagem("telaerroadd");

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

        jbtErroOk = new javax.swing.JButton();
        jlbTextoErro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtErroOk.setText("OK");
        jbtErroOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtErroOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtErroOk, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTextoErro, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jlbTextoErro, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jbtErroOk, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtErroOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtErroOkActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtErroOkActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaErroAdd("Não foi possivel adicionar seu pedido, verifique se as informações estão corretas e tente novamente!").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtErroOk;
    private javax.swing.JLabel jlbTextoErro;
    // End of variables declaration//GEN-END:variables
}
