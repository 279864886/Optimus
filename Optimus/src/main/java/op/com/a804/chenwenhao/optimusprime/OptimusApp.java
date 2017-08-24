package op.com.a804.chenwenhao.optimusprime;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;

import app.Optimus;

/**
 * Created by chenwenhao on 2017/7/25.
 */

public class OptimusApp extends Application {
    @Override
    public void onCreate(){
        super.onCreate();

        Optimus.init(this)
                .withIcon(new FontAwesomeModule())
                .withApiHost("http://127.0.0.1")
                .configure();
    }
}
