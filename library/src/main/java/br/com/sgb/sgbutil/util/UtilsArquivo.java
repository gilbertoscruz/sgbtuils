/**
 * @project: SGBCookMobile
 * @user: Gilberto Sanches Cruz
 * @date: 23/10/2012
 * @hour: 19:04:14
 */
package br.com.sgb.sgbutil.util;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

import br.com.sgb.sgbutil.consts.Consts;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

/**
 * @author egilcru
 */
public class UtilsArquivo {

    public static String toString(InputStream in, String charset)
            throws IOException {
        byte[] bytes = toBytes(in);
        String texto = new String(bytes, charset);
        return texto;
    }

    public static byte[] toBytes(InputStream in) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            byte[] buffer = new byte[1024];
            int len;

            while ((len = in.read(buffer)) > 0) {
                bos.write(buffer, 0, len);
            }

            byte[] bytes = bos.toByteArray();
            return bytes;
        } catch (Exception e) {
            Log.e(Consts.TAG, e.getMessage(), e);
            return null;
        } finally {
            try {
                bos.close();
                in.close();
            } catch (Exception e) {
                Log.e(Consts.TAG, e.getMessage(), e);
            }
        }
    }

    /**
     * Gerar arquivos no cartao SD
     * @param context
     * @param sDiretorio
     * @param sFileName
     * @param sBody
     * @return
     */
    public static boolean gerarArquivoCartaoSD(Context context, String sDiretorio,
           String sFileName, String sBody) {
        try {
            File root = new File(Environment.getExternalStorageDirectory(), sDiretorio);
            if (!root.exists()) {
                root.mkdirs();
            }

            File gpxfile = new File(root, sFileName);

            FileWriter writer = new FileWriter(gpxfile, true);
            BufferedWriter out = new BufferedWriter(writer);
            out.append(sBody);
            out.close();

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean isArquivoExiste(Context context, String arquivo) {
        File root = new File(Environment.getExternalStorageDirectory(), arquivo);
        return root.isFile() && root.exists();
    }

    /**
     * Remover arquivo
     * @param arquivo
     * @return boolean
     */
    public static boolean removerArquivo(String arquivo) {
        final File root = new File(Environment.getExternalStorageDirectory(), arquivo);

        if (root.isFile()) {
            try {
                root.deleteOnExit();
            } catch (Exception e) {
                return false;
            } finally {
                return root.delete();
            }
        }

        return true;
    }

    /**
     * Remover todos os arquivos de uma pasta
     * @param diretorio
     * @return boolean
     */
    public static boolean removerArquivoPerfil(String diretorio) {
        final File root = new File(Environment.getExternalStorageDirectory(), diretorio);

        for (File f : root.listFiles()) {
            if (f.isFile()) {
                try {
                    f.deleteOnExit();
                } catch (Exception e) {
                    return false;
                } finally {
                    f.delete();
                }
            }
        }

        return true;
    }
}
