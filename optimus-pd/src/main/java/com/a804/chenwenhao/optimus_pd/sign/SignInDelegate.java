package com.a804.chenwenhao.optimus_pd.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import delegates.OptimusDelegate;
import op.com.a804.chenwenhao.optimus.pd.R;
import op.com.a804.chenwenhao.optimus.pd.R2;

/**
 * Created by chenwenhao on 2017/9/5.
 */

public class SignInDelegate extends OptimusDelegate {




    @OnClick(R2.id.tv_link_sign_up)
    void SignUp(){
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
