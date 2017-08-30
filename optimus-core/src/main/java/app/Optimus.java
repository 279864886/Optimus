package app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by chenwenhao on 2017/7/25.
 */

public final class Optimus {

    public static Configurator init(Context context){

        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator(){
        return Configurator.getInstance();
    }



    private static HashMap<String,Object> getConfigurations(){
        return Configurator.getInstance().getOptimusConfigs();
    }

    public static Context getApplication(){
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }

    public static String getApplicationUrl(){
        return (String) getConfigurations().get(ConfigType.API_HOST.name());
    }


}
