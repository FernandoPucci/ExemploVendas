package br.com.exemplo.vendas.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.exemplo.vendas.model.ItemVenda;

@Repository
public interface ItemVendaDAO extends CrudRepository<ItemVenda, Long>{

}
