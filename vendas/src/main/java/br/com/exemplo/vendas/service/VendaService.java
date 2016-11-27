package br.com.exemplo.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.exemplo.vendas.controLler.VendaController;
import br.com.exemplo.vendas.model.Venda;

@Service
public class VendaService {

	
	@Autowired
	VendaController vendaController;

	public void insertVendaService(Venda venda) {

		vendaController.inserirVendaController(venda);

	}

	public List<Venda> getAllVendaService() {

		return vendaController.getAllVendasController();

	}

	public Venda getVendaByIdService(Long id) {

		return vendaController.getVendaByIdController(id);

	}

	
	
}
