package main_ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import delegates.OptimusDelegate;
import op.com.a804.chenwenhao.optimus.pd.R;

/**
 * Created by chenwenhao on 2017/9/28.
 */

public class data_delegate extends OptimusDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_data;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
