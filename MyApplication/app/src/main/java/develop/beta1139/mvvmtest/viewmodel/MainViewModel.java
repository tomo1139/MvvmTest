package develop.beta1139.mvvmtest.viewmodel;

import android.databinding.ObservableField;
import android.view.View;

/**
 * Created by tomo on 2017/04/29.
 */

public class MainViewModel {

    public ObservableField<String> name = new ObservableField<>("xxx");

    public MainViewModel() {
    }

    public void onClickButton(View view) {
        name.set("yyy");
    }
}
