package br.com.exemplo.vendas.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.exemplo.vendas.model.TipoEmbalagem;

@Repository
public interface TipoEmbalagemDAO extends CrudRepository<TipoEmbalagem, Long>{

}

