package develop.beta1139.mvvmtest.viewmodel;

import android.databinding.ObservableField;

/**
 * Created by tomo on 2017/04/29.
 */

public class MainViewModel {

    public ObservableField<String> name = new ObservableField<>("xxx");

    public MainViewModel() {
    }
}
