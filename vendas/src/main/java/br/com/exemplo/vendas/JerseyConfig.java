package br.com.exemplo.vendas;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import br.com.exemplo.vendas.ws.HealthCheckApiController;
import br.com.exemplo.vendas.ws.ItemVendaApiController;
import br.com.exemplo.vendas.ws.ProdutoApiController;
import br.com.exemplo.vendas.ws.TipoEmbalagemApiController;
import br.com.exemplo.vendas.ws.VendaApiController;

/**
 * @author fernandopucci
 * 
 *         Classe de configuração dos serviços REST
 */
@Configuration
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(TipoEmbalagemApiController.class);
		register(HealthCheckApiController.class);
		register(ItemVendaApiController.class);
		register(ProdutoApiController.class);
		register(VendaApiController.class);

	}
}
