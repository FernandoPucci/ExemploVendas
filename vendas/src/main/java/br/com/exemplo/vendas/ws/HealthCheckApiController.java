package br.com.exemplo.vendas.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.vendas.service.TipoEmbalagemService;

/**
 * @author fernandopucci
 *
 */
@Component
@RestController
@Path("/API")
public class HealthCheckApiController {

	private static final Logger log = LoggerFactory.getLogger(HealthCheckApiController.class);

	@Autowired
	TipoEmbalagemService tipoEmbalagemService;

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String testService() {

		log.info("API Executando com Sucesso!");
		return "API Executando com Sucesso!";

	}
}
