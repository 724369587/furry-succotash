package MyTools;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Juphoon on 2018/3/16.
 */

public class Tools {
        private static Toast mToast;
        public static void showToast(Context context, int resId, int duration){
            showToast(context, context.getString(resId), duration);
        }
        public static void showToast(Context context, String msg, int duration) {
            if (mToast == null) {
                mToast = Toast.makeText(context, msg, duration);
            } else {
                mToast.setText(msg);
            }
            mToast.show();
        }
}
