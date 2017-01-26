/**
 * 
 */
package br.com.sgb.sgbutil.propriedade;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * @author egilcru
 * 
 */
public class UtilsProp {

	/**
	 * Obtem o valor de uma propriedade e retorna um valor em String
	 * @param contexto
	 * @param preferencia
	 * @param propriedade
	 * @return String
	 */
	public static String getPropriedadeString(Context contexto, String preferencia,
			String propriedade) {
		SharedPreferences settings = contexto.getSharedPreferences(preferencia, Activity.MODE_PRIVATE);
		return settings.getString(propriedade, "");
	}
	
	/**
	 * Obtem o valor de uma propriedade e retorna um valor em Integer
	 * @param contexto
	 * @param preferencia
	 * @param propriedade
	 * @return Integer
	 */
	public static Integer getPropriedadeInteger(Context contexto, String preferencia,
			String propriedade) {
		SharedPreferences settings = contexto.getSharedPreferences(preferencia, Activity.MODE_PRIVATE);
		return settings.getInt(propriedade, 0);
	}

	/**
	 * Obtem o valor de uma propriedade e retorna um valor em Float
	 * @param contexto
	 * @param preferencia
	 * @param propriedade
	 * @return Float
	 */
	public static Float getPropriedadeFloat(Context contexto, String preferencia,
			String propriedade) {
		SharedPreferences settings = contexto.getSharedPreferences(preferencia, Activity.MODE_PRIVATE);
		return settings.getFloat(propriedade, 0);
	}

	/**
	 * Obtem o valor de uma propriedade e retorna um valor em Long
	 * @param contexto
	 * @param preferencia
	 * @param propriedade
	 * @return Long
	 */
	public static Long getPropriedadeLong(Context contexto, String preferencia,
			String propriedade) {
		SharedPreferences settings = contexto.getSharedPreferences(preferencia, Activity.MODE_PRIVATE);
		return settings.getLong(propriedade, 0);
	}

	/**
	 * Obtem o valor de uma propriedade e retorna um valor em Boolean
	 * @param contexto
	 * @param preferencia
	 * @param propriedade
	 * @return Boolean
	 */
	public static Boolean getPropriedadeBoolean(Context contexto, String preferencia,
			String propriedade) {
		SharedPreferences settings = contexto.getSharedPreferences(preferencia, Activity.MODE_PRIVATE);
		return settings.getBoolean(propriedade, false);
	}
	
	
	/**
	 * Obtem o valor de uma propriedade e retorna um valor em String
	 * @param contexto
	 * @param preferencia
	 * @param propriedade
	 * @return String
	 */
	public static String getPropriedadeStringDefault(Context contexto, String propriedade) {
		SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(contexto);
		return sharedPrefs.getString(propriedade, "");
	}
	
	/**
	 * Obtem o valor de uma propriedade e retorna um valor em Boolean
	 * @param contexto
	 * @param preferencia
	 * @param propriedade
	 * @return Boolean
	 */
	public static Boolean getPropriedadeBooleanDefault(Context contexto, String propriedade) {
		SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(contexto);
		return settings.getBoolean(propriedade, false);
	}
	
	/**
	 * Obtem o valor de uma propriedade e retorna um valor em Integer
	 * @param contexto
	 * @param preferencia
	 * @param propriedade
	 * @return Integer
	 */
	public static Integer getPropriedadeIntegerDefault(Context contexto,
			String propriedade) {
		SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(contexto);
		return settings.getInt(propriedade, 0);
	}
	
	/*************************************************************************/
	/*************************************************************************/
	/*************************************************************************/
	/*************************************************************************/
	
	/**
	 * Salva a preferencia do valor String
	 * @param contexto
	 * @param preferencia
	 * @param propriedade
	 * @param valor
	 */
	public static void setPreferenciaString(Context contexto, String preferencia,
			String propriedade, String valor) {
		SharedPreferences settings = contexto.getSharedPreferences(preferencia, Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(propriedade, valor);
		editor.commit();		
	}

	/**
	 * Salva a preferencia do valor Integer
	 * @param contexto
	 * @param preferencia
	 * @param propriedade
	 * @param valor
	 */
	public static void setPreferenciaInteger(Context contexto, String preferencia,
			String propriedade, Integer valor) {
		SharedPreferences settings = contexto.getSharedPreferences(preferencia, Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt(propriedade, valor);
		editor.commit();		
	}
	
	/**
	 * Salva a preferencia do valor Float
	 * @param contexto
	 * @param preferencia
	 * @param propriedade
	 * @param valor
	 */
	public static void setPreferenciaFloat(Context contexto, String preferencia,
			String propriedade, Float valor) {
		SharedPreferences settings = contexto.getSharedPreferences(preferencia, Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putFloat(propriedade, valor);
		editor.commit();		
	}
	
	/**
	 * Salva a preferencia do valor Long
	 * @param contexto
	 * @param preferencia
	 * @param propriedade
	 * @param valor
	 */
	public static void setPreferenciaLong(Context contexto, String preferencia,
			String propriedade, Long valor) {
		SharedPreferences settings = contexto.getSharedPreferences(preferencia, Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putLong(propriedade, valor);
		editor.commit();		
	}
	
	/**
	 * Salva a preferencia do valor Boolean
	 * @param contexto
	 * @param preferencia
	 * @param propriedade
	 * @param valor
	 */
	public static void setPreferenciaBoolean(Context contexto, String preferencia,
			String propriedade, Boolean valor) {
		SharedPreferences settings = contexto.getSharedPreferences(preferencia, Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean(propriedade, valor);
		editor.commit();		
	}
	
	public static void setPreferenciaBooleanDefault(Context contexto, String preferencia,
			String propriedade, Boolean valor) {
		SharedPreferences settings = contexto.getSharedPreferences(preferencia, Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean(propriedade, valor);
		editor.commit();		
	}
	
}
