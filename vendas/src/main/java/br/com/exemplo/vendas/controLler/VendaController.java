package br.com.exemplo.vendas.controLler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.common.collect.Lists;

import br.com.exemplo.vendas.dao.VendaDAO;
import br.com.exemplo.vendas.model.ItemVenda;
import br.com.exemplo.vendas.model.Venda;
import br.com.exemplo.vendas.service.ProdutoService;

@Controller
public class VendaController {

	@Autowired
	VendaDAO vendaDAO;

	@Autowired
	ProdutoService produtoService;

	public void inserirVendaController(Venda venda) {

		if (venda != null) {

			double valorTotal = 0.0;

			for (ItemVenda i : venda.getItens()) {

				if (i.getProduto().getValorUnitario() == null) {

					double quantidade = i.getQuantidade();
					
					i.getProduto().setValorUnitario(
							produtoService.getProdutoByIdService(i.getProduto().getIdProduto()).getValorUnitario());
					i.setQuantidade(quantidade);

				}

				valorTotal += i.getSubTotal();

			}

			venda.setValorTotal(valorTotal);

		}

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
