package br.com.exemplo.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.exemplo.vendas.controLler.ItemVendaController;
import br.com.exemplo.vendas.model.ItemVenda;

@Service
public class ItemVendaService {

	@Autowired
	ItemVendaController itemVendaController;

	public void insertItemVendaService(ItemVenda itemVenda) {

		itemVendaController.inserirItemVendaController(itemVenda);

	}

	public List<ItemVenda> getAllItemVendaService() {

		return itemVendaController.getAllItemVendasController();

	}

	public ItemVenda getItemVendaByIdService(Long id) {

		return itemVendaController.getItemVendaByIdController(id);

	}

}
