package br.com.exemplo.vendas.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fernandopucci
 *
 */
@Component
@RestController
@Path("/API")
public class VendasApiController {
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String testService(){
		
		return "API Executando com Sucesso!";
		
	}	

}
