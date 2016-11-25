package br.com.exemplo.vendas;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import br.com.exemplo.vendas.ws.VendasApiController;

/**
 * @author fernandopucci
 * 
 * Classe de configuração dos serviços REST
 */
@Configuration
public class JerseyConfig extends ResourceConfig {
	
	
		public JerseyConfig() {
			register(VendasApiController.class);

	}
}
