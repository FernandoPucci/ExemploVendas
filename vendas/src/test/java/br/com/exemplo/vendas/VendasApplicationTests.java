package br.com.exemplo.vendas;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.exemplo.vendas.model.TipoEmbalagem;
import br.com.exemplo.vendas.service.TipoEmbalagemService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendasApplicationTests {

	@Autowired
	TipoEmbalagemService tipoEmbalagemService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testInsertAndListTipoEmbalagem(){
		
		TipoEmbalagem te = new TipoEmbalagem();
		
		te.setDescricao("teste");
		
		tipoEmbalagemService.insertTipoEmbalagemService(te);
		
		List<TipoEmbalagem> listaTeste = tipoEmbalagemService.getAllTipoEmbalagemService();
		
		assertNotNull(listaTeste);
		assertTrue(listaTeste.size()>0);
		
	}
	

}
