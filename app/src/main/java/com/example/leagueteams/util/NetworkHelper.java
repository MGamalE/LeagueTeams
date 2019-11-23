package com.example.leagueteams.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class NetworkHelper {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager conxMgr = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);

        NetworkInfo mobileNwInfo = conxMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifiNwInfo = conxMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        return ((mobileNwInfo != null && mobileNwInfo.isConnected()) || (wifiNwInfo != null && wifiNwInfo.isConnected()));

    }
}
