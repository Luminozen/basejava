package com.topjava.basejava.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Link implements Serializable {
    private final static long serialVersionUID = 1L;

    private String title;
    private String url;

    public Link() {
    }

    public Link(String title, String url) {
        Objects.requireNonNull(title, "title must not be null");
        Objects.requireNonNull(url, "url must not be null");
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (!title.equals(link.title)) return false;
        return url.equals(link.url);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Link{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
