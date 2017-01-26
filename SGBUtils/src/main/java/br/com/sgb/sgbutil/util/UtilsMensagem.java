package br.com.sgb.sgbutil.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.Window;
import android.widget.TextView;

import br.com.sgb.sgbutils.R;

/**
 * Created by Janaina on 30/11/2016.
 */

public class UtilsMensagem {

    /**
     * Alerta de Mensagem - Tipo: Erro
     * @param context
     * @param message
     */
    public static Dialog alertaMensagemErro(final Context context, final int message){
        Dialog dlg = new AlertDialog.Builder(context, R.style.AlertDialogCustom)
                .setTitle(context.getString(R.string.app_titulo_janela_erro))
                //.setIcon(R.drawable.ic_error_image)
                .setMessage(context.getString(message))
                .setPositiveButton(context.getString(R.string.app_titulo_btn_ok),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                            }
                        }).create();
        //dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dlg;
    }

    /**
     * Alerta de Mensagem - Tipo: Erro
     * @param context
     * @param message
     */
    public static Dialog alertaMensagemErro(final Context context, final String message){
        Dialog dlg = new AlertDialog.Builder(context, R.style.AlertDialogCustom)
                //.setIcon(R.drawable.ic_error_image)
                .setTitle(context.getString(R.string.app_titulo_janela_erro))
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.app_titulo_btn_ok),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                            }
                        }).create();
        //dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dlg;
    }

    /**
     * Alerta de Mensagem - Tipo: Alerta
     * @param context
     * @param message
     */
    public static Dialog alertaMensagemAlerta(final Context context, final int message){
        Dialog dlg = new AlertDialog.Builder(context, R.style.AlertDialogCustom)
                //.setIcon(R.drawable.ic_warning_image)
                .setTitle(context.getString(R.string.app_titulo_janela_atencao))
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.app_titulo_btn_ok),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                            }
                        }).create();
        //dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dlg;
    }

    /**
     * Alerta de Mensagem - Tipo: Alerta
     * @param context
     * @param message
     */
    public static Dialog alertaMensagemAlerta(final Context context, final String message){
        Dialog dlg = new AlertDialog.Builder(context, R.style.AlertDialogCustom)
                //.setIcon(R.drawable.ic_warning_image)
                .setTitle(context.getString(R.string.app_titulo_janela_atencao))
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.app_titulo_btn_ok),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                            }
                        }).create();
        //dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dlg;
    }

    /**
     * Alerta de Mensagem - Tipo: Alerta
     * @param context
     * @param message
     */
    public static Dialog alertaMensagemAlertaSimNao(final Context context, final String message,
                                                  DialogInterface.OnClickListener positivoListener,
                                                  DialogInterface.OnClickListener negativoListener){
        Dialog dlg = new AlertDialog.Builder(context, R.style.AlertDialogCustom)
                //.setIcon(R.drawable.ic_warning_image)
                .setTitle(context.getString(R.string.app_titulo_janela_atencao))
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.app_titulo_botao_sim), positivoListener)
                .setNegativeButton(context.getString(R.string.app_titulo_botao_nao), negativoListener)
                .create();
        //dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dlg;
    }

    /**
     * Alerta de Mensagem - Tipo: Informacao
     * @param context
     * @param message
     */
    public static Dialog alertaMensagemInfo(final Context context, final String message){
        final Dialog dlg = new AlertDialog.Builder(context, R.style.AlertDialogCustom)
                //.setIcon(R.drawable.ic_info_image)
                .setTitle(context.getString(R.string.app_titulo_janela_informacao))
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.app_titulo_btn_ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .create();

        //dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dlg;
    }

    public static Dialog alertaMensagemInfo(final Context context, final String message,
                                            DialogInterface.OnClickListener listener){
        Dialog dlg = new AlertDialog.Builder(context, R.style.AlertDialogCustom)
                //.setIcon(R.drawable.ic_info_image)
                .setTitle(context.getString(R.string.app_titulo_janela_informacao))
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.app_titulo_btn_ok), listener)
                .create();

        //dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dlg;
    }

    /**
     * Alerta de Mensagem - Tipo: Informacao
     * @param context
     * @param message
     */
    public static Dialog alertaMensagemInfoSimNao(final Context context, final String message,
                                                  DialogInterface.OnClickListener positivoListener,
                                                  DialogInterface.OnClickListener negativoListener){
        Dialog dlg = new AlertDialog.Builder(context, R.style.AlertDialogCustom)
                //.setIcon(R.drawable.ic_info_image)
                .setTitle(context.getString(R.string.app_titulo_janela_informacao))
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.app_titulo_botao_sim), positivoListener)
                .setNegativeButton(context.getString(R.string.app_titulo_botao_nao), negativoListener)
                .create();
        //dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dlg;
    }

    /**
     * Alerta de Mensagem - Tipo: Confirmacao
     * @param context
     * @param message
     */
    public static Dialog alertaMensagemConfirmarSimNao(final Context context, final String message,
                                                DialogInterface.OnClickListener positivoListener,
                                                DialogInterface.OnClickListener negativoListener){
        Dialog dlg = new AlertDialog.Builder(context, R.style.AlertDialogCustom)
                //.setIcon(R.drawable.ic_help_image)
                .setTitle(context.getString(R.string.app_titulo_janela_confirmacao))
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.app_titulo_botao_sim), positivoListener)
                .setNegativeButton(context.getString(R.string.app_titulo_botao_nao), negativoListener)
                .create();
        //dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dlg;
    }
}
