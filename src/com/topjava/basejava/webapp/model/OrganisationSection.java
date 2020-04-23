package com.topjava.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class OrganisationSection extends Section {
    private final List<Organization> organization;

    public OrganisationSection(List<Organization> organization) {
        Objects.requireNonNull(organization, "organization must not be null");
        this.organization = organization;
    }

    public List<Organization> getorganization() {
        return organization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganisationSection that = (OrganisationSection) o;

        return organization.equals(that.organization);
    }

    @Override
    public int hashCode() {
        return organization.hashCode();
    }

    @Override
    public String toString() {
        return organization.toString();
    }
}
