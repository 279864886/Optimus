package navigation_view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import delegates.OptimusDelegate;
import op.com.a804.chenwenhao.optimus.pd.R;

/**
 * Created by chenwenhao on 2017/9/7.
 */

public class Navigation_Content_Delegate extends OptimusDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_content_scrolling;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
