package yogesh.firzen.mukkiasevaigal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Preferences
 */
public class P {

    private final static String defPrefName = "nammapreference";

    private static String prefName = defPrefName;
    /**
     * Default value of the String preference
     * Use this variable to check if the key doesn't have a value
     */
    public final static String vera = "gaali aana bottle uh";

    /**
     * Set a name to the preference
     *
     * @param s The name of the Preference
     */
    public static void setPreferenceName(String s) {
        prefName = s;
    }

    public static void setPreferenceNameToDefault() {
        prefName = defPrefName;
    }

    /**
     * Get the preferences
     *
     * @param context context
     * @return Shared Preferences
     */
    public static SharedPreferences getPreferences(@NonNull Context context) {
        return context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }

    /**
     * Get the preferences
     *
     * @param context  context
     * @param prefName The name of the preference
     * @return Shared Preferences
     */
    public static SharedPreferences getPreferences(@NonNull Context context, @NonNull String prefName) {
        return context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }

    /**
     * Get the Editor
     *
     * @param context context
     * @return Preference Editor
     */
    public static SharedPreferences.Editor getEditor(@NonNull Context context) {
        return getPreferences(context).edit();
    }

    /**
     * Get the Editor
     *
     * @param context  context
     * @param prefName The name of the preference
     * @return Preference Editor
     */
    public static SharedPreferences.Editor getEditor(@NonNull Context context, @NonNull String prefName) {
        return getPreferences(context, prefName).edit();
    }

    /**
     * Save your preference
     *
     * @param context context
     * @param key     key fot the preference
     * @param value   value of the preference
     */
    public static void save(@NonNull Context context, @NonNull String key, String value) {
        getEditor(context).putString(key, value).commit();
    }

    /**
     * Save your preference
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      key fot the preference
     * @param value    value of the preference
     */
    public static void save(@NonNull Context context, @NonNull String prefName, @NonNull String key, String value) {
        getEditor(context, prefName).putString(key, value).commit();
    }

    /**
     * Save your preference
     *
     * @param context context
     * @param key     key fot the preference
     * @param value   value of the preference
     */
    public static void save(@NonNull Context context, @NonNull String key, int value) {
        getEditor(context).putInt(key, value).commit();
    }

    /**
     * Save your preference
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      key fot the preference
     * @param value    value of the preference
     */
    public static void save(@NonNull Context context, @NonNull String prefName, @NonNull String key, int value) {
        getEditor(context, prefName).putInt(key, value).commit();
    }

    /**
     * Save your preference
     *
     * @param context context
     * @param key     key fot the preference
     * @param value   value of the preference
     */
    public static void save(@NonNull Context context, @NonNull String key, long value) {
        getEditor(context).putLong(key, value).commit();
    }

    /**
     * Save your preference
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      key fot the preference
     * @param value    value of the preference
     */
    public static void save(@NonNull Context context, @NonNull String prefName, @NonNull String key, long value) {
        getEditor(context, prefName).putLong(key, value).commit();
    }

    /**
     * Save your preference
     *
     * @param context context
     * @param key     key fot the preference
     * @param value   value of the preference
     */
    public static void save(@NonNull Context context, @NonNull String key, float value) {
        getEditor(context).putFloat(key, value).commit();
    }

    /**
     * Save your preference
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      key fot the preference
     * @param value    value of the preference
     */
    public static void save(@NonNull Context context, @NonNull String prefName, @NonNull String key, float value) {
        getEditor(context, prefName).putFloat(key, value).commit();
    }

    /**
     * Save your preference
     *
     * @param context context
     * @param key     key fot the preference
     * @param value   value of the preference
     */
    public static void save(@NonNull Context context, @NonNull String key, boolean value) {
        getEditor(context).putBoolean(key, value).commit();
    }

    /**
     * Save your preference
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      key fot the preference
     * @param value    value of the preference
     */
    public static void save(@NonNull Context context, @NonNull String prefName, @NonNull String key, boolean value) {
        getEditor(context, prefName).putBoolean(key, value).commit();
    }

    /**
     * Save all the values in the Map to preferences
     *
     * @param context context
     * @param data    data to be stored(object of Map)
     */
    public static void saveAll(@NonNull Context context, @NonNull Map<String, ?> data) {
        SharedPreferences.Editor editor = getEditor(context);
        LinkedList<String> keys = new LinkedList<>(data.keySet());
        LinkedList<?> values = new LinkedList<>(data.values());
        for (int i = 0; i < keys.size(); i++) {
            if (values.get(i) instanceof String)
                editor.putString(keys.get(i), String.valueOf(values.get(i)));
            if (values.get(i) instanceof Integer)
                editor.putInt(keys.get(i), (Integer) values.get(i));
            if (values.get(i) instanceof Long)
                editor.putLong(keys.get(i), (Long) values.get(i));
            if (values.get(i) instanceof Float)
                editor.putFloat(keys.get(i), (Float) values.get(i));
            if (values.get(i) instanceof Boolean)
                editor.putBoolean(keys.get(i), (Boolean) values.get(i));
            if (values.get(i) instanceof Set && Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB)
                editor.putStringSet(keys.get(i), (Set<String>) values.get(i));
        }
        editor.commit();
    }

