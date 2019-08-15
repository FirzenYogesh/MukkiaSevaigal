package yogesh.firzen.mukkiasevaigal

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi

import java.util.LinkedHashSet
import java.util.LinkedList

/**
 * Preferences
 */
object P {

    private val defPrefName = "nammapreference"

    private var prefName = defPrefName
    /**
     * Default value of the String preference
     * Use this variable to check if the key doesn't have a value
     */
    val vera = "gaali aana bottle uh"

    /**
     * Set a name to the preference
     *
     * @param s The name of the Preference
     */
    fun setPreferenceName(s: String) {
        prefName = s
    }

    fun setPreferenceNameToDefault() {
        prefName = defPrefName
    }

    /**
     * Get the preferences
     *
     * @param context context
     * @return Shared Preferences
     */
    fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }

    /**
     * Get the preferences
     *
     * @param context  context
     * @param prefName The name of the preference
     * @return Shared Preferences
     */
    fun getPreferences(context: Context, prefName: String): SharedPreferences {
        return context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }

    /**
     * Get the Editor
     *
     * @param context context
     * @return Preference Editor
     */
    fun getEditor(context: Context): SharedPreferences.Editor {
        return getPreferences(context).edit()
    }

    /**
     * Get the Editor
     *
     * @param context  context
     * @param prefName The name of the preference
     * @return Preference Editor
     */
    fun getEditor(context: Context, prefName: String): SharedPreferences.Editor {
        return getPreferences(context, prefName).edit()
    }

    /**
     * Save your preference
     *
     * @param context context
     * @param key     key fot the preference
     * @param value   value of the preference
     */
    fun save(context: Context, key: String, value: String) {
        getEditor(context).putString(key, value).commit()
    }

    /**
     * Save your preference
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      key fot the preference
     * @param value    value of the preference
     */
    fun save(context: Context, prefName: String, key: String, value: String) {
        getEditor(context, prefName).putString(key, value).commit()
    }

    /**
     * Save your preference
     *
     * @param context context
     * @param key     key fot the preference
     * @param value   value of the preference
     */
    fun save(context: Context, key: String, value: Int) {
        getEditor(context).putInt(key, value).commit()
    }

    /**
     * Save your preference
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      key fot the preference
     * @param value    value of the preference
     */
    fun save(context: Context, prefName: String, key: String, value: Int) {
        getEditor(context, prefName).putInt(key, value).commit()
    }

    /**
     * Save your preference
     *
     * @param context context
     * @param key     key fot the preference
     * @param value   value of the preference
     */
    fun save(context: Context, key: String, value: Long) {
        getEditor(context).putLong(key, value).commit()
    }

    /**
     * Save your preference
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      key fot the preference
     * @param value    value of the preference
     */
    fun save(context: Context, prefName: String, key: String, value: Long) {
        getEditor(context, prefName).putLong(key, value).commit()
    }

    /**
     * Save your preference
     *
     * @param context context
     * @param key     key fot the preference
     * @param value   value of the preference
     */
    fun save(context: Context, key: String, value: Float) {
        getEditor(context).putFloat(key, value).commit()
    }

    /**
     * Save your preference
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      key fot the preference
     * @param value    value of the preference
     */
    fun save(context: Context, prefName: String, key: String, value: Float) {
        getEditor(context, prefName).putFloat(key, value).commit()
    }

    /**
     * Save your preference
     *
     * @param context context
     * @param key     key fot the preference
     * @param value   value of the preference
     */
    fun save(context: Context, key: String, value: Boolean) {
        getEditor(context).putBoolean(key, value).commit()
    }

    /**
     * Save your preference
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      key fot the preference
     * @param value    value of the preference
     */
    fun save(context: Context, prefName: String, key: String, value: Boolean) {
        getEditor(context, prefName).putBoolean(key, value).commit()
    }

    /**
     * Save all the values in the Map to preferences
     *
     * @param context context
     * @param data    data to be stored(object of Map)
     */
    fun saveAll(context: Context, data: Map<String, *>) {
        val editor = getEditor(context)
        val keys = LinkedList(data.keys)
        val values = LinkedList(data.values)
        for (i in keys.indices) {
            if (values[i] is String)
                editor.putString(keys[i], values[i].toString())
            if (values[i] is Int)
                editor.putInt(keys[i], values[i] as Int)
            if (values[i] is Long)
                editor.putLong(keys[i], values[i] as Long)
            if (values[i] is Float)
                editor.putFloat(keys[i], values[i] as Float)
            if (values[i] is Boolean)
                editor.putBoolean(keys[i], values[i] as Boolean)
            if (values[i] is Set<*> && Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB)
                editor.putStringSet(keys[i], values[i] as Set<String>)
        }
        editor.commit()
    }

    /**
     * Save all the values in the Map to preferences
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param data     data to be stored(object of Map)
     */
    fun saveAll(context: Context, prefName: String, data: Map<String, *>) {
        val editor = getEditor(context, prefName)
        val keys = LinkedList(data.keys)
        val values = LinkedList(data.values)
        for (i in keys.indices) {
            if (values[i] is String)
                editor.putString(keys[i], values[i].toString())
            if (values[i] is Int)
                editor.putInt(keys[i], values[i] as Int)
            if (values[i] is Long)
                editor.putLong(keys[i], values[i] as Long)
            if (values[i] is Float)
                editor.putFloat(keys[i], values[i] as Float)
            if (values[i] is Boolean)
                editor.putBoolean(keys[i], values[i] as Boolean)
            if (values[i] is Set<*> && Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB)
                editor.putStringSet(keys[i], values[i] as Set<String>)
        }
        editor.commit()
    }

    /**
     * Get the saved Integer value
     *
     * @param context context
     * @param key     The key of the stored value
     * @return The stored value if key exists or 0
     */
    fun getInt(context: Context, key: String): Int {
        return getPreferences(context).getInt(key, 0)
    }

    /**
     * Get the saved Integer value
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      The key of the stored value
     * @return The stored value if key exists or 0
     */
    fun getInt(context: Context, prefName: String, key: String): Int {
        return getPreferences(context, prefName).getInt(key, 0)
    }

    /**
     * Get the saved Integer value
     *
     * @param context      context
     * @param key          The key of the stored value
     * @param defaultValue The value to be returned if the key is not found
     * @return The stored value if key exists or defaultValue specified
     */
    fun getInt(context: Context, key: String, defaultValue: Int): Int {
        return getPreferences(context).getInt(key, defaultValue)
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
    fun getInt(context: Context, prefName: String, key: String, defaultValue: Int): Int {
        return getPreferences(context, prefName).getInt(key, defaultValue)
    }

    /**
     * Get the saved Long value
     *
     * @param context context
     * @param key     The key of the stored value
     * @return The stored value if key exists or 0
     */
    fun getLong(context: Context, key: String): Long {
        return getPreferences(context).getLong(key, 0)
    }

    /**
     * Get the saved Long value
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      The key of the stored value
     * @return The stored value if key exists or 0
     */
    fun getLong(context: Context, prefName: String, key: String): Long {
        return getPreferences(context, prefName).getLong(key, 0)
    }

    /**
     * Get the saved Long value
     *
     * @param context      context
     * @param key          The key of the stored value
     * @param defaultValue The value to be returned if the key is not found
     * @return The stored value if key exists or defaultValue specified
     */
    fun getLong(context: Context, key: String, defaultValue: Long): Long {
        return getPreferences(context).getLong(key, defaultValue)
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
    fun getLong(context: Context, prefName: String, key: String, defaultValue: Long): Long {
        return getPreferences(context, prefName).getLong(key, defaultValue)
    }

    /**
     * Get the saved Float value
     *
     * @param context context
     * @param key     The key of the stored value
     * @return The stored value if key exists or 0
     */
    fun getFloat(context: Context, key: String): Float {
        return getPreferences(context).getFloat(key, 0f)
    }

    /**
     * Get the saved Float value
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      The key of the stored value
     * @return The stored value if key exists or 0
     */
    fun getFloat(context: Context, prefName: String, key: String): Float {
        return getPreferences(context, prefName).getFloat(key, 0f)
    }

    /**
     * Get the saved Float value
     *
     * @param context      context
     * @param key          The key of the stored value
     * @param defaultValue The value to be returned if the key is not found
     * @return The stored value if key exists or defaultValue specified
     */
    fun getFloat(context: Context, key: String, defaultValue: Float): Float {
        return getPreferences(context).getFloat(key, defaultValue)
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
    fun getFloat(context: Context, prefName: String, key: String, defaultValue: Float): Float {
        return getPreferences(context, prefName).getFloat(key, defaultValue)
    }

    /**
     * Get the saved String value
     *
     * @param context context
     * @param key     The key of the stored value
     * @return The stored value if key exists or value of vera
     */
    fun getString(context: Context, key: String): String? {
        return getPreferences(context).getString(key, vera)
    }

    /**
     * Get the saved String value
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      The key of the stored value
     * @return The stored value if key exists or value of vera
     */
    fun getString(context: Context, prefName: String, key: String): String? {
        return getPreferences(context, prefName).getString(key, vera)
    }

    /*
    */
    /**
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
    fun getString(context: Context, prefName: String, key: String, defaultValue: String): String? {
        return getPreferences(context, prefName).getString(key, defaultValue)
    }

    /**
     * Get the saved Boolean value
     *
     * @param context context
     * @param key     The key of the stored value
     * @return The stored value if key exists or false
     */
    fun getBoolean(context: Context, key: String): Boolean {
        return getPreferences(context).getBoolean(key, false)
    }

    /**
     * Get the saved Boolean value
     *
     * @param context  context
     * @param prefName The name of the preference
     * @param key      The key of the stored value
     * @return The stored value if key exists or false
     */
    fun getBoolean(context: Context, prefName: String, key: String): Boolean {
        return getPreferences(context, prefName).getBoolean(key, false)
    }

    /**
     * Get the saved Boolean value
     *
     * @param context      context
     * @param key          The key of the stored value
     * @param defaultValue The value to be returned if the key is not found
     * @return The stored value if key exists or defaultValue specified
     */
    fun getBoolean(context: Context, key: String, defaultValue: Boolean): Boolean {
        return getPreferences(context).getBoolean(key, defaultValue)
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
    fun getBoolean(context: Context, prefName: String, key: String, defaultValue: Boolean): Boolean {
        return getPreferences(context, prefName).getBoolean(key, defaultValue)
    }

    /**
     * Get the saved String set values
     *
     * @param context context
     * @param key     The key of the stored value
     * @return The string set values if key exists else an empty set
     */
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    fun getSet(context: Context, key: String): Set<String>? {
        return getPreferences(context).getStringSet(key, LinkedHashSet())
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
    fun getSet(context: Context, prefName: String, key: String): Set<String>? {
        return getPreferences(context, prefName).getStringSet(key, LinkedHashSet())
    }


    /**
     * Gets all the preferences
     * NOTE: Do not change the values of the to have the saved content to be consistent
     *
     * @param context context
     * @return All the stored preferences as a Map
     */
    fun getAll(context: Context): Map<String, *> {
        return getPreferences(context).all
    }

    /**
     * Gets all the preferences
     * NOTE: Do not change the values of the to have the saved content to be consistent
     *
     * @param context  context
     * @param prefName The name of the preference
     * @return All the stored preferences as a Map
     */
    fun getAll(context: Context, prefName: String): Map<String, *> {
        return getPreferences(context, prefName).all
    }
}
