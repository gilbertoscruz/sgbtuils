/**
 * 
 */
package br.com.sgb.sgbutil.util;

import android.text.TextUtils;
import android.util.Log;
import br.com.sgb.sgbutils.BuildConfig;

/**
 * @author EGILCRU
 *
 */
public class AppLog {

	public static void log(final String TAG, final String message) {
		if (BuildConfig.DEBUG) {
            Log.i(TAG, TextUtils.isEmpty(message) ? "Could not print log." : message);
        }
	}
	
}
