package com.topjava.basejava.webapp.model;

import java.util.Arrays;
import java.util.List;

public class ListSection extends AbstractSection {
    private final static long serialVersionUID = 1L;

    private final List<String> content;

    public ListSection(List<String> content) {
        this.content = content;
    }

    public ListSection(String ... items) {
       this(Arrays.asList(items));
    }

    public List<String> getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

        return content.equals(that.content);
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }

    @Override
    public String toString() {
        return content.toString();
    }
}