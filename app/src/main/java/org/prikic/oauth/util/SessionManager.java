package org.prikic.oauth.util;


import android.content.Context;
import android.content.SharedPreferences;

import org.prikic.oauth.R;

/**
 * Session manager to save and fetch data from SharedPreferences
 */
public class SessionManager {

    private Context context;

    public SessionManager(Context context) {
        this.context = context;
    }

    private SharedPreferences prefs =
            context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);


    private static final String USER_TOKEN = "user_token";

    /**
     * Function to save auth token
     */
    public void saveAuthToken(String token) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(USER_TOKEN, token);
        editor.apply();
    }

    /**
     * Function to fetch auth token
     */
    public String fetchAuthToken() {
        return prefs.getString(USER_TOKEN, null);
    }
}
