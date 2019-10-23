package com.t3h.lazada.Untils;

import android.app.ProgressDialog;
import android.content.Context;

public class DialogUntil {
    private static ProgressDialog dialog;

    public static void ShowDialog(Context context){
        dissmissProgress();
        dialog = new ProgressDialog(context);
        dialog.setTitle("Loading...");
        dialog.show();
    }
    public static void dissmissProgress(){
        if (dialog!=null && dialog.isShowing()){
            dialog.dismiss();
        }
    }
}
