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

import br.com.exemplo.vendas.dao.ProdutoDAO;
import br.com.exemplo.vendas.model.Produto;
import br.com.exemplo.vendas.service.ProdutoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoApplicationTests {

	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	ProdutoDAO produtoDAO;
	
	@Before
	public void limpaTudo(){
		
		produtoDAO.deleteAll();
	}
	
	@Test
	public void contextLoads() {
	}
	
	
	
	@Test
	public void insertAndListProdutoTester(){
		
		Produto produto = new Produto();
		
		produto.setDescricao("Macarrão Instantâneo");
		
		produtoService.insertProdutoService(produto);
		
		List<Produto> listaTeste = produtoService.getAllProdutoService();
		
		Produto produtoById = produtoService.getProdutoByIdService(1L);
		
		assertNotNull(listaTeste);
		assertNotNull(produtoById);
		assertTrue(listaTeste.size()>0);
		
	}
	

}
