package com.topjava.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class ExperienceSection {
    private final List<Organization> experience;

    public ExperienceSection(List<Organization> experience) {
        Objects.requireNonNull(experience, "experience must not be null");
        this.experience = experience;
    }

    public List<Organization> getExperience() {
        return experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExperienceSection that = (ExperienceSection) o;

        return experience.equals(that.experience);
    }

    @Override
    public int hashCode() {
        return experience.hashCode();
    }

    @Override
    public String toString() {
        return experience.toString();
    }
}
