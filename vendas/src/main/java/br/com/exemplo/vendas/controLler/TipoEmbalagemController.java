package br.com.exemplo.vendas.controLler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.common.collect.Lists;

import br.com.exemplo.vendas.dao.TipoEmbalagemDAO;
import br.com.exemplo.vendas.model.TipoEmbalagem;

@Controller
public class TipoEmbalagemController {

	@Autowired
	TipoEmbalagemDAO tipoEmbalagemDAO;

	public void insertTipoEmbalagemController(TipoEmbalagem tipoEmbalagem) {

		tipoEmbalagemDAO.save(tipoEmbalagem);

	}

	public List<TipoEmbalagem> getAllTipoEmbalagemController() {

		List<TipoEmbalagem> listaSaida = null;
		
		listaSaida = Lists.newArrayList(tipoEmbalagemDAO.findAll());
		
		return listaSaida;

	}

	public TipoEmbalagem getTipoEmbalagemByIdController(Long id) {

		return tipoEmbalagemDAO.findOne(id);

	}

}
