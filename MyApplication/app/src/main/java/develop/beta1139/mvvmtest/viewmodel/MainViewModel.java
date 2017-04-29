package develop.beta1139.mvvmtest.viewmodel;

import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import develop.beta1139.mvvmtest.api.EmailApi;
import develop.beta1139.mvvmtest.eventbus.Publisher;
import develop.beta1139.mvvmtest.model.MainModel;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.internal.subscriptions.ArrayCompositeSubscription;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tomo on 2017/04/29.
 */

public class MainViewModel {

    public ObservableField<String> name = new ObservableField<>("xxx");
    public ObservableField<String> imageUrl = new ObservableField<>("");

    private CompositeDisposable disposables = new CompositeDisposable();

    private MainModel mMainModel = new MainModel();

    public MainViewModel() {
    }

    public void onClickEmailButton(View view) {
        Single<EmailApi.ApiData> observable = mMainModel.mEmailApi.apiData();
        disposables.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        data -> {
                            Log.e("dbg", "onNext: " + data.results.get(0).email);
                            name.set(data.results.get(0).email);
                        },
                        throwable -> {
                            Log.e("dbg", "throwable: " + throwable);
                        }));
    }

    public void onPause() {
        disposables.dispose();
    }

    public void onClickImageButton(View view) {
        imageUrl.set("https://source.unsplash.com/random");
    }

    public void onClickEventbus(View view) {
        new Publisher().post("close");
    }
}
