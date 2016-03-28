package com.killpekeinside.config.properties.doc;

/**
 * Created by Raman_Susla on 27.03.2015 23:45.
 */
public enum MediaTypeKey {
    JSON("json"),
    XML("xml");
    private final String key;

    MediaTypeKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
