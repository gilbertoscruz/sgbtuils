/**
 * 
 */
package br.com.sgb.sgbutil.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import br.com.sgb.sgbutil.fonte.UtilsFonte;
import br.com.sgb.sgbutils.R;

/**
 * @author EGILCRU
 *
 */
public class UtilsDialog {

    public interface DialogInterface {

    }

	/**
	 * showErrorDialog
	 * @param msg
	 * @param fonte
	 */
	public static void showErrorDialog(final Context context,
			final String msg, final UtilsFonte.TipoFonte fonte) {

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_error);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        
        UtilsFonte.setFonteObjetos(context,
        		dialog.findViewById(R.id.text_dialog), fonte);
        
        UtilsFonte.setFonteObjetos(context,
        		dialog.findViewById(R.id.btn_dialog), fonte);

        dialog.show();
    }
	
	/**
	 * showErrorDialog
	 * @param activity
	 * @param msg
	 * @param fonte
	 */
	public static void showErrorDialog(final Activity activity,
			final String msg, final UtilsFonte.TipoFonte fonte) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_error);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        text.setText(msg);
        

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        
        UtilsFonte.setFonteObjetos(activity,
        		dialog.findViewById(R.id.text_dialog), fonte);
        
        UtilsFonte.setFonteObjetos(activity,
        		dialog.findViewById(R.id.btn_dialog), fonte);

        dialog.show();
    }
	
	/**
	 * showErrorDialog
	 * @param activity
	 * @param msg
	 * @param fonte
	 */
	public static void showInfoDialog(final Context context,
			final String msg, final UtilsFonte.TipoFonte fonte) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_informacao);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        
        UtilsFonte.setFonteObjetos(context,
        		dialog.findViewById(R.id.text_dialog), fonte);
        
        UtilsFonte.setFonteObjetos(context,
        		dialog.findViewById(R.id.btn_dialog), fonte);

        dialog.show();
    }
	
	/**
	 * showErrorDialog
	 * @param activity
	 * @param msg
	 * @param fonte
	 */
	public static void showInfoDialog(final Activity activity,
			final String msg, final UtilsFonte.TipoFonte fonte) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_informacao);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        text.setText(msg);
        

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        
        UtilsFonte.setFonteObjetos(activity,
        		dialog.findViewById(R.id.text_dialog), fonte);
        
        UtilsFonte.setFonteObjetos(activity,
        		dialog.findViewById(R.id.btn_dialog), fonte);

        dialog.show();
    }

}
