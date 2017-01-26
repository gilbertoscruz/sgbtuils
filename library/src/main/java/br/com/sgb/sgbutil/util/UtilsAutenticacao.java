/**
 *
 */
package br.com.sgb.sgbutil.util;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import br.com.sgb.sgbutil.bean.AccountPlus;
import br.com.sgb.sgbutil.consts.Consts;

/**
 * @author egilcru
 *
 */
public class UtilsAutenticacao {

    /**
     * Obtem todas as contas de acordo com o tipo de conta
     *
     * @param manager
     * @param accountType
     * @return Account[]
     */
    public static Account[] getContas(final Context context, final AccountManager manager,
                                      final String accountType) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }

        return manager.getAccountsByType(accountType);
    }

    /**
     * Retorna a conta de usuario de acordo com o tipo e nome da conta
     *
     * @param manager
     * @param accountType
     * @param name
     * @return AccountPlus
     */
    public static AccountPlus getContaPorNome(final Context context,
                                              final AccountManager manager,
                                              final String accountType, final String name) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }

        final Account availableAccounts[] = manager.getAccountsByType(accountType);

        for (Account acc : availableAccounts) {
            final String accNome = acc.name;

            if (name.equalsIgnoreCase(accNome)) {
                try {
                    final String accPass = manager.getPassword(acc);

                    AccountPlus acp = new AccountPlus(acc.name, acc.type);
                    acp.setPassword(accPass);
                    return acp;
                } catch (Exception e) {
                    Log.e(Consts.TAG, e.getMessage(), e);
                }
            }
        }

        return null;
    }

    /**
     * Obtem uma conta unica de acordo com o tipo de conta
     *
     * @param manager
     * @param accountType
     * @return AccountPlus
     */
    public static AccountPlus getContaUnica(final Context context, final AccountManager manager,
                                            final String accountType) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }

        final Account availableAccounts[] = manager.getAccountsByType(accountType);
        for (Account acc : availableAccounts) {

            try {
                final String accPass = manager.getPassword(acc);

                AccountPlus acp = new AccountPlus(acc.name, acc.type);
                acp.setPassword(accPass);
                return acp;
            } catch (Exception e) {
                Log.e(Consts.TAG, e.getMessage(), e);
            }
        }

        return null;
    }

    /**
     * Remove todas as conta de acordo com o tipo de conta
     *
     * @param manager
     * @param accountType
     */
    public static void removerContas(final Context context, final AccountManager manager,
                                     final String accountType) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        Account[] accounts = manager.getAccounts();
        for (int index = 0; index < accounts.length; index++) {
			if (accounts[index].type.equalsIgnoreCase(accountType)) {
				manager.removeAccount(accounts[index], null, null);
			}
		}
	}

	/**
	 * Remove uma conta especifica de acordo com o tipo de conta e nome da conta
	 * principal
	 * 
	 * @param manager
	 * @param accountType
	 * @param accountName
	 */
	public static void removerConta(final Context context, final AccountManager manager,
			final String accountType, final String accountName) {

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

		Account[] accounts = manager.getAccounts();
		for (int index = 0; index < accounts.length; index++) {
			if (accounts[index].type.equalsIgnoreCase(accountType)) {
				if (accountName.equalsIgnoreCase(accounts[index].name)) {
					manager.removeAccount(accounts[index], null, null);
				}
			}
		}
	}

}
