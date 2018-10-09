/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import dao.FilmeDAO;
import Bean.Filme;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alunos
 */
public class TestDAOFilme {

    @Test
    public void testCadastro() {
        FilmeDAO dao = new FilmeDAO();
        Filme filme = new Filme();
        filme.setId(1);
        filme.setNome("O programador");
        filme.setAno(2018);
        filme.setCategoria("Terror");
        filme.setFaixaEtaria("+18");
        filme.setAtorPrincipal("Eu");
        filme.setDiretor("Eu de novo");
        filme.setDublado(false);
        filme.setLegenda(true);
        filme.setTempoFilme((short)646);
        filme.setOrcamento(9001);
        filme.setFaturamento(1000.00);
        
        int filmezinho = dao.inserir(filme);
        assertNotSame(filmezinho, -1);
        
    }
    
    @Test
    public void testEditar(){
        
    }
    
    @Test
    public void testApagar(){
        
    }

}
