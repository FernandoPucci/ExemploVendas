package br.com.exemplo.vendas.controLler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.common.collect.Lists;

import br.com.exemplo.vendas.dao.ItemVendaDAO;
import br.com.exemplo.vendas.model.ItemVenda;

@Controller
public class ItemVendaController {

	@Autowired
	ItemVendaDAO itemVendaDAO;

	public void inserirItemVendaController(ItemVenda itemVenda) {

		itemVendaDAO.save(itemVenda);

	}

	public List<ItemVenda> getAllItemVendasController() {

		List<ItemVenda> listaSaida = null;

		listaSaida = Lists.newArrayList(itemVendaDAO.findAll());

		return listaSaida;

	}

	public ItemVenda getItemVendaByIdController(Long id) {

		return itemVendaDAO.findOne(id);

	}

	
}
