/**
 * @project: SGBCookMobile
 * @user: Gilberto Sanches Cruz
 * @date: 23/10/2012
 * @hour: 18:58:04
 */
package br.com.sgb.sgbutil.http;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;

import br.com.sgb.sgbutil.util.UtilsArquivo;

/**
 * @author egilcru
 * 
 */
public class HttpHelper {

	public static String doGet(String url, String charset) throws IOException,
			SocketTimeoutException {
		Log.i("SGBUtils", "doGet method start");
		
		HttpParams httpParameters = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParameters, 5000);
		HttpConnectionParams.setSoTimeout(httpParameters, 10000);
		
		DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
		HttpGet httpPost = new HttpGet(url);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		HttpEntity httpEntity = httpResponse.getEntity();
		
		Log.i("SGBUtils", "doGet method end");
		
		return EntityUtils.toString(httpEntity);		
	}

	public static Bitmap doGetBitmap(String url) throws IOException,
			SocketTimeoutException {
		URL u = new URL(URLEncoder.encode(url, "UTF-8"));
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5000);
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.connect();

		InputStream in = conn.getInputStream();
		byte[] bytes = UtilsArquivo.toBytes(in);

		in.close();
		conn.disconnect();
		Bitmap bitmap = null;

		if (bytes != null) {
			bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
		}
		return bitmap;
	}

}