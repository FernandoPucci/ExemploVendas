package br.com.exemplo.vendas.util;

import java.text.SimpleDateFormat;

public class Utils {
	
	/**
	 * @param data
	 * @return Retorna Data formatada
	 * 
	 */
	public static String formataData(java.util.Date data) {

		SimpleDateFormat fmt = new SimpleDateFormat(Constantes.FORMATO_DATA);

		String str = fmt.format(data);

		return str;

	}

}
