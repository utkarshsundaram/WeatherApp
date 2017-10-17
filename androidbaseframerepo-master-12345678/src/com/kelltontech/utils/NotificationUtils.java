
/*
 *
 *  Proprietary and confidential. Property of Kellton Tech Solutions Ltd. Do not disclose or distribute.
 *  You must have written permission from Kellton Tech Solutions Ltd. to use this code.
 * /
 */

package com.kelltontech.utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.kelltontech.R;


/**
 * @author sachin.gupta
 */
public class NotificationUtils {

    /**
     * Shows notification with System.currentTimeMillis() tag and 0 id
     *
     * @param pContext
     * @param pTitle
     * @param pMessage
     * @param pActivityIntent
     * @param pAutoCancel
     */
    public static void showNotification(Context pContext, String pTitle, String pMessage, Intent pActivityIntent, boolean pAutoCancel) {
        showNotification(pContext, pTitle, pMessage, pActivityIntent, "" + System.currentTimeMillis(), 0, pAutoCancel);

    }

    /**
     * Shows notification with autoCancel = true
     *
     * @param pContext
     * @param pMessage
     * @param pActivityIntent
     * @param pTag
     * @param pId
     */
    public static void showNotification(Context pContext, String pMessage, Intent pActivityIntent, String pTag, int pId) {
        showNotification(pContext, null, pMessage, pActivityIntent, pTag, pId, true);
    }

    /**
     * Shows notification
     *
     * @param pContext
     * @param pMessage
     * @param pActivityIntent
     * @param pTag
     * @param pId
     * @param pAutoCancel
     */
    public static void showNotification(Context pContext, String pTitle, String pMessage, Intent pActivityIntent, String pTag, int pId, boolean pAutoCancel) {
        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(pContext);
        notifBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(pMessage));
        notifBuilder.setContentText(pMessage);
        notifBuilder.setSmallIcon(R.drawable.ic_launcher);
        if (pTitle == null) {
            notifBuilder.setContentTitle(pContext.getString(R.string.app_name));
        } else {
            notifBuilder.setContentTitle(pTitle);
        }
        notifBuilder.setAutoCancel(pAutoCancel);

        PendingIntent notifClickIntent = PendingIntent.getActivity(pContext, 0, pActivityIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        notifBuilder.setContentIntent(notifClickIntent);

        NotificationManager notificationManager = (NotificationManager) pContext.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(pTag, pId, notifBuilder.build());
    }
}
