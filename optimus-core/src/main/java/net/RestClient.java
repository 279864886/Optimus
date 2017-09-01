package net;

import net.callback.IError;
import net.callback.IFailure;
import net.callback.IRequest;
import net.callback.ISuccess;
import net.callback.RequestCallbacks;

import java.lang.ref.PhantomReference;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.PUT;

/**
 * Created by chenwenhao on 2017/8/30.
 */

public class RestClient {

    private final String URL;
    private static final WeakHashMap<String, Object> PARMAS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;

    public RestClient(String url,
                      Map<String, Object> params,
                      IRequest iRequest,
                      ISuccess iSuccess,
                      IFailure iFailure,
                      IError iError,
                      RequestBody requestBody) {
        this.URL = url;
        PARMAS.putAll(params);
        this.REQUEST = iRequest;
        this.SUCCESS = iSuccess;
        this.FAILURE = iFailure;
        this.ERROR = iError;
        this.BODY = requestBody;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }


    private void request(HttpMethod method) {
        final RestService service = RestCreator.getRestService();
        Call<Object> call = null;

        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }

        switch (method) {
            case GET:
                //call=service.get(URL, PARMAS);
                call=service.get("17604305","id,title,url");
                break;
//            case POST:
//                call = service.post(URL, PARMAS);
//                break;
//            case PUT:
//                call = service.put(URL, PARMAS);
//                break;
//            case DELETE:
//                call = service.delete(URL, PARMAS);
//                break;
            default:
                break;
        }

        if (call != null) {
            call.enqueue(getRequestCallback());
        }
    }

    private Callback<Object> getRequestCallback() {
        return new RequestCallbacks(REQUEST, SUCCESS, FAILURE, ERROR);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        request(HttpMethod.POST);
    }

    public final void put() {
        request(HttpMethod.PUT);
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }
}
