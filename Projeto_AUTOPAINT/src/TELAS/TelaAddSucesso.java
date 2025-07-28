package TELAS;

// Importações necessárias para componentes visuais e banco de dados
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaAddSucesso extends javax.swing.JFrame {

    public TelaAddSucesso(String mensagem) {
        // initCOmponents é o que sera iniciado quando a tela surgir
        initComponents();
        setSize(450, 350); // Define Tamanho
        setLocationRelativeTo(null);// Centralizar na tela
        setLayout(null); // Permite posicionamento manual dos objetos
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas a Janela Atual
        setResizable(false); // Redimensionamento manual indisponivel

        // Mensagem dinâmica no JLabel e caracteristicas da escrita
        jlbTextoAddSucesso.setText("<html>" + mensagem + "</html>"); // Seleciona a mesnagem 
        jlbTextoAddSucesso.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza a mensagem
        jlbTextoAddSucesso.setFont(new Font("SansSerif", Font.BOLD, 15)); // Ajusta fonte e tamanho
        jlbTextoAddSucesso.setForeground(Color.WHITE); // Coloração do Texto

        // Caracteristicas do botão da tela
        jbtOkAddSucesso.setContentAreaFilled(true); // Permite ver o fundo do botão
        jbtOkAddSucesso.setBorderPainted(false);     // Retira borda quadrada
        jbtOkAddSucesso.setOpaque(false);            // Retira Transparencia
        jbtOkAddSucesso.setFont(new Font("SansSerif", Font.BOLD, 25)); // Ajusta Fonte e tamanho
        jbtOkAddSucesso.setForeground(new Color(0, 50, 100)); // Define cor da escrita
        jbtOkAddSucesso.setBorder(new javax.swing.border.LineBorder(new Color(0, 120, 215), 2, true)); // Define Cor da borda

        ImageIcon imagemOriginal = DAO.ImagemTelas.getImagem("telaaddsucesso"); // Busca imagem de fundo

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtOkAddSucesso = new javax.swing.JButton();
        jlbTextoAddSucesso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtOkAddSucesso.setText("OK");
        jbtOkAddSucesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtOkAddSucessoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlbTextoAddSucesso, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtOkAddSucesso, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jlbTextoAddSucesso, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtOkAddSucesso, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtOkAddSucessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtOkAddSucessoActionPerformed
        this.dispose(); // Fecha esta tela
    }//GEN-LAST:event_jbtOkAddSucessoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAddSucesso("Pedido Adicionado Com Sucesso!").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtOkAddSucesso;
    private javax.swing.JLabel jlbTextoAddSucesso;
    // End of variables declaration//GEN-END:variables
}
