package op.com.a804.chenwenhao.optimusprime;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import net.RestClient;
import net.book;
import net.callback.IError;
import net.callback.IFailure;
import net.callback.ISuccess;

import java.io.StringReader;

import delegates.OptimusDelegate;

/**
 * Created by chenwenhao on 2017/8/31.
 */

public class OptimusAppDelegate extends OptimusDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_optimusapp;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        testRestClient();
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
                                .disableHtmlEscaping()
                                .setLenient()
                                .create();
                        StringReader sr=new StringReader(response.toString());
                        JsonReader jr=new JsonReader(sr);

                        jr.setLenient(false);

                        book b = gson.fromJson(jr,book.class);

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
