/*
 *
 *  Proprietary and confidential. Property of Kellton Tech Solutions Ltd. Do not disclose or distribute.
 *  You must have written permission from Kellton Tech Solutions Ltd. to use this code.
 *
 */

package com.kelltontech.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.kelltontech.ui.IScreen;
import com.kelltontech.ui.activity.BaseActivity;

/**
 * @author sachn.guta
 */
public abstract class BaseFragment extends Fragment implements IScreen {

    /**
     * @return
     */
    protected BaseActivity getBaseActivity() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof BaseActivity) || activity.isFinishing()) {
            return null;
        }
        return (BaseActivity) activity;
    }

//	/**
//	 * @param serviceResponse
//	 */
//	@Override
//	public void handleUiUpdate(final boolean status,final int action, final Object serviceResponse){
//		final BaseActivity baseActivity = getBaseActivity();
//		if (baseActivity == null) {
//			return;
//		}
//		baseActivity.runOnUiThread(new Runnable() {
//			@Override
//			public void run() {
//				baseActivity.updateUi(status,action,serviceResponse);
//			}
//		});
//	}
}
