/**
 *
 */
package br.com.sgb.sgbutil.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import br.com.sgb.sgbutils.R;

/**
 * @author EGILCRU
 */
public class UtilsRede {

    /**
     * Verificar se a rede esta disponivel
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();

            if (info != null) {
                for (NetworkInfo in : info) {
                    if (in.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * validarRedeDisponivel
     *
     * @param context
     * @return boolean
     */
    public static boolean validarRedeDisponivel(Context context) {
        boolean ret = true;

        if (!isNetworkAvailable(context)) {
            Utils.mensagemErro(context, R.string.app_mensagem_erro_conexao);
            ret = false;
        }

        return ret;
    }

    /**
     * Validar se a rede (internet) esta disponvel
     *
     * @param context
     * @return boolean
     */
    public static boolean redeDisponivel(Context context) {
        boolean ret = true;

        if (!isNetworkAvailable(context)) {
            ret = false;
        }

        return ret;
    }

    public static String getEnderecoIPLocal() {
        String ip = "";
        try {
            Enumeration<NetworkInterface> enumNetworkInterfaces = NetworkInterface
                    .getNetworkInterfaces();
            while (enumNetworkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = enumNetworkInterfaces
                        .nextElement();
                Enumeration<InetAddress> enumInetAddress = networkInterface
                        .getInetAddresses();
                while (enumInetAddress.hasMoreElements()) {
                    InetAddress inetAddress = enumInetAddress.nextElement();

                    if (inetAddress.isSiteLocalAddress()) {
                        ip = inetAddress.getHostAddress();
                    }
                }
            }

        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ip += "Algo errado! " + e.toString();
        }

        return ip;
    }
}
