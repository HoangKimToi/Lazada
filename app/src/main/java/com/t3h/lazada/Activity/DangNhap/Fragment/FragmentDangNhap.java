package com.t3h.lazada.Activity.DangNhap.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.t3h.lazada.Activity.TrangChu.TrangChuActivity;
import com.t3h.lazada.Models.DangNhap.ModelsDangNhap;
import com.t3h.lazada.R;

import java.util.Arrays;

public class FragmentDangNhap extends Fragment implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {
    private Button btnLoginFacebook,btnLoginGoogle,btnDangNhap;
    private EditText editTenDN, editMatKhau;
    private CallbackManager callbackManager;
    private View view;
    private GoogleApiClient mGoogleApiClient;
    public static int SIGN_IN_GOOGLE = 123;
    private ModelsDangNhap modelsDangNhap;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dangnhap,container,false);
        modelsDangNhap = new ModelsDangNhap();
        mGoogleApiClient = modelsDangNhap.layGoogleApiClient(getContext(),this);

        FacebookSdk.sdkInitialize(getContext().getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent iTrangChu = new Intent(getActivity(), TrangChuActivity.class);
                startActivity(iTrangChu);
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException error) {
            }
        });
        iniView();
        return view;
    }

    private void iniView() {
        btnLoginFacebook = view.findViewById(R.id.btn_dangnhap_facebook);
        btnLoginGoogle = view.findViewById(R.id.btn_dangnhap_google);
        btnDangNhap = view.findViewById(R.id.btn_dangnhap);
        editTenDN = view.findViewById(R.id.edit_emai_dangnhap);
        editMatKhau = view.findViewById(R.id.edit_pass_dangnhap);
        btnDangNhap.setOnClickListener(this);
        btnLoginFacebook.setOnClickListener(this);
        btnLoginGoogle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_dangnhap_facebook:
                LoginManager.getInstance().logInWithReadPermissions(FragmentDangNhap.this, Arrays.asList("public_profile"));
                break;
            case R.id.btn_dangnhap_google:
                Intent iGooglePlus = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(iGooglePlus,SIGN_IN_GOOGLE);
                break;
            case R.id.btn_dangnhap:
                String tendn = editTenDN.getText().toString();
                String matkhau = editMatKhau.getText().toString();
                boolean kiemtra = modelsDangNhap.KiemTraDangNhap(getActivity(),tendn,matkhau);
                if (kiemtra){
                    Intent iTrangChu = new Intent(getActivity(), TrangChuActivity.class);
                    startActivity(iTrangChu);
                }else {
                    Toast.makeText(getActivity(),"Email hoặc mật khẩu không đúng",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
        if (requestCode == SIGN_IN_GOOGLE){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()){
                Intent iTrangChu = new Intent(getActivity(), TrangChuActivity.class);
                startActivity(iTrangChu);
            }
        }
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }
}
