package com.fun.nbucurrency.modules.main;

import androidx.annotation.NonNull;
import com.fun.nbucurrency.modules.common.BaseViewModel;

public class MainViewModel extends BaseViewModel<MainModel> implements IMainViewModel, MainModel.RefreshCallback {

    @Override
    public void onClickLoad() {
        loadData();
    }

    @Override
    public String getData() {
        MainModel mainModel = getModel();
        if (mainModel != null) {
            return mainModel.getData();
        }
        return "";
    }

    @NonNull
    @Override
    protected MainModel initModel() {
        return new MainModel(this);
    }

    @Override
    public void onBind() {
        super.onBind();
        loadData();
    }

    private void loadData() {
        MainModel mainModel = getModel();
        if (mainModel != null) {
            mainModel.loadCurrencyByDate();
        }
    }

    @Override
    public void onReadyToRefresh() {
        notifyObservable();
    }
}
