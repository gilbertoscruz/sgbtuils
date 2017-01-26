/**
 * @user: Gilberto Sanches Cruz
 * @date: Aug 22, 2012
 * @hour: 4:11:12 PM
 */
package br.com.sgb.sgbutil.gps;

import android.location.Location;

/**
 * @author EGILCRU
 * 
 */
public interface GPSCallback {

	public abstract void onGPSUpdate(Location location);

}
