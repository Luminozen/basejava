package com.topjava.basejava.webapp.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.topjava.basejava.webapp.model.AbstractSection;
import com.topjava.basejava.webapp.model.SectionType;

import java.io.Reader;
import java.io.Writer;

public class JsonParser {
    private static Gson GSON = new GsonBuilder()
            .registerTypeAdapter(AbstractSection.class, new JsonSectionAdapter())
            .create();

    public static <T> T read(Reader reader, Class<T> clazz) {
        return GSON.fromJson(reader, clazz);
    }

    public static <T> void write(T object, Writer writer) {
        GSON.toJson(object, writer);
    }
}
