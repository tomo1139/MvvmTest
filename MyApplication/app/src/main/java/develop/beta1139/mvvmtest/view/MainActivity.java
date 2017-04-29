package develop.beta1139.mvvmtest.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import develop.beta1139.mvvmtest.R;
import develop.beta1139.mvvmtest.databinding.ActivityMainBinding;
import develop.beta1139.mvvmtest.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel = new MainViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainViewModel(mainViewModel);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mainViewModel.onPause();
    }
}
