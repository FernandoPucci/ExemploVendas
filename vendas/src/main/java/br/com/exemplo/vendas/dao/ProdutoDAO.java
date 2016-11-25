package br.com.exemplo.vendas.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.exemplo.vendas.model.Produto;

@Repository
public interface ProdutoDAO extends CrudRepository<Produto, Long>{

}
