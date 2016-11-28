package br.com.exemplo.vendas;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.exemplo.vendas.dao.VendaDAO;
import br.com.exemplo.vendas.model.ItemVenda;
import br.com.exemplo.vendas.model.Produto;
import br.com.exemplo.vendas.model.TipoEmbalagem;
import br.com.exemplo.vendas.model.Venda;
import br.com.exemplo.vendas.service.ItemVendaService;
import br.com.exemplo.vendas.service.ProdutoService;
import br.com.exemplo.vendas.service.TipoEmbalagemService;
import br.com.exemplo.vendas.service.VendaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendaItemVendaApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(VendaItemVendaApplicationTests.class);

	
	@Autowired
	VendaService vendaService;
	
	@Autowired
	ItemVendaService itemVendaService;
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	TipoEmbalagemService tipoEmbalagemService;
	
	@Autowired
	VendaDAO vendaDAO;
	
	@Before
	public void limpaTudo(){
		
//		vendaDAO.deleteAll();
	}
	
	@Test
	public void contextLoads() {
	}
	
	
	
	@Test
	public void insertAndListVendaTester(){
		
		
		Venda venda = new Venda();
		TipoEmbalagem te = new TipoEmbalagem("Pacote 350g");
		
		Produto produto = new Produto(null,"Macarrão Instantâneo", 2.60, te);
		
		produtoService.insertProdutoService(produto);
		
		Produto produtoById = produtoService.getProdutoByIdService(1L);
		
		assertNotNull(produtoById);		
		
		ItemVenda item = new ItemVenda();
		item.setProduto(produtoById);
		item.setQuantidade(10.0);
		
		venda.addItem(item);
		
		vendaService.insertVendaService(venda);
		
		List<Venda> listaTeste = vendaService.getAllVendaService();
		
		Venda vendaById = vendaService.getVendaByIdService(1L);
		
		assertNotNull(listaTeste);
		assertNotNull(vendaById);
		assertTrue(listaTeste.size()>0);
		
		
	}
	

}
