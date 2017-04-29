package develop.beta1139.mvvmtest.viewmodel;

import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import develop.beta1139.mvvmtest.model.MainModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tomo on 2017/04/29.
 */

public class MainViewModel {

    public ObservableField<String> name = new ObservableField<>("xxx");

    private MainModel mMainModel = new MainModel();

    public MainViewModel() {
    }

    public void onClickButton(View view) {
        mMainModel.fetchApi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        data -> {
                            Log.e("dbg", "onNext: " + data.results.get(0).email);
                            name.set(data.results.get(0).email);
                        },
                        throwable -> {
                            Log.e("dbg", "throwable: " + throwable);
                        });
    }
}
