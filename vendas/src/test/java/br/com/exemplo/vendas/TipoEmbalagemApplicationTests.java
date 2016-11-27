package br.com.exemplo.vendas;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.exemplo.vendas.dao.TipoEmbalagemDAO;
import br.com.exemplo.vendas.model.TipoEmbalagem;
import br.com.exemplo.vendas.service.TipoEmbalagemService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TipoEmbalagemApplicationTests {

	@Autowired
	TipoEmbalagemService tipoEmbalagemService;
	
	@Autowired
	TipoEmbalagemDAO tipoEmbalagemDAO;
	
	@Before
	public void limpaTudo(){
		
		tipoEmbalagemDAO.deleteAll();
	}
	
	@Test
	public void contextLoads() {
	}
	
	
	
	@Test
	public void insertAndListTipoEmbalagemTester(){
		
		TipoEmbalagem te = new TipoEmbalagem();
		
		te.setDescricao("pacote 500 gramas");
		
		tipoEmbalagemService.insertTipoEmbalagemService(te);
		
		List<TipoEmbalagem> listaTeste = tipoEmbalagemService.getAllTipoEmbalagemService();
		
		TipoEmbalagem tipoEmbbalagemById = tipoEmbalagemService.getTipoEmbalagemByIdService(1L);
		
		assertNotNull(listaTeste);
		assertNotNull(tipoEmbbalagemById);
		assertTrue(listaTeste.size()>0);
		
	}
	

}