    /**
     * Save all the values in the Map to preferences
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param data     data to be stored(object of Map)
     */
    public static void saveAll(@NonNull Context context, String prefName, @NonNull Map<String, ?> data) {
        SharedPreferences.Editor editor = getEditor(context, prefName);
        LinkedList<String> keys = new LinkedList<>(data.keySet());
        LinkedList<?> values = new LinkedList<>(data.values());
        for (int i = 0; i < keys.size(); i++) {
            if (values.get(i) instanceof String)
                editor.putString(keys.get(i), String.valueOf(values.get(i)));
            if (values.get(i) instanceof Integer)
                editor.putInt(keys.get(i), (Integer) values.get(i));
            if (values.get(i) instanceof Long)
                editor.putLong(keys.get(i), (Long) values.get(i));
            if (values.get(i) instanceof Float)
                editor.putFloat(keys.get(i), (Float) values.get(i));
            if (values.get(i) instanceof Boolean)
                editor.putBoolean(keys.get(i), (Boolean) values.get(i));
            if (values.get(i) instanceof Set && Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB)
                editor.putStringSet(keys.get(i), (Set<String>) values.get(i));
        }
        editor.commit();
    }

    /**
     * Get the saved Integer value
     *
     * @param context context
     * @param key     The key of the stored value
     * @return The stored value if key exists or 0
     */
    public static int getInt(@NonNull Context context, @NonNull String key) {
        return getPreferences(context).getInt(key, 0);
    }

    /**
     * Get the saved Integer value
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      The key of the stored value
     * @return The stored value if key exists or 0
     */
    public static int getInt(@NonNull Context context, @NonNull String prefName, @NonNull String key) {
        return getPreferences(context, prefName).getInt(key, 0);
    }

    /**
     * Get the saved Integer value
     *
     * @param context      context
     * @param key          The key of the stored value
     * @param defaultValue The value to be returned if the key is not found
     * @return The stored value if key exists or defaultValue specified
     */
    public static int getInt(@NonNull Context context, @NonNull String key, int defaultValue) {
        return getPreferences(context).getInt(key, defaultValue);
    }

    /**
     * Get the saved Integer value
     *
     * @param context      context
     * @param prefName     The name of the preference
     * @param key          The key of the stored value
     * @param defaultValue The value to be returned if the key is not found
     * @return The stored value if key exists or defaultValue specified
     */
    public static int getInt(@NonNull Context context, @NonNull String prefName, @NonNull String key, int defaultValue) {
        return getPreferences(context, prefName).getInt(key, defaultValue);
    }

    /**
     * Get the saved Long value
     *
     * @param context context
     * @param key     The key of the stored value
     * @return The stored value if key exists or 0
     */
    public static long getLong(@NonNull Context context, @NonNull String key) {
        return getPreferences(context).getLong(key, 0);
    }

    /**
     * Get the saved Long value
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      The key of the stored value
     * @return The stored value if key exists or 0
     */
    public static long getLong(@NonNull Context context, @NonNull String prefName, @NonNull String key) {
        return getPreferences(context, prefName).getLong(key, 0);
    }

    /**
     * Get the saved Long value
     *
     * @param context      context
     * @param key          The key of the stored value
     * @param defaultValue The value to be returned if the key is not found
     * @return The stored value if key exists or defaultValue specified
     */
    public static long getLong(@NonNull Context context, @NonNull String key, long defaultValue) {
        return getPreferences(context).getLong(key, defaultValue);
    }

    /**
     * Get the saved Long value
     *
     * @param context      context
     * @param prefName     The name of the preference
     * @param key          The key of the stored value
     * @param defaultValue The value to be returned if the key is not found
     * @return The stored value if key exists or defaultValue specified
     */
    public static long getLong(@NonNull Context context, @NonNull String prefName, @NonNull String key, long defaultValue) {
        return getPreferences(context, prefName).getLong(key, defaultValue);
    }

    /**
     * Get the saved Float value
     *
     * @param context context
     * @param key     The key of the stored value
     * @return The stored value if key exists or 0
     */
    public static float getFloat(@NonNull Context context, @NonNull String key) {
        return getPreferences(context).getFloat(key, 0);
    }

    /**
     * Get the saved Float value
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      The key of the stored value
     * @return The stored value if key exists or 0
     */
    public static float getFloat(@NonNull Context context, @NonNull String prefName, @NonNull String key) {
        return getPreferences(context, prefName).getFloat(key, 0);
    }

