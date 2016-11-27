package br.com.exemplo.vendas.controLler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.common.collect.Lists;

import br.com.exemplo.vendas.dao.ProdutoDAO;
import br.com.exemplo.vendas.model.Produto;

@Controller
public class ProdutoController {

	@Autowired
	ProdutoDAO produtoDAO;

	public void inserirProdutoController(Produto produto) {

		produtoDAO.save(produto);

	}

	public List<Produto> getAllProdutosController() {

		List<Produto> listaSaida = null;

		listaSaida = Lists.newArrayList(produtoDAO.findAll());

		return listaSaida;

	}

	public Produto getProdutoByIdController(Long id) {

		return produtoDAO.findOne(id);

	}

}
