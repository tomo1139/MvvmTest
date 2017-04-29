package develop.beta1139.mvvmtest.viewmodel;

import android.databinding.ObservableField;
import android.view.View;

import develop.beta1139.mvvmtest.model.MainModel;

/**
 * Created by tomo on 2017/04/29.
 */

public class MainViewModel {

    public ObservableField<String> name = new ObservableField<>("xxx");

    private MainModel mMainModel = new MainModel();

    public MainViewModel() {
    }

    public void onClickButton(View view) {
        mMainModel.fetchApi();
    }
}
