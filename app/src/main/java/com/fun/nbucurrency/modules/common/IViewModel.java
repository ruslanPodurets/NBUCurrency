package com.fun.nbucurrency.modules.common;

import androidx.databinding.Observable;

public interface IViewModel extends Observable {
    void onStart();

    void onBind();

    void onUnBind();

    void onStop();

    void onDestroy();

}
