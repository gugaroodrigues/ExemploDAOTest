package dao;

import Bean.Filme;
import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alunos
 */
public class FilmeDAO {

    public int inserir(Filme filme) {
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            String sql = "INSERT INTO filmes (ano,ator_principal,categoria,diretor,dublado,faixa_etaria,faturamento,idioma_original,legendado,nome,orcamento,tempo_filme) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                int i = 1;
                ps.setInt(i++, filme.getAno());
                ps.setString(i++, filme.getAtorPrincipal());
                ps.setString(i++, filme.getCategoria());
                ps.setString(i++, filme.getDiretor());
                ps.setBoolean(i++, filme.isDublado());
                ps.setString(i++, filme.getFaixaEtaria());
                ps.setDouble(i++, filme.getFaturamento());
                ps.setString(i++, filme.getIdiomaOriginal());
                ps.setBoolean(i++, filme.isLegenda());
                ps.setString(i++, filme.getNome());
                ps.setDouble(i++, filme.getOrcamento());
                ps.setShort(i++, filme.getTempoFilme());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    return rs.getInt(1);
                }
            }catch(SQLException e){
                
            }finally{
                Conexao.desconectar();
            }
        }
        return -1;
    }
     

}
