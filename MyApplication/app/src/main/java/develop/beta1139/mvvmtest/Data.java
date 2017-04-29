package develop.beta1139.mvvmtest;

import android.databinding.ObservableField;

/**
 * Created by tomo on 2017/04/29.
 */

public class Data {
    public ObservableField<String> name = new ObservableField<>();

    public Data(String nameString) {
        name.set(nameString);
    }
}
