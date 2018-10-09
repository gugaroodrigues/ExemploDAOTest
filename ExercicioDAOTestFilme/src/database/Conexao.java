/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alunos
 */
public class Conexao {
    
    private static final String HOST = "jdbc:mysql;//localhost/con";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String CLASS = "com.mysql.jdbc.Driver";
    private static Connection conexao;
    
    public static Connection conectar(){
        try{
            Class.forName(CLASS);
            conexao = DriverManager.getConnection(HOST, USER, PASSWORD);
            return conexao;
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return  null;
    }
    
    public static void desconectar() {
        if(conexao != null){
            try{
                conexao.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
       
    }
}
