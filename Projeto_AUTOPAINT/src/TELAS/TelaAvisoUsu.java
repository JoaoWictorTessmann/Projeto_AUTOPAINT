package TELAS;

// Importações necessárias para componentes visuais e banco de dados
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TelaAvisoUsu extends javax.swing.JFrame {

    public TelaAvisoUsu() {

        initComponents(); // Inicializa os componentes visuais da tela

        // Configurações básicas da janela
        setSize(350, 350); // Define tamanho fixo da tela
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(null); // Permite posicionamento manual dos componentes
        setResizable(false); // Impede redimensionamento da janela

        // Estilização do botão OK
        jbtOkAviso.setContentAreaFilled(true); // Ativa fundo do botão
        jbtOkAviso.setBorderPainted(false); // Remove borda padrão
        jbtOkAviso.setOpaque(false); // Permite transparência
        jbtOkAviso.setFont(new Font("SansSerif", Font.BOLD, 25)); // Define fonte e tamanho
        jbtOkAviso.setForeground(Color.BLACK); // Define cor do texto

        // Carregamento da imagem de fundo
        ImageIcon imagemOriginal = DAO.ImagemTelas.getImagem("telaaviso");

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

        jbtOkAviso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtOkAviso.setText("OK");
        jbtOkAviso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtOkAvisoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(jbtOkAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addComponent(jbtOkAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtOkAvisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtOkAvisoActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtOkAvisoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAvisoUsu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtOkAviso;
    // End of variables declaration//GEN-END:variables
}
