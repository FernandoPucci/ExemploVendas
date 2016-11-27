package br.com.exemplo.vendas.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;

import br.com.exemplo.vendas.model.ItemVenda;
import br.com.exemplo.vendas.service.ItemVendaService;

/**
 * @author fernandopucci
 *
 */
@Component
@RestController
@Path("/API/produto")
public class ItemVendaApiController {

	private static final Logger log = LoggerFactory.getLogger(ItemVendaApiController.class);

	@Autowired
	ItemVendaService itemVendaService;

	@GET
	@Path("/list-all-item-venda")
	@Produces(MediaType.APPLICATION_JSON)
	@JacksonFeatures(serializationEnable = { SerializationFeature.INDENT_OUTPUT })
	public List<ItemVenda> listAllTiposEmbalagens() {

		return itemVendaService.getAllItemVendaService();

	}

	@GET
	@Path("/get-item-venda")
	@Produces(MediaType.APPLICATION_JSON)
	@JacksonFeatures(serializationEnable = { SerializationFeature.INDENT_OUTPUT })
	public ItemVenda listAllTiposEmbalagens(@QueryParam("id") Long itemVenda) {

		if (itemVenda == null) {
			log.error("Transação inválida");
		}

		try {

			return itemVendaService.getItemVendaByIdService(itemVenda);

		} catch (Exception ex) {
			log.error("Transação inválida " + ex.getMessage());
		}

		return null;
	}

	@POST
	@Path("/register-item-venda")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response registerTransaction(ItemVenda itemVenda) {

		if (itemVenda == null) {
			log.error("Transação inválida");
			return Response.status(500).entity("Transação inválida").build();
		}

		try {

			itemVendaService.insertItemVendaService(itemVenda);

			return Response.status(200).entity("SUCESSO: " + itemVenda.toString()).build();

		} catch (Exception ex) {
			log.error("Transação inválida " + ex.getMessage());
			return Response.status(500).entity("Transação inválida " + ex.getMessage()).build();
		}

	}

}
