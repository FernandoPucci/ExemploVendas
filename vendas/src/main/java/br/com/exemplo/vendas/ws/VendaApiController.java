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

import br.com.exemplo.vendas.model.Venda;
import br.com.exemplo.vendas.service.VendaService;

/**
 * @author fernandopucci
 *
 */
@Component
@RestController
@Path("/API/vendas")
public class VendaApiController {

	private static final Logger log = LoggerFactory.getLogger(VendaApiController.class);

	@Autowired
	VendaService vendaService;

	@GET
	@Path("/list-all-venda")
	@Produces(MediaType.APPLICATION_JSON)
	@JacksonFeatures(serializationEnable = { SerializationFeature.INDENT_OUTPUT })
	public List<Venda> listAllTiposEmbalagens() {

		return vendaService.getAllVendaService();

	}

	@GET
	@Path("/get-venda")
	@Produces(MediaType.APPLICATION_JSON)
	@JacksonFeatures(serializationEnable = { SerializationFeature.INDENT_OUTPUT })
	public Venda listAllTiposEmbalagens(@QueryParam("id") Long venda) {

		if (venda == null) {
			log.error("Transação inválida");
		}

		try {

			return vendaService.getVendaByIdService(venda);

		} catch (Exception ex) {
			log.error("Transação inválida " + ex.getMessage());
		}

		return null;
	}

	@POST
	@Path("/register-venda")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response registerTransaction(Venda venda) {

		if (venda == null) {
			log.error("Transação inválida");
			return Response.status(500).entity("Transação inválida").build();
		}

		try {

			vendaService.insertVendaService(venda);

			return Response.status(200).entity("SUCESSO: " + venda.toString()).build();

		} catch (Exception ex) {
			log.error("Transação inválida " + ex.getMessage());
			return Response.status(500).entity("Transação inválida " + ex.getMessage()).build();
		}

	}

}