    /**
     * Get the saved Float value
     *
     * @param context      context
     * @param key          The key of the stored value
     * @param defaultValue The value to be returned if the key is not found
     * @return The stored value if key exists or defaultValue specified
     */
    public static float getFloat(@NonNull Context context, @NonNull String key, float defaultValue) {
        return getPreferences(context).getFloat(key, defaultValue);
    }

    /**
     * Get the saved Float value
     *
     * @param context      context
     * @param prefName     The name of the preference
     * @param key          The key of the stored value
     * @param defaultValue The value to be returned if the key is not found
     * @return The stored value if key exists or defaultValue specified
     */
    public static float getFloat(@NonNull Context context, @NonNull String prefName, @NonNull String key, float defaultValue) {
        return getPreferences(context, prefName).getFloat(key, defaultValue);
    }

    /**
     * Get the saved String value
     *
     * @param context context
     * @param key     The key of the stored value
     * @return The stored value if key exists or value of vera
     */
    public static String getString(@NonNull Context context, @NonNull String key) {
        return getPreferences(context).getString(key, vera);
    }

    /**
     * Get the saved String value
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      The key of the stored value
     * @return The stored value if key exists or value of vera
     */
    public static String getString(@NonNull Context context, @NonNull String prefName, @NonNull String key) {
        return getPreferences(context, prefName).getString(key, vera);
    }

/*
    *//**
     * Get the saved String value
     *
     * @param context context
     * @param key     The key of the stored value
     * @param defaultValue The value to be returned if the key is not found
     * @return The stored value if key exists or defaultValue specified
     *//*
    public static String getString(@NonNull Context context, @NonNull String key, Object defaultValue) {
        return getPreferences(context).getString(key, defaultValue.toString());
    }*/

    /**
     * Get the saved String value
     *
     * @param context      context
     * @param prefName     The name of the preference
     * @param key          The key of the stored value
     * @param defaultValue The value to be returned if the key is not found
     * @return The stored value if key exists or defaultValue specified
     */
    public static String getString(@NonNull Context context, @NonNull String prefName, @NonNull String key, String defaultValue) {
        return getPreferences(context, prefName).getString(key, defaultValue);
    }

    /**
     * Get the saved Boolean value
     *
     * @param context context
     * @param key     The key of the stored value
     * @return The stored value if key exists or false
     */
    public static boolean getBoolean(@NonNull Context context, @NonNull String key) {
        return getPreferences(context).getBoolean(key, false);
    }

    /**
     * Get the saved Boolean value
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      The key of the stored value
     * @return The stored value if key exists or false
     */
    public static boolean getBoolean(@NonNull Context context, @NonNull String prefName, @NonNull String key) {
        return getPreferences(context, prefName).getBoolean(key, false);
    }

    /**
     * Get the saved Boolean value
     *
     * @param context      context
     * @param key          The key of the stored value
     * @param defaultValue The value to be returned if the key is not found
     * @return The stored value if key exists or defaultValue specified
     */
    public static boolean getBoolean(@NonNull Context context, @NonNull String key, boolean defaultValue) {
        return getPreferences(context).getBoolean(key, defaultValue);
    }

    /**
     * Get the saved Boolean value
     *
     * @param context      context
     * @param prefName     The name of the preference
     * @param key          The key of the stored value
     * @param defaultValue The value to be returned if the key is not found
     * @return The stored value if key exists or defaultValue specified
     */
    public static boolean getBoolean(@NonNull Context context, @NonNull String prefName, @NonNull String key, boolean defaultValue) {
        return getPreferences(context, prefName).getBoolean(key, defaultValue);
    }

    /**
     * Get the saved String set values
     *
     * @param context context
     * @param key     The key of the stored value
     * @return The string set values if key exists else an empty set
     */
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    public static Set<String> getSet(@NonNull Context context, @NonNull String key) {
        return getPreferences(context).getStringSet(key, new LinkedHashSet<String>());
    }

    /**
     * Get the saved String set values
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      The key of the stored value
     * @return The string set values if key exists else an empty set
     */
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    public static Set<String> getSet(@NonNull Context context, @NonNull String prefName, @NonNull String key) {
        return getPreferences(context, prefName).getStringSet(key, new LinkedHashSet<String>());
    }


    /**
     * Gets all the preferences
     * NOTE: Do not change the values of the to have the saved content to be consistent
     *
     * @param context context
     * @return All the stored preferences as a Map
     */
    public static Map<String, ?> getAll(@NonNull Context context) {
        return getPreferences(context).getAll();
    }

    /**
     * Gets all the preferences
     * NOTE: Do not change the values of the to have the saved content to be consistent
     *
     * @param context  context
     * @param prefName The name of the preference
     * @return All the stored preferences as a Map
     */
    public static Map<String, ?> getAll(@NonNull Context context, @NonNull String prefName) {
        return getPreferences(context, prefName).getAll();
    }
}
