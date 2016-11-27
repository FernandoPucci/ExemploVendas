package br.com.exemplo.vendas.controLler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.common.collect.Lists;

import br.com.exemplo.vendas.dao.VendaDAO;
import br.com.exemplo.vendas.model.Venda;

@Controller
public class VendaController {
	
	@Autowired
	VendaDAO vendaDAO;

	public void inserirVendaController(Venda venda) {

		vendaDAO.save(venda);

	}

	public List<Venda> getAllVendasController() {

		List<Venda> listaSaida = null;

		listaSaida = Lists.newArrayList(vendaDAO.findAll());

		return listaSaida;

	}

	public Venda getVendaByIdController(Long id) {

		return vendaDAO.findOne(id);

	}


}
