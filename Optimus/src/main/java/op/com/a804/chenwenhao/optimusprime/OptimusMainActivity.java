package op.com.a804.chenwenhao.optimusprime;

import activities.ProxyActivity;
import delegates.OptimusDelegate;

public class OptimusMainActivity extends ProxyActivity {
    @Override
    public OptimusDelegate setRootDelegate() {
//        return new OptimusAppDelegate();
        return new OptimusAppDelegate();

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Toast.makeText(Optimus.getApplication(),"传入Context",Toast.LENGTH_LONG).show();
//    }



}