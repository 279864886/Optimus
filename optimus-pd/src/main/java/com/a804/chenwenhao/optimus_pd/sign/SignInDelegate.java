package com.a804.chenwenhao.optimus_pd.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;


import butterknife.*;
import delegates.OptimusDelegate;
import op.com.a804.chenwenhao.optimus.pd.R;
import op.com.a804.chenwenhao.optimus.pd.R2;

/**
 * Created by chenwenhao on 2017/9/5.
 */

public class SignInDelegate extends OptimusDelegate {

    @BindView(R2.id.tv_link_sign_in)
    TextView linkToSignIn;


    @OnClick(R2.id.tv_link_sign_in)
    void SignUp() {
        start(new SignUpDelegate());
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
