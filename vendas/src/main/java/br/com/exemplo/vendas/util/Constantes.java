package br.com.exemplo.vendas.util;

public class Constantes {

	/**
	 * String para formação de saída para DATAS
	 */
	public static final String FORMATO_DATA = "dd/MM/yyyy HH:mm:ss";

	public static final String INSERT_VENDA_EXEMPLO = "{" + " \"id_venda\": \"\"," + "\"itens_venda\": [" + "    {"
			+ "\"produto\": {" + "        \"id_produto\": 3" + "}," + "\"quantidade\": 1.0" + "}," + "{"
			+ "      \"produto\": {" + "\"id_produto\": 1" + "}," + "\"quantidade\": 2.0" + "}" + "]" + "}";

	public static final String INSERT_TIPO_EMBALAGEM_EXEMPLO = "  {" + "\"tp_embalagem\": \"PACOTE 500g\"" + "}";

	public static final String INSERT_PRODUTO_EXEMPLO = "  {" + "\"id_produto\": \"\","
			+ "    \"descricao\": \"lasanha\"," + "\"vlr_unitario\": 5.2," + "\"tp_embalagem\": {"
			+ "      \"id_tp_embalagem\": 2" + "}" + "  }";

}
