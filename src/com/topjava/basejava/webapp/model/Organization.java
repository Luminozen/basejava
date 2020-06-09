package com.topjava.basejava.webapp.model;

import com.topjava.basejava.webapp.util.YearMonthAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Organization implements Serializable {
    private final static long serialVersionUID = 1L;

    private Link homePage;
    private List<Position> positions;

    public Organization() {
    }

    public Organization(Link homePage, List<Position> positions) {
        this.homePage = homePage;
        this.positions = positions;
    }

    public Organization(String title, String url, Position... positions) {
        this(new Link(title, url), Arrays.asList(positions));
    }

    public Link getHomePage() {
        return homePage;
    }

    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!homePage.equals(that.homePage)) return false;
        return positions.equals(that.positions);
    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + positions.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage + "\n" +
                ", positions=" + positions +
                '}' + "\n";
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Position implements Serializable {

        private final static long serialVersionUID = 1L;

        private String position;
        @XmlJavaTypeAdapter(YearMonthAdapter.class)
        private YearMonth startDate;
        @XmlJavaTypeAdapter(YearMonthAdapter.class)
        private YearMonth endDate;
        private String description;

        public Position() {
        }

        public Position(String position, YearMonth startDate, YearMonth endDate, String description) {
            Objects.requireNonNull(position, "position must not be null");
            Objects.requireNonNull(startDate, "startDate must not be null");
            Objects.requireNonNull(endDate, "endDate must not be null");
            Objects.requireNonNull(description, "description must not be null");
            this.position = position;
            this.startDate = startDate;
            this.endDate = endDate;
            this.description = description;
        }

        public String getPosition() {
            return position;
        }

        public YearMonth getStartDate() {
            return startDate;
        }

        public YearMonth getEndDate() {
            return endDate;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position1 = (Position) o;

            if (!position.equals(position1.position)) return false;
            if (!startDate.equals(position1.startDate)) return false;
            if (!endDate.equals(position1.endDate)) return false;
            return description.equals(position1.description);
        }

        @Override
        public int hashCode() {
            int result = position.hashCode();
            result = 31 * result + startDate.hashCode();
            result = 31 * result + endDate.hashCode();
            result = 31 * result + description.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "position='" + position + '\'' +
                    ", startDate=" + startDate +
                    ", endDate=" + endDate +
                    ", description='" + description + '\'' +
                    '}' + "\n";
        }
    }
}
