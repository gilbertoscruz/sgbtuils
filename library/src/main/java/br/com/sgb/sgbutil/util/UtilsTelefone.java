package br.com.sgb.sgbutil.util;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by EGILCRU on 25/07/2016.
 */
public class UtilsTelefone {

    /**
     * Get Phone IMEI Number
     * @param context
     * @return String
     */
    public static String getIMEI(final Context context) {
        final TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(
                Context.TELEPHONY_SERVICE);

        return telephonyManager.getDeviceId();
    }

    public static String getNumeroTelefone(final Context context) {
        final TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(
                Context.TELEPHONY_SERVICE);

        return telephonyManager.getLine1Number();
    }

}
