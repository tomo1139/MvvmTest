package develop.beta1139.mvvmtest.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import develop.beta1139.mvvmtest.R;
import develop.beta1139.mvvmtest.databinding.ActivityMainBinding;
import develop.beta1139.mvvmtest.eventbus.Publisher;
import develop.beta1139.mvvmtest.viewmodel.MainViewModel;
import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel = new MainViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainViewModel(mainViewModel);

        EventBus.getDefault().register(this);

        Observable<String> observable = Observable.just("aaa", "bbb");
        List<String> list = observable.toList().blockingGet();
        for (String str : list) {
            Log.e("dbg", "str: " + str);
        }
    }

    @Subscribe
    public void onEvent(Publisher.MessageEvent event) {
        if (event.msg.equals("close")) {
            finish();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mainViewModel.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }
}
