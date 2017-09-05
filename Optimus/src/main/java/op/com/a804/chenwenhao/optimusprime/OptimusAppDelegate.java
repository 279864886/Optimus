package op.com.a804.chenwenhao.optimusprime;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.a804.chenwenhao.optimus_pd.sign.SignUpDelegate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.joanzapata.android.iconify.views.IconTextView;

import net.RestClient;
import net.book;
import net.callback.IError;
import net.callback.IFailure;
import net.callback.ISuccess;

import java.io.StringReader;

import butterknife.BindView;
import delegates.OptimusDelegate;

/**
 * Created by chenwenhao on 2017/8/31.
 */

public class OptimusAppDelegate extends OptimusDelegate {
    @Override
    public Object setLayout() {
        return R.layout.activity_main;
    }

    @BindView(R2.id.iv_title_menu)
    TextView itv;

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        //testRestClient();

        final NavigationView navigationView = (NavigationView) rootView.findViewById(R.id.nav_view);
        final DrawerLayout drawerLayout = (DrawerLayout) rootView.findViewById(R.id.drawer_layout);





        itv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);

                Button b= (Button) navigationView.findViewById(R.id.button);

                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        Toast.makeText(getContext(),"Hello", Toast.LENGTH_LONG).show();

                        start(new SignUpDelegate());

                    }
                });


//                ButterKnife.findById()

                //click();
            }
        });
    }

    private void testRestClient() {
        RestClient.builder()
                .url("book/{id}")
                //.params("id","1003078")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(Object response) {

                        Gson gson = new GsonBuilder()
                                .setPrettyPrinting()
                                .serializeNulls()
                                .generateNonExecutableJson()
                                .setLenient()
                                .create();
                        StringReader sr = new StringReader(response.toString());
                        JsonReader jr = new JsonReader(sr);

                        jr.setLenient(false);

                        book b = gson.fromJson(jr, book.class);

                        Toast.makeText(getContext(), b.getId() + "-" + b.getTitle(), Toast.LENGTH_LONG).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
                .get();
    }
}
