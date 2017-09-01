package net.callback;

/**
 * Created by chenwenhao on 2017/8/31.
 */

public interface ISuccess<T> {

    void onSuccess(T response);
}
