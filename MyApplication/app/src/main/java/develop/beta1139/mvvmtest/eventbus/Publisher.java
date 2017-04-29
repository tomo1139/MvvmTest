package develop.beta1139.mvvmtest.eventbus;

import android.os.Handler;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by tomo on 2017/04/29.
 */

public class Publisher {
    public Publisher() {

    }

    public void post(final String msg) {
        new Handler().post(() -> {
            EventBus.getDefault().post(new MessageEvent(msg));
        });
    }

    public static class MessageEvent {
        public String msg;

        public MessageEvent(String msg) {
            this.msg = msg;
        }
    }
}
