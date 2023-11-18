package com.example.store101.sharedpreference

import android.content.Context
import android.content.SharedPreferences

object PreferenceHelper {
    private const val PREF_NAME = "users"
    private var sharedPreferences: SharedPreferences? = null
    @JvmStatic
    fun getSharedPreferences(context: Context): SharedPreferences? {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        }
        return sharedPreferences
    }

    fun writeIntToPreference(key: String?, value: Int) {
        val editor = sharedPreferences!!.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    @JvmStatic
    fun writeStringToPreference(key: String?, value: String?) {
        val editor = sharedPreferences!!.edit()
        editor?.putString(key, value)
        editor.apply()
    }

    @JvmStatic
    fun writeBooleanToPreference(key: String?, value: Boolean) {
        val editor = sharedPreferences!!.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    @JvmStatic
    fun readBooleanFromPreference(key: String?, b: Boolean): Boolean {
        return sharedPreferences!!.getBoolean(key, false)
    }

    @JvmStatic
    fun readStringFromPreference(key: String?): String? {
        return sharedPreferences!!.getString(key, "")
    }

    fun readIntFromPreference(key: String?): Int {
        return sharedPreferences!!.getInt(key, 0)
    }
}