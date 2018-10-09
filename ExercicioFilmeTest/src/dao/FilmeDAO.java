package dao;

import database.Conexao;
import bean.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Rafael Alipio Harada (rafhaharada@gmail.com)
 */
public class FilmeDAO {

    public int cadastrar(Filme filme) {
        Connection conexao = Conexao.conectar();
        if(conexao != null){
            String sql = "INSERT INTO filmes (ano,ator_principal,categoria,diretor,dublado,faixa_etaria,faturamento,idioma_original,legendado,nome,orcamento,tempo_filme) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                int i = 1;
                ps.setByte(i++, filme.getAno());
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
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }
        }
        return -1;
    }
    
    public boolean editar(Filme filme) {
        Connection conexao = Conexao.conectar();
        if(conexao != null){
            String sql = "UPDATE filmes SET ano=? ,ator_principal=? ,categoria=?, diretor=?, dublado=?, faixa_etaria=?, faturamento=?, idioma_original=?, legendado=?, nome=?, orcamento=?, tempo_filme=? WHERE id=?";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                int i = 1;
                ps.setByte(i++, filme.getAno());
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
                ps.setInt(i++, filme.getId());
                return ps.executeUpdate() == 1;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }
        }
        return false;
    }
    
    public boolean excluir(int identificador) {
        Connection conexao = Conexao.conectar();
        if(conexao != null){
            String sql = "DELETE FROM filmes WHERE id=?";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setByte(i++, filme.getAno());
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
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }
        }
        return -1;
    }

    public Filme obterPeloId(int identificador) {
        Filme filme = new Filme();
        return filme;
    }

}
