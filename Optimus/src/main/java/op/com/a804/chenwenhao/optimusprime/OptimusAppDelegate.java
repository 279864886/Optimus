package op.com.a804.chenwenhao.optimusprime;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.a804.chenwenhao.optimus_pd.sign.SignInDelegate;
import com.a804.chenwenhao.optimus_pd.sign.SignUpDelegate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.joanzapata.android.iconify.views.IconTextView;

import android.support.v4.app.Fragment;

import net.RestClient;
import net.book;
import net.callback.IError;
import net.callback.IFailure;
import net.callback.ISuccess;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import ViewPageAdapter.MyFragmentAdapter;
import butterknife.BindView;
import delegates.OptimusDelegate;
import main_ui.title_home_delegate;
import navigation_view.Navigation_About_Delegate;
import navigation_view.Navigation_Content_Delegate;
import navigation_view.Navigation_Deedback_Delegate;
import navigation_view.Navigation_Download_Delegate;
import navigation_view.Navigation_HomePage_Delegate;

/**
 * Created by chenwenhao on 2017/8/31.
 */

public class OptimusAppDelegate extends OptimusDelegate implements View.OnClickListener {


    //http://www.runoob.com/w3cnote/android-ui-framework.html

    @BindView(R2.id.iv_title_menu)
    TextView itv;

    @BindView(R2.id.vp_content)
    ViewPager viewPager;

    NavigationView navigationView;
    DrawerLayout drawerLayout;

    private MyFragmentAdapter adapter;

    @Override
    public Object setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        //testRestClient();

        navigationView = (NavigationView) rootView.findViewById(R.id.nav_view);
        drawerLayout = (DrawerLayout) rootView.findViewById(R.id.drawer_layout);

        itv.setOnClickListener(this);




//        List<Fragment> fragments = new ArrayList<Fragment>();
//        fragments.add(new SignUpDelegate());
//        fragments.add(new SignInDelegate());
//
//        adapter = new MyFragmentAdapter(this.getActivity().getSupportFragmentManager(), fragments);
//        viewPager.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//        viewPager.setCurrentItem(0);
//
//        final TextView itv1 = (TextView) rootView.findViewById(R.id.iv_title_1);
//        final TextView itv2 = (TextView) rootView.findViewById(R.id.iv_title_2);
//        final TextView itv3 = (TextView) rootView.findViewById(R.id.iv_title_3);
//
//        itv1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                itv1.setTextSize(35);
//                itv2.setTextSize(20);
//                itv3.setTextSize(20);
//                viewPager.setCurrentItem(0);
//            }
//        });
//
//        itv2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                itv2.setTextSize(35);
//                itv1.setTextSize(20);
//                itv3.setTextSize(20);
//                viewPager.setCurrentItem(1);
//            }
//        });
//
//        itv3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                itv3.setTextSize(35);
//                itv2.setTextSize(20);
//                itv1.setTextSize(20);
//                //viewPager.setCurrentItem(1);
//            }
//        });

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

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.iv_title_menu:
                drawerLayout.openDrawer(GravityCompat.START);

                drawerLayout.findViewById(R.id.ll_nav_homepage).setOnClickListener(OptimusAppDelegate.this);
                drawerLayout.findViewById(R.id.ll_nav_scan_download).setOnClickListener(OptimusAppDelegate.this);
                drawerLayout.findViewById(R.id.ll_nav_deedback).setOnClickListener(OptimusAppDelegate.this);
                drawerLayout.findViewById(R.id.ll_nav_about).setOnClickListener(OptimusAppDelegate.this);
                drawerLayout.findViewById(R.id.ll_nav_login).setOnClickListener(OptimusAppDelegate.this);
                drawerLayout.findViewById(R.id.ll_nav_exit).setOnClickListener(OptimusAppDelegate.this);
                break;

            case R.id.ll_nav_homepage:
                start(new Navigation_Content_Delegate());
                break;
            case R.id.ll_nav_scan_download:
                start(new Navigation_Download_Delegate());
                break;
            case R.id.ll_nav_deedback:
                start(new Navigation_Deedback_Delegate());
                break;
            case R.id.ll_nav_about:
                start(new Navigation_About_Delegate());
                break;
            case R.id.ll_nav_login:
                start(new SignInDelegate());
                break;
            case R.id.ll_nav_exit:
                //Toast.makeText(getContext(), "exit", Toast.LENGTH_SHORT).show();
                //System.exit(0);
                start(new title_home_delegate());
                break;
            default:
                break;

        }


    }
}
