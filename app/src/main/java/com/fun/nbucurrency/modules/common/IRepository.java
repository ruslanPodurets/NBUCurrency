package com.fun.nbucurrency.modules.common;

public interface IRepository {

    interface Callback<T> {
        void onResult(T result);
        void onError(String error);
    }
}
