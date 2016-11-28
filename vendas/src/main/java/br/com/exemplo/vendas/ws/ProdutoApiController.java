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

import br.com.exemplo.vendas.model.Produto;
import br.com.exemplo.vendas.service.ProdutoService;
import br.com.exemplo.vendas.util.Constantes;

/**
 * @author fernandopucci
 *
 */
@Component
@RestController
@Path("/API/produto")
public class ProdutoApiController {

	private static final Logger log = LoggerFactory.getLogger(ProdutoApiController.class);

	@Autowired
	ProdutoService produtoService;

	@GET
	@Path("/list-all-produto")
	@Produces(MediaType.APPLICATION_JSON)
	@JacksonFeatures(serializationEnable = { SerializationFeature.INDENT_OUTPUT })
	public List<Produto> listAllTiposEmbalagens() {

		return produtoService.getAllProdutoService();

	}

	@GET
	@Path("/get-produto")
	@Produces(MediaType.APPLICATION_JSON)
	@JacksonFeatures(serializationEnable = { SerializationFeature.INDENT_OUTPUT })
	public Produto listAllTiposEmbalagens(@QueryParam("id") Long produto) {

		if (produto == null) {
			log.error("Transação inválida");
		}

		try {

			return produtoService.getProdutoByIdService(produto);

		} catch (Exception ex) {
			log.error("Transação inválida " + ex.getMessage());
		}

		return null;
	}

	@POST
	@Path("/register-produto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response registerTransaction(Produto produto) {

		if (produto == null) {
			log.error("Transação inválida");
			return Response.status(500).entity("Transação inválida").build();
		}

		try {

			produtoService.insertProdutoService(produto);

			return Response.status(200).entity("SUCESSO: " + produto.toString()).build();

		} catch (Exception ex) {
			log.error("Transação inválida " + ex.getMessage());
			return Response.status(500).entity("Transação inválida " + ex.getMessage()).build();
		}

	}

	@GET
	@Path("/exemplo/register-produto")
	@Produces(MediaType.TEXT_PLAIN)
	public String testService() {

		log.info(Constantes.INSERT_TIPO_EMBALAGEM_EXEMPLO);
		return "Exemplo de chamada para /API/vendas/register-produto:\n" + Constantes.INSERT_PRODUTO_EXEMPLO;

	}

}
