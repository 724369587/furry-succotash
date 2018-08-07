package MyTools;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Juphoon on 2018/3/15.
 */

public class SharedPrefsUtil {
    public final static String SETTING = "Setting";
    public static void putString(Context context, String dababase, EditText etidtext, String string) {
        SharedPreferences sp = context.getSharedPreferences(dababase,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(etidtext.getText().toString(), string);
        editor.commit();
    }
    public static String getString(Context context,String dababase, EditText etidtext) {
        SharedPreferences sp =  context.getSharedPreferences(dababase, Context.MODE_PRIVATE);
        return sp.getString(etidtext.getText().toString(),"0");

    }

    public static void putString(Context context,String dababase, String keyString, String defString) {
        SharedPreferences sp = context.getSharedPreferences(dababase,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(keyString, defString);
        editor.commit();
    }
    public static String getString(Context context,String dababase, String keyString) {
        SharedPreferences sp =  context.getSharedPreferences(dababase, Context.MODE_PRIVATE);
        return sp.getString(keyString,"0");

    }

    public static void removeString(Context context,String dababase) {
        SharedPreferences sp = context.getSharedPreferences(dababase,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear().commit();
    }
    public static String[] getDatabase(Context context) {
        String[] sp = context.databaseList();
            return sp;
    }

}
