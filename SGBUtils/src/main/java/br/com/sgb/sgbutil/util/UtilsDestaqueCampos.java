/**
 * 
 */
package br.com.sgb.sgbutil.util;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author egilcru
 *
 */
public class UtilsDestaqueCampos {

	/**
	 * Destaca para o usuario o uso de campo obrigatorio
	 * @param campo
	 * @param corLetra
	 * @param estiloFundo
	 */
	@SuppressLint("NewApi")
	public static void destacarCampoObrigatorio(View campo, int corLetra,
			int estiloFundo) {
		//campo.setBackgroundColor(corFundo);
		campo.setBackgroundColor(estiloFundo);
		
		if (campo.getClass() == EditText.class ) {
			((EditText)campo).setTextColor(corLetra);
		} else if (campo.getClass() == TextView.class ) {
			((EditText)campo).setTextColor(corLetra);
		} 
	}

	
	/**
	 * Remove todas as marcaes de campos obrigatorios
	 * @param campos
	 * @param corLetra
	 * @param corFundo
	 */
	public static void retiraMarcacaoCampoObrigatorio(View[] campos,
			int corLetra, int corFundo) {
		for (View campo : campos) {
			campo.setBackgroundColor(corFundo);
			
			if (campo.getClass() == EditText.class ) {
				((EditText)campo).setTextColor(corLetra);
			} else if (campo.getClass() == TextView.class ) {
				((EditText)campo).setTextColor(corLetra);
			}
		}
	}
	
}
