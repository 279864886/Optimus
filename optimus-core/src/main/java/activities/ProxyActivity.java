package activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import delegates.OptimusDelegate;
import me.yokeyword.fragmentation.SupportActivity;
import op.com.a804.chenwenhao.optimus.R;

/**
 * Created by chenwenhao on 2017/8/31.
 */

public abstract class ProxyActivity extends SupportActivity {

    public abstract OptimusDelegate setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState){
        final ContentFrameLayout container=new ContentFrameLayout(this);

        container.setId(R.id.delegate_container);

        setContentView(container);

        if(savedInstanceState==null){
            loadRootFragment(R.id.delegate_container,setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
