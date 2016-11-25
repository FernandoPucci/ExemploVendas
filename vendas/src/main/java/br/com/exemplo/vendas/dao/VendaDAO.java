package br.com.exemplo.vendas.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.exemplo.vendas.model.Venda;

@Repository
public interface VendaDAO extends CrudRepository<Venda, Long> {

}
