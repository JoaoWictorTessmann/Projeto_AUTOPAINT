package DAO;
// Criação da "GetImagem" para localizar as imagens que seram usadas durante as telas.
import javax.swing.ImageIcon;

public class ImagemTelas {

    public static ImageIcon getImagem(String tipo) {
        switch (tipo.toLowerCase()) {
            case "telalogin":
                return new ImageIcon(ImagemTelas.class.getResource("/imagens/TelaLogin.png"));
            case "telalista":
                return new ImageIcon(ImagemTelas.class.getResource("/imagens/ListaPedidos.png"));
            case "telaaviso":
                return new ImageIcon(ImagemTelas.class.getResource("/imagens/TelaAviso.png"));
            case "telaadicionar":
                return new ImageIcon(ImagemTelas.class.getResource("/imagens/TelaAdicionar.png"));
            case "telamodificar":
                return new ImageIcon(ImagemTelas.class.getResource("/imagens/TelaModificar.png"));
            case "telacancelar":
                return new ImageIcon(ImagemTelas.class.getResource("/imagens/TelaCancelar.png"));
            case "telafinalizar":
                return new ImageIcon(ImagemTelas.class.getResource("/imagens/TelaFinalizar.png"));
            case "telaaddsucesso":
                return new ImageIcon(ImagemTelas.class.getResource("/imagens/TelaAddSucesso.png"));
            case "telaerroadd":
                return new ImageIcon(ImagemTelas.class.getResource("/imagens/TelaAddErro.png"));                
            default:
                return null;
        }
    }
}
