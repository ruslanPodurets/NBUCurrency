package com.fun.nbucurrency.modules.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import com.fun.nbucurrency.BR;

import java.util.HashSet;
import java.util.Set;

public abstract class BaseViewModel<Model> extends ViewModel implements IViewModel {

    @Nullable
    private Model model;
    private Set<OnPropertyChangedCallback> changedCallbacks = new HashSet<>();

    @NonNull
    protected abstract Model initModel();

    public BaseViewModel() {
        this.model = initModel();
    }

    @Override
    public void onBind() {

    }

    @Override
    public void onUnBind() {
        changedCallbacks.clear();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Nullable
    protected Model getModel() {
        return model;
    }

    protected void notifyObservable() {
        for (OnPropertyChangedCallback changedCallback : changedCallbacks) {
            changedCallback.onPropertyChanged(this, BR._all);
        }
    }

    @Override
    protected final void onCleared() {
        super.onCleared();
        changedCallbacks.clear();
        model = null;
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        changedCallbacks.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        changedCallbacks.remove(callback);
    }
}
