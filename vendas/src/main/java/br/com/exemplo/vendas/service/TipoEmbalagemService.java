package br.com.exemplo.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.exemplo.vendas.controLler.TipoEmbalagemController;
import br.com.exemplo.vendas.model.TipoEmbalagem;

@Service
public class TipoEmbalagemService {

	@Autowired
	TipoEmbalagemController tipoEmbalagemController;

	public void insertTipoEmbalagemService(TipoEmbalagem tipoEmbalagem) {

		tipoEmbalagemController.insertTipoEmbalagemController(tipoEmbalagem);

	}

	public List<TipoEmbalagem> getAllTipoEmbalagemService() {

		return tipoEmbalagemController.getAllTipoEmbalagemController();

	}

	public TipoEmbalagem getTipoEmbalagemByIdService(Long id) {

		return tipoEmbalagemController.getTipoEmbalagemByIdController(id);

	}

}
