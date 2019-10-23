package com.t3h.lazada.Models.DangNhap;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.t3h.lazada.Activity.TrangChu.TrangChuActivity;
import com.t3h.lazada.Connect.DowdloadJSON;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ModelsDangNhap {
    private AccessToken accessToken;
    private AccessTokenTracker accessTokenTracker;
    public AccessToken LayTokenFacebookHienTai(){
        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                accessToken = currentAccessToken;
            }
        };
        accessToken = AccessToken.getCurrentAccessToken();
        return accessToken;
    }
    public boolean KiemTraDangNhap(Context context,String tenDangNhap,String matkhau){
        Boolean kiemtra = false;
        String duongdan = TrangChuActivity.SERVER_NAME;
        List<HashMap<String,String>> attrs = new ArrayList<>();

        HashMap<String,String> hsHam = new HashMap<>();
        hsHam.put("ham","KiemTraDangNhap");

        HashMap<String,String> hsTenDN = new HashMap<>();
        hsTenDN.put("tendn",tenDangNhap);

        HashMap<String,String> hsMatKhau = new HashMap<>();
        hsMatKhau.put("matkhau",matkhau);

        attrs.add(hsHam);
        attrs.add(hsTenDN);
        attrs.add(hsMatKhau);

        DowdloadJSON dowdloadJSON = new DowdloadJSON(duongdan,attrs);
        dowdloadJSON.execute();
        try {
            String dulieu = dowdloadJSON.get();
            JSONObject jsonObject = new JSONObject(dulieu);
            String JSONKetQua = jsonObject.getString("ketqua");
            if (JSONKetQua.equals("true")){
                kiemtra = true;
                String tennv = jsonObject.getString("tennv");

                CapNhatCached(context,tennv);
            }else {
                kiemtra = false;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return kiemtra;
    }
    public String LayCachedDangNhap(Context context){
        SharedPreferences cachedDangNhap = context.getSharedPreferences("dangnhap",Context.MODE_PRIVATE);
        String tennv = cachedDangNhap.getString("tennv","");
        return tennv;
    }
    public void CapNhatCached(Context context,String tennv){
        SharedPreferences cachedDangNhap = context.getSharedPreferences("dangnhap",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = cachedDangNhap.edit();
        editor.putString("tennv",tennv);
        editor.commit();
    }
    public void HuyToken(){
        accessTokenTracker.stopTracking();
    }

    public GoogleApiClient layGoogleApiClient(Context context, GoogleApiClient.OnConnectionFailedListener listener){
        GoogleApiClient mGoogleApiClient;
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .enableAutoManage(((AppCompatActivity)context),listener)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();
//        mGoogleApiClient = GoogleSignIn.getClient(context,gso);
        return mGoogleApiClient;
    }
    public GoogleSignInResult layThongTinLoginGG(GoogleApiClient googleApiClient){
        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if (opr.isDone()){
            return opr.get();
        }else {
            return null;
        }
    }
}
