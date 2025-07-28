package DAO;

import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.Connection;
// Aqui é onde cria a "getConexao" para utilizar no restante do codigo para conectar com o banco
public class ConexaoBanco {
    public Connection getConexao(){
        try{
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_autopaint","root","");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro de Conexão com o Banco!");
            return null;
        }
    } 
}

