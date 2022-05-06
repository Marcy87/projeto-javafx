package db;

import entities.Cadastros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLite {

    private Connection conn;
    private Statement stm;

    public SQLite() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:usuario.db");
        this.stm = this.conn.createStatement();
    }


    //Método responsavél por inserir cadastro de usuário
    public void insertUsuario(Cadastros cadastro){
        try {
            this.stm = this.conn.createStatement();
            String SQLInsertUsuario = "insert into usuario (Nome, Email, Senha) values ('"+cadastro.getNome()+"', '"+cadastro.getEmail()+"', '"+cadastro.getSenha()+"')";
            this.stm.executeUpdate(SQLInsertUsuario);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
