/**
 *
 */
package br.com.sgb.sgbutil.fonte;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author EGILCRU
 */
public class UtilsFonte {

    private static String fonte1_Path_Negrito = "font/fonte1/Amaranth-Bold.ttf";
    private static String fonte1_Path_NegritoItalico = "font/fonte1/Amaranth-BoldItalic.ttf";
    private static String fonte1_Path_Italico = "font/fonte1/Amaranth-Italic.ttf";
    private static String fonte1_Path_Regular = "font/fonte1/Amaranth-Regular.ttf";

    private static String fonte2_Path_Negrito = "font/fonte2/newscycle-bold.ttf";
    private static String fonte2_Path_Regular = "font/fonte2/newscycle-regular.ttf";

    private static String fonte3_Path_Negrito = "font/fonte3/Roboto-Bold.ttf";
    private static String fonte3_Path_Regular = "font/fonte3/Roboto-Regular.ttf";

    private static String fonte4_Path_Negrito = "font/fonte4/Rambla-Bold.ttf";
    private static String fonte4_Path_NegritoItalico = "font/fonte4/Rambla-BoldItalic.ttf";
    private static String fonte4_Path_Italico = "font/fonte4/Rambla-Italic.ttf";
    private static String fonte4_Path_Regular = "font/fonte4/Rambla-Regular.ttf";

    private static String fonte5_Path_Negrito = "font/fonte5/SUSANNA_Regular.ttf";

    private static String fonte6_Path_Regular = "font/fonte6/OpenSans-Regular.ttf";
    private static String fonte6_Path_Negrito = "font/fonte6/OpenSans-Bold.ttf";

    // private static Typeface typefaceTexto;

    public enum TipoFonte {
        Fonte1_Negrito, Fonte1_NegritoItalico, Fonte1_Italico, Fonte1_Regular,
        Fonte2_Negrito, Fonte2_Regular, Fonte3_Negrito, Fonte3_Regular,
        Fonte4_Negrito, Fonte4_NegritoItalico, Fonte4_Italico, Fonte4_Regular,
        Fonte5_Regular, Fonte6_Regular, Fonte6_Negrito
    }

    ;

    static {
        // typefaceTexto = null;
    }

    public static Typeface getTypefaceObjeto(AssetManager context,
                                             TipoFonte tipoFonte) {

        switch (tipoFonte) {
            case Fonte1_Negrito:
                return Typeface.createFromAsset(context, fonte1_Path_Negrito);
            case Fonte1_NegritoItalico:
                return Typeface.createFromAsset(context, fonte1_Path_NegritoItalico);
            case Fonte1_Italico:
                return Typeface.createFromAsset(context, fonte1_Path_Italico);
            case Fonte1_Regular:
                return Typeface.createFromAsset(context, fonte1_Path_Regular);

            case Fonte2_Negrito:
                return Typeface.createFromAsset(context, fonte2_Path_Negrito);
            case Fonte2_Regular:
                return Typeface.createFromAsset(context, fonte2_Path_Regular);

            case Fonte3_Negrito:
                return Typeface.createFromAsset(context, fonte3_Path_Negrito);
            case Fonte3_Regular:
                return Typeface.createFromAsset(context, fonte3_Path_Regular);

            case Fonte4_Negrito:
                return Typeface.createFromAsset(context, fonte4_Path_Negrito);
            case Fonte4_NegritoItalico:
                return Typeface.createFromAsset(context, fonte4_Path_NegritoItalico);
            case Fonte4_Italico:
                return Typeface.createFromAsset(context, fonte4_Path_Italico);
            case Fonte4_Regular:
                return Typeface.createFromAsset(context, fonte4_Path_Regular);

            case Fonte5_Regular:
                return Typeface.createFromAsset(context, fonte5_Path_Negrito);

            case Fonte6_Regular:
                return Typeface.createFromAsset(context, fonte6_Path_Regular);
            case Fonte6_Negrito:
                return Typeface.createFromAsset(context, fonte6_Path_Negrito);

        }
        // }

        // return typefaceTexto;
        return Typeface.DEFAULT;
    }

    /**
     * Informar o tipo de fonte do objeto
     *
     * @param context
     * @param v
     */
    public static void setFonteObjeto(final Context context, final View v,
                                      final TipoFonte tipoFonte) {
        setFonteObjetos(context, v, tipoFonte);
    }

    /**
     * Subistitui as fontes do objeto
     *
     * @param context
     * @param v
     * @param tipoFonte
     */
    public static void setFonteObjetos(final Context context, final View v,
                                       final TipoFonte tipoFonte) {
        try {
            if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;

                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    setFonteObjetos(context, child, tipoFonte);
                }
            } else if (v instanceof TextView) {
                ((TextView) v).setTypeface(getTypefaceObjeto(
                        context.getAssets(), tipoFonte));
            }
        } catch (Exception e) {
        }
    }

}
