package br.com.sgb.sgbutil.util;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import br.com.sgb.sgbutil.consts.Consts;

/**
 * Created by Janaina on 03/11/2016.
 */

public class UtilsZip {

    private static final int ZIP_BUFFER = 80000;

    /**
     * Zip arquivo
     * @param arquivos
     * @param nomeZip
     * @return String
     * @throws Exception
     */
    public static void zipArquivo(String[] arquivos, String nomeZip) throws Exception {
        BufferedInputStream origin = null;
        FileOutputStream dest = new FileOutputStream(nomeZip);
        ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));

        byte data[] = new byte[ZIP_BUFFER];

        for (int i = 0; i < arquivos.length; i++) {
            Log.d(Consts.TAG, arquivos[i]);
            Log.v(Consts.TAG, "Adicionando arquivo no ZIP: " + arquivos[i]);

            FileInputStream fi = new FileInputStream(arquivos[i]);
            origin = new BufferedInputStream(fi, ZIP_BUFFER);
            ZipEntry entry = new ZipEntry(arquivos[i].substring(arquivos[i].lastIndexOf("/") + 1));
            out.putNextEntry(entry);

            int count;
            while ((count = origin.read(data, 0, ZIP_BUFFER)) != -1) {
                out.write(data, 0, count);
            }
            origin.close();
        }

        out.close();
    }

}
