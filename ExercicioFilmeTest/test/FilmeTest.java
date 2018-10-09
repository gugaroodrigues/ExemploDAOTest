import dao.FilmeDAO;
import bean.Filme;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Rafael Alipio Harada (rafhaharada@gmail.com)
 */
public class FilmeTest {
    
    @Test
    public void testCadastro(){
        Filme filme1 = new Filme();
        filme1.setAno((byte)2018);
        filme1.setAtorPrincipal("Goku");
        filme1.setCategoria("aventura");
        filme1.setDiretor("Dougras");
        filme1.setDublado(true);
        filme1.setFaixaEtaria("+16");
        filme1.setFaturamento(20000);
        filme1.setIdiomaOriginal("Pt-Br");
        filme1.setLegenda(true);
        filme1.setNome("Filme + de 8000");
        filme1.setOrcamento(8001);
        filme1.setTempoFilme((short)646);
        
        int identificador = new FilmeDAO().cadastrar(filme1);
        assertNotSame(identificador, -1);
        
        Filme filmeBuscado = new FilmeDAO().obterPeloId(identificador);
        
        assertEquals(filme1.getAno(),filmeBuscado.getAno());
        assertEquals(filme1.getAtorPrincipal(),filmeBuscado.getAtorPrincipal());
        assertEquals(filme1.getCategoria(),filmeBuscado.getCategoria());
        assertEquals(filme1.getDiretor(),filmeBuscado.getDiretor());
        assertEquals(filme1.getFaixaEtaria(),filmeBuscado.getFaixaEtaria());
        assertEquals(filme1.getFaturamento(),filmeBuscado.getFaturamento(),0);
        assertEquals(filme1.getIdiomaOriginal(),filmeBuscado.getIdiomaOriginal());
        assertEquals(filme1.getNome(),filmeBuscado.getNome());
        assertEquals(filme1.getOrcamento(),filmeBuscado.getOrcamento(),0);
        assertEquals(filme1.getTempoFilme(),filmeBuscado.getTempoFilme());
        assertEquals(filme1.isDublado(),filmeBuscado.isDublado());
        assertEquals(filme1.isLegenda(),filmeBuscado.isLegenda());
    }
    
    @Test
    public void testEditar(){
        
    }
    
    @Test
    public void testApagar(){
        
    }
    
}
