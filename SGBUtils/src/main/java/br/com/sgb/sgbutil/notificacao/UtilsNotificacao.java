/**
 * 
 */
package br.com.sgb.sgbutil.notificacao;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import br.com.sgb.sgbutil.fonte.UtilsFonte;
import br.com.sgb.sgbutils.R;

/**
 * @author EGILCRU
 *
 */
public class UtilsNotificacao {

	/**
	 * Mostrar notificacao ao usuario
	 * 
	 * @param contexto
	 * @param numeroMsg
	 * @param titulo
	 * @param texto
	 * @param iconePequeno
	 * @param janela
	 * @return NotificationCompat.Builder
	 */
	public static NotificationCompat.Builder notificacaoMestre(
			Context contexto, int numeroMsg, String titulo,
			String texto, int iconePequeno, boolean vibrarNotificar,
			boolean somNotificar, String somCaminhoNotificar) {

		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				contexto);

		long[] vibrar = new long[] { 500, 1000, 1000 };

		mBuilder.setNumber(numeroMsg);
		mBuilder.setContentTitle(titulo);
		mBuilder.setContentText(texto);
		mBuilder.setTicker(titulo);
		mBuilder.setSmallIcon(iconePequeno);
		mBuilder.setAutoCancel(true);

		if (vibrarNotificar) {
			mBuilder.setVibrate(vibrar);
		}

		if (somNotificar) {
			mBuilder.setSound(Uri.parse(somCaminhoNotificar));
		}

		mBuilder.setLights(Color.GREEN, 1000, 1000);

		return mBuilder;
	}

	/**
	 * Noficar usuario de novas mensagens
	 * 
	 * @param contexto
	 * @param numeroMsg
	 * @param titulo
	 * @param texto
	 * @param iconePequeno
	 * @param vibrarNotificar
	 * @param somNotificar
	 * @param somCaminhoNotificar
	 * @return NotificationCompat.Builder
	 */
	public static NotificationCompat.Builder notificacao(Context contexto,
			int numeroMsg, View view, int titulo, int texto,
			int iconePequeno, boolean vibrarNotificar, boolean somNotificar,
			String somCaminhoNotificar) {

		return notificacaoMestre(contexto, numeroMsg, view
				.getResources().getString(titulo), view.getResources()
				.getString(texto), iconePequeno, vibrarNotificar, somNotificar,
				somCaminhoNotificar);
	}

	/**
	 * Noficar usuario de novas mensagens
	 * 
	 * @param contexto
	 * @param numeroMsg
	 * @param titulo
	 * @param texto
	 * @param iconePequeno
	 * @param vibrarNotificar
	 * @param somNotificar
	 * @param somCaminhoNotificar
	 * @return NotificationCompat.Builder
	 */
	public static NotificationCompat.Builder notificacao(Context contexto,
			int numeroMsg, String titulo, String texto,
			int iconePequeno, boolean vibrarNotificar, boolean somNotificar,
			String somCaminhoNotificar) {

		return notificacaoMestre(contexto, numeroMsg, titulo, texto,
				iconePequeno, vibrarNotificar, somNotificar,
				somCaminhoNotificar);
	}

	/**
	 * Noficar usuario de novas mensagens
	 * 
	 * @param contexto
	 * @param numeroMsg
	 * @param titulo
	 * @param texto
	 * @param iconePequeno
	 * @return NotificationCompat.Builder
	 */
	public static NotificationCompat.Builder notificacao(Context contexto,
			int numeroMsg, String titulo, String texto,
			int iconePequeno) {

		return notificacaoMestre(contexto, numeroMsg, titulo, texto,
				iconePequeno, false, false, "");
	}

	/**
	 * Noficar usuario de novas mensagens
	 * 
	 * @param contexto
	 * @param numeroMsg
	 * @param titulo
	 * @param texto
	 * @param iconePequeno
	 * @param vibrar
	 * @return
	 */
	public static NotificationCompat.Builder notificacao(Context contexto,
			int numeroMsg, String titulo, String texto,
			int iconePequeno, boolean vibrarNotificar) {

		return notificacaoMestre(contexto, numeroMsg, titulo, texto,
				iconePequeno, vibrarNotificar, false, "");
	}
	
	/**
	 * Mostrar mensagem toast
	 * @param contexto
	 * @param texto
	 */
	public static void mostrarToastMessage(Context contexto, String texto) {
		//Toast.makeText(contexto, texto, Toast.LENGTH_LONG).show();
		LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.toast, (ViewGroup) ((Activity) contexto).findViewById(R.id.toast_layout_root));

		TextView text = (TextView) layout.findViewById(R.id.toastViewText);
		UtilsFonte.setFonteObjeto(contexto, text, UtilsFonte.TipoFonte.Fonte4_Regular);
		text.setText(texto);

		Toast toast = new Toast(contexto);
		toast.setGravity(Gravity.BOTTOM, 0, 200);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(layout);

		toast.show();
	}
	
	/**
	 * Mostrar mensagem toast
	 * @param contexto
	 * @param texto
	 */
	public static void mostrarToastMessageError(Context contexto, String texto) {
		//Toast.makeText(contexto, texto, Toast.LENGTH_LONG).show();
		LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.toast_error, (ViewGroup) ((Activity) contexto).findViewById(R.id.toast_layout_root_error));

		TextView text = (TextView) layout.findViewById(R.id.toastViewText);
		UtilsFonte.setFonteObjeto(contexto, text, UtilsFonte.TipoFonte.Fonte4_Regular);
		text.setText(texto);

		Toast toast = new Toast(contexto);
		toast.setGravity(Gravity.BOTTOM, 0, 200);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(layout);

		toast.show();
	}
	
	/**
	 * Mostrar mensagem toast
	 * @param contexto
	 * @param texto
	 */
	public static void mostrarToastMessageSucesso(Context contexto, String texto) {
		//Toast.makeText(contexto, texto, Toast.LENGTH_LONG).show();
		LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.toast_sucesso, (ViewGroup) ((Activity) contexto).findViewById(R.id.toast_layout_root_sucesso));

		TextView text = (TextView) layout.findViewById(R.id.toastViewText);
		UtilsFonte.setFonteObjeto(contexto, text, UtilsFonte.TipoFonte.Fonte4_Regular);
		text.setText(texto);

		Toast toast = new Toast(contexto);
		toast.setGravity(Gravity.BOTTOM, 0, 200);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(layout);

		toast.show();
	}
	
	/**
	 * Mostrar mensagem toast
	 * @param contexto
	 * @param texto
	 */
	public static void mostrarToastMessageAtencao(Context contexto, String texto) {
		//Toast.makeText(contexto, texto, Toast.LENGTH_LONG).show();
		LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.toast_atencao, (ViewGroup) ((Activity) contexto).findViewById(R.id.toast_layout_root_atencao));

		TextView text = (TextView) layout.findViewById(R.id.toastViewText);
		UtilsFonte.setFonteObjeto(contexto, text, UtilsFonte.TipoFonte.Fonte4_Regular);
		text.setText(texto);

		Toast toast = new Toast(contexto);
		toast.setGravity(Gravity.BOTTOM, 0, 200);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(layout);

		toast.show();
	}

	public static void mostrarMensagemDialogErro(Context context, String texto) {

	}

}
