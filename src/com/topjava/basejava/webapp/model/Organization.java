package com.topjava.basejava.webapp.model;

import java.time.YearMonth;
import java.util.Objects;

public class Organization {
    private final Link homePage;
    private final String position;
    private final YearMonth startDate;
    private final YearMonth endDate;
    private final String description;

    public Organization(Link homePage, String position, YearMonth startDate, YearMonth endDate, String description) {
        Objects.requireNonNull(position,"homePage must not be null");
        Objects.requireNonNull(position,"position must not be null");
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate,"endDate must not be null");
        Objects.requireNonNull(description, "description must not be null");
        this.homePage = homePage;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!homePage.equals(that.homePage)) return false;
        if (!position.equals(that.position)) return false;
        if (!startDate.equals(that.startDate)) return false;
        if (!endDate.equals(that.endDate)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "homePage=" + homePage +
                ", position='" + position + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                '}';
    }
}
