/*
 * Copyright 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.sgb.sgbutil.util;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import br.com.sgb.sgbutils.R;

/**
 * Helper class providing methods and constants common to other classes in the
 * app.
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public final class Utils {

	private static String fontPathTitulo = "font/Roboto-Medium.ttf";
	private static String fontPathTexto = "font/Roboto-Light.ttf";
	private static Typeface typefaceTitulo;
	private static Typeface typefaceTexto;

	static {
		typefaceTitulo = null;
		typefaceTexto = null;
	}

	private static Typeface getTypefaceTitulo(AssetManager context) {
		if (typefaceTitulo == null) {
			typefaceTitulo = Typeface.createFromAsset(context, fontPathTitulo);
		}
		return typefaceTitulo;
	}
	
	private static Typeface getTypefaceTexto(AssetManager context) {
		if (typefaceTexto == null) {
			typefaceTexto = Typeface.createFromAsset(context, fontPathTexto);
		}
		return typefaceTexto;
	}
	
	public static void setFonteTitulo(final Context context, final View v) {
		((TextView) v).setTypeface(getTypefaceTitulo(context.getAssets()));
	}
	
	/**
	 * Subistitui as fontes do objeto
	 * @param context
	 * @param v
	 */
	public static void substituirFontes(final Context context, final View v) {
		try {
			if (v instanceof ViewGroup) {
				ViewGroup vg = (ViewGroup) v;
				for (int i = 0; i < vg.getChildCount(); i++) {
					View child = vg.getChildAt(i);
					substituirFontes(context, child);
				}
			} else if (v instanceof TextView) {
				((TextView) v).setTypeface(getTypefaceTexto(context.getAssets()));
			}
		} catch (Exception e) {
		}
	}
	
	/**
	 * Verificar se o campo esta nulo ou vazio
	 * @param edit
	 * @return
	 */
	public static boolean isEmptyEditText(EditText edit) {
		return edit.getText().toString().trim().equals("");
	}
	
	/**
	 * Mensagem de informao
	 * @param context
	 * @param title
	 * @param message
	 * @return
	 */
	public static Dialog mensagemInformacao(final Context context, final int title, 
			final int message, final int icon){
		Dialog dlg = new AlertDialog.Builder(context)
		.setIcon(icon)
		.setTitle(context.getString(title))
		.setMessage(context.getString(message))
		.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
					}
				}).create();
		dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

		return dlg;
	}
	
	/**
	 * Mensagem de erro
	 * @param context
	 * @param message
	 * @return
	 */
	public static Dialog mensagemErro(final Context context, final int message, 
			final int icon){
		Dialog dlg = new AlertDialog.Builder(context)
		.setIcon(icon)
		.setTitle(context.getString(R.string.app_titulo_erro))
		.setMessage(context.getString(message))
		.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
					}
				}).create();
		dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

		return dlg;
	}	
	
	/**
	 * Mensgagem de erro
	 * @param context
	 * @param message
	 * @param retunOKEvent
	 * @return
	 */
	public static Dialog mensagemErro(final Context context, final int message, 
			DialogInterface.OnClickListener retunOKEvent){
		Dialog dlg = new AlertDialog.Builder(context)
		.setTitle(context.getString(R.string.app_titulo_erro))
		.setMessage(context.getString(message))
		.setPositiveButton("OK", retunOKEvent).create();
		dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

		return dlg;
	}	

	/**
	 * Mensgagem de erro
	 * @param message
	 * @return
	 */
	public static Dialog mensagemErro(final Context context, final int message){
		Dialog dlg = new AlertDialog.Builder(context)
		.setTitle(context.getString(R.string.app_titulo_erro))
		.setMessage(context.getString(message))
		.setPositiveButton("OK",
		new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
			}
		}).create();
		dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

		return dlg;
	}
	
	/**
	 * Mensgagem de erro
	 * @param message
	 * @return
	 */
	public static Dialog mensagemErro(final Context context, final String message){
		Dialog dlg = new AlertDialog.Builder(context)
		.setTitle(context.getString(R.string.app_titulo_erro))
		.setMessage(message)
		.setPositiveButton("OK",
		new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
			}
		}).create();
		dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

		return dlg;
	}
	
	/**
	 * Mensagem de erro
	 * @param context
	 * @param title
	 * @param message
	 * @return
	 */
	public static Dialog mensagemErro(final Context context, final int title, 
			final int message, final int icon){
		Dialog dlg = new AlertDialog.Builder(context)
		.setIcon(icon)
		.setTitle(context.getString(title))
		.setMessage(context.getString(message))
		.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
					}
				}).create();
		dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

		return dlg;
	}
	
	/**
	 * Mensgagem de erro
	 * @param context
	 * @param title
	 * @param message
	 * @param retunOKEvent
	 * @return
	 */
	public static Dialog mensagemErro(final Context context, final int title, 
			final int message, final int icon, 
			DialogInterface.OnClickListener retunOKEvent){
		Dialog dlg = new AlertDialog.Builder(context)
		.setIcon(icon)
		.setTitle(context.getString(title))
		.setMessage(context.getString(message))
		.setPositiveButton("OK", retunOKEvent).create();
		dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

		return dlg;
	}
	
	/**
	 * Mensagem de confirmao
	 * @param context
	 * @param title
	 * @param message
	 * @param retunYesEvent
	 * @param retunNoEvent
	 * @return
	 */
	public static Dialog mensagemConfirmacao(final Context context, final int title, 
			final int message, final int icon, DialogInterface.OnClickListener retunYesEvent,
			DialogInterface.OnClickListener retunNoEvent) {
		
		Dialog dlg = new AlertDialog.Builder(context)
				//.setIcon(icon)
				.setMessage(context.getString(message))
				.setPositiveButton(context.getString(R.string.app_titulo_botao_sim),
						retunYesEvent)
				.setNegativeButton(context.getString(R.string.app_titulo_botao_nao),
						retunNoEvent).create();

		if (title != 0) {
			dlg.setTitle(context.getString(title));
		} else {
			dlg.setTitle(R.string.app_titulo_confirmar);
		}
		
		dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
		return dlg;
	}
	
	/**
	 * Mensagem de confirmao
	 * @param context
	 * @param title
	 * @param message
	 * @param retunYesEvent
	 * @param retunNoEvent
	 * @return
	 */
	public static Dialog mensagemConfirmacao(final Context context, final int message, 
			DialogInterface.OnClickListener retunYesEvent,
			DialogInterface.OnClickListener retunNoEvent) {
		
		Dialog dlg = new AlertDialog.Builder(context)
				.setTitle(R.string.app_titulo_confirmar)
				.setMessage(context.getString(message))
				.setPositiveButton(context.getString(R.string.app_titulo_botao_sim),
						retunYesEvent)
				.setNegativeButton(context.getString(R.string.app_titulo_botao_nao),
						retunNoEvent).create();
		dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
		return dlg;
	}
	
	public static Dialog mensagemConfirmacao(final Context context, final String message, 
			DialogInterface.OnClickListener retunYesEvent,
			DialogInterface.OnClickListener retunNoEvent) {
		
		Dialog dlg = new AlertDialog.Builder(context)
				.setTitle(R.string.app_titulo_confirmar)
				.setMessage(message)
				.setPositiveButton(context.getString(R.string.app_titulo_botao_sim),
						retunYesEvent)
				.setNegativeButton(context.getString(R.string.app_titulo_botao_nao),
						retunNoEvent).create();
		dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
		return dlg;
	}
	
	public static void setFillCustomGradient(View v, final int cor1,
			final int cor2, final int cor3, final int cor4) {
		final View view = v;
		Drawable[] layers = new Drawable[1];

		ShapeDrawable.ShaderFactory sf = new ShapeDrawable.ShaderFactory() {
			@Override
			public Shader resize(int width, int height) {
				LinearGradient lg = new LinearGradient(0, 0, 0,
						view.getHeight(), new int[] { cor1, // please input your
															// color from
															// resource for
															// color-4
								cor2, cor3, cor4 }, new float[] { 0, 0.49f,
								0.50f, 1 }, Shader.TileMode.CLAMP);
				return lg;
			}
		};
		PaintDrawable p = new PaintDrawable();
		p.setShape(new RectShape());
		p.setShaderFactory(sf);
		p.setCornerRadii(new float[] { 5, 5, 5, 5, 0, 0, 0, 0 });
		layers[0] = (Drawable) p;

		LayerDrawable composite = new LayerDrawable(layers);
		view.setBackground(composite);
	}
	
	/**
	 * Fechar o teclado virtual
	 * @param context
	 * @param view
	 * @return boolean
	 */
	public static boolean fecharVirtualKeyboard(Context context, View view) {
		InputMethodManager imm = (InputMethodManager) context
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		if (imm != null) {
			boolean b = imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
			return b;
		}
		return false;
	}

	/**
	 * This method converts dp unit to equivalent pixels, depending on device density. 
	 * 
	 * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
	 * @param context Context to get resources and device specific display metrics
	 * @return A float value to represent px equivalent to dp depending on device density
	 */
	public static float convertDpToPixel(float dp, Context context){
	    //Resources resources = context.getResources();
	    //DisplayMetrics metrics = resources.getDisplayMetrics();
	    float px = dp * (DisplayMetrics.DENSITY_LOW / 160f);
	    return px;
	}
	
	/**
	 * This method converts device specific pixels to density independent pixels.
	 * 
	 * @param px A value in px (pixels) unit. Which we need to convert into db
	 * @param context Context to get resources and device specific display metrics
	 * @return A float value to represent dp equivalent to px value
	 */
	public static float convertPixelsToDp(float px, Context context){
	    //Resources resources = context.getResources();
	    //DisplayMetrics metrics = resources.getDisplayMetrics();
	    float dp = px / (DisplayMetrics.DENSITY_LOW / 160f);
	    return dp;
	}


}
