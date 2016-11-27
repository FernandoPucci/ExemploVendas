package br.com.exemplo.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.exemplo.vendas.controLler.ProdutoController;
import br.com.exemplo.vendas.model.Produto;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoController produtoController;

	public void insertProdutoService(Produto produto) {

		produtoController.inserirProdutoController(produto);

	}

	public List<Produto> getAllProdutoService() {

		return produtoController.getAllProdutosController();

	}

	public Produto getProdutoByIdService(Long id) {

		return produtoController.getProdutoByIdController(id);

	}
	
}
