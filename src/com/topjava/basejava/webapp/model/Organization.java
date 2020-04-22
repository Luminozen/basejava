package com.topjava.basejava.webapp.model;

import java.time.YearMonth;
import java.util.Objects;

public class Organization {
    private final String title;
    private final YearMonth startDate;
    private final YearMonth endDate;
    private final String description;

    public Organization(String title, YearMonth startDate, YearMonth endDate, String description) {
        Objects.requireNonNull(title,"title must not be null");
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate,"endDate must not be null");
        Objects.requireNonNull(description, "description must not be null");
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!title.equals(that.title)) return false;
        if (!startDate.equals(that.startDate)) return false;
        if (!endDate.equals(that.endDate)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                '}';
    }
}
