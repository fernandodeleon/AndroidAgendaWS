package com.edwindeleon.org.androidagenda.restApi;

/**
 * Created by Fernando on 13/03/2018.
 */

public final class ConstantesRestApi {
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com/" + VERSION;
    public static final String ACCESSS_TOKEN = "7051879956.40039c7.bcb58bdb44ff4ae8b1a0e85c57f818c0";
    public static final String KEY_ACCESSS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESSS_TOKEN + ACCESSS_TOKEN;
    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS_TOKEN
}
