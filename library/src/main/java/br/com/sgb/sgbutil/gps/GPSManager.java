/**
 * @user: Gilberto Sanches Cruz
 * @date: Aug 22, 2012
 * @hour: 4:11:53 PM
 */
package br.com.sgb.sgbutil.gps;

import java.util.List;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;

/**
 * @author EGILCRU
 * 
 */
public class GPSManager {

	private static final int gpsMinTime = 300;
	private static final int gpsMinDistance = 1;
	private static final String TAG = "GPSManager";

	private static LocationManager locationManager = null;
	private static LocationListener locationListener = null;
	private GPSCallback gpsCallback = null;

	public GPSManager() {
		GPSManager.locationListener = new LocationListener() {
			@Override
			public void onLocationChanged(final Location location) {
				if (gpsCallback != null) {
					gpsCallback.onGPSUpdate(location);
				}
			}

			@Override
			public void onProviderDisabled(final String provider) {
			}

			@Override
			public void onProviderEnabled(final String provider) {
			}

			@Override
			public void onStatusChanged(final String provider,
					final int status, final Bundle extras) {

				switch (status) {
				case LocationProvider.OUT_OF_SERVICE:
					Log.i(TAG, "Status Changed: Out of Service");
					break;
				case LocationProvider.TEMPORARILY_UNAVAILABLE:
					Log.i(TAG, "Status Changed: Temporarily Unavailable");
					break;
				case LocationProvider.AVAILABLE:
					Log.i(TAG, "Status Changed: Available");
					break;
				}

			}
		};
	}

	public GPSCallback getGPSCallback() {
		return gpsCallback;
	}

	public void setGPSCallback(final GPSCallback gpsCallback) {
		this.gpsCallback = gpsCallback;
	}

	public void startListening(final Context context) {
		if (GPSManager.locationManager == null) {
			GPSManager.locationManager = (LocationManager) context
					.getSystemService(Context.LOCATION_SERVICE);
		}

		final Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		criteria.setSpeedRequired(true);
		criteria.setAltitudeRequired(true);
		criteria.setBearingRequired(false);
		criteria.setCostAllowed(true);
		criteria.setPowerRequirement(Criteria.POWER_LOW);

		final String bestProvider = GPSManager.locationManager.getBestProvider(
				criteria, true);

		if (bestProvider != null && bestProvider.length() > 0) {
			GPSManager.locationManager.requestLocationUpdates(bestProvider,
					GPSManager.gpsMinTime, GPSManager.gpsMinDistance,
					GPSManager.locationListener);
		} else {
			final List<String> providers = GPSManager.locationManager
					.getProviders(true);

			for (final String provider : providers) {
				GPSManager.locationManager.requestLocationUpdates(provider,
						GPSManager.gpsMinTime, GPSManager.gpsMinDistance,
						GPSManager.locationListener);
			}
		}
	}

	public void stopListening() {
		try {
			if (GPSManager.locationManager != null
					&& GPSManager.locationListener != null) {
				GPSManager.locationManager
						.removeUpdates(GPSManager.locationListener);
			}

			GPSManager.locationManager = null;
		} catch (final Exception ex) {
		}
	}

}
