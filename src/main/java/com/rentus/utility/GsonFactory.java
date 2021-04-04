package com.rentus.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonFactory {
    public static Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
                .create();
    }
}
