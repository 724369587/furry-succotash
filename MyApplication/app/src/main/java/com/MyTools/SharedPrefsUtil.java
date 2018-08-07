package MyTools;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

/**
 * Created by Juphoon on 2018/3/15.
 */

public class SharedPrefsUtil {
    public final static String SETTING = "Setting";
    private static final String DATABSE = "Database";
    public static void putString(Context context, EditText etidtext, String string) {
        SharedPreferences sp = context.getSharedPreferences(DATABSE,0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(etidtext.getText().toString(), string);
        editor.commit();
    }
    public static String getString(Context context,EditText etidtext) {
        SharedPreferences sp =  context.getSharedPreferences(DATABSE, 0);
        return sp.getString(etidtext.getText().toString(),"0");

    }

    public static void putString(Context context,String keyString, String defString) {
        SharedPreferences sp = context.getSharedPreferences(DATABSE,0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(keyString, defString);
        editor.commit();
    }
    public static String getString(Context context,String keyString) {
        SharedPreferences sp =  context.getSharedPreferences(DATABSE, 0);
        return sp.getString(keyString,"0");

    }
}
