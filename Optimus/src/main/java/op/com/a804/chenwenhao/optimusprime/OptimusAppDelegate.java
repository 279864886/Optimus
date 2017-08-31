package op.com.a804.chenwenhao.optimusprime;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import delegates.OptimusDelegate;

/**
 * Created by chenwenhao on 2017/8/31.
 */

public class OptimusAppDelegate extends OptimusDelegate{
    @Override
    public Object setLayout() {
        return R.layout.delegate_optimusapp;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
