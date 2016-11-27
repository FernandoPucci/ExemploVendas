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

import br.com.exemplo.vendas.model.TipoEmbalagem;
import br.com.exemplo.vendas.service.TipoEmbalagemService;

/**
 * @author fernandopucci
 *
 */
@Component
@RestController
@Path("/API/tipos-embalagem")
public class TipoEmbalagemApiController {

	private static final Logger log = LoggerFactory.getLogger(TipoEmbalagemApiController.class);

	@Autowired
	TipoEmbalagemService tipoEmbalagemService;

	@GET
	@Path("/list-all-tipos-embalagem")
	@Produces(MediaType.APPLICATION_JSON)
	@JacksonFeatures(serializationEnable = { SerializationFeature.INDENT_OUTPUT })
	public List<TipoEmbalagem> listAllTiposEmbalagens() {

		return tipoEmbalagemService.getAllTipoEmbalagemService();

	}

	@GET
	@Path("/get-tipos-embalagem")
	@Produces(MediaType.APPLICATION_JSON)
	@JacksonFeatures(serializationEnable = { SerializationFeature.INDENT_OUTPUT })
	public TipoEmbalagem listAllTiposEmbalagens(@QueryParam("id") Long tipoEmbalagem) {

		if (tipoEmbalagem == null) {
			log.error("Transação inválida");
		}

		try {

			return tipoEmbalagemService.getTipoEmbalagemByIdService(tipoEmbalagem);

		} catch (Exception ex) {
			log.error("Transação inválida " + ex.getMessage());
		}

		return null;
	}

	@POST
	@Path("/register-tipo-embalagem")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response registerTransaction(TipoEmbalagem tipoEmbalagem) {

		if (tipoEmbalagem == null) {
			log.error("Transação inválida");
			return Response.status(500).entity("Transação inválida").build();
		}

		try {

			tipoEmbalagemService.insertTipoEmbalagemService(tipoEmbalagem);

			return Response.status(200).entity("SUCESSO: " + tipoEmbalagem.toString()).build();

		} catch (Exception ex) {
			log.error("Transação inválida " + ex.getMessage());
			return Response.status(500).entity("Transação inválida " + ex.getMessage()).build();
		}

	}

}
