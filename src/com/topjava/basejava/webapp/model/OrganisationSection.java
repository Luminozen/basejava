package com.topjava.basejava.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrganisationSection extends AbstractSection {
    private final static long serialVersionUID = 1L;

    private List<Organization> organizations;

    public OrganisationSection() {
    }

    public OrganisationSection(List<Organization> organizations) {
        Objects.requireNonNull(organizations, "organization must not be null");
        this.organizations = organizations;
    }

    public OrganisationSection(Organization... organizations) {
        this(Arrays.asList(organizations));
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganisationSection that = (OrganisationSection) o;

        return organizations.equals(that.organizations);
    }

    @Override
    public int hashCode() {
        return organizations.hashCode();
    }

    @Override
    public String toString() {
        return organizations.toString();
    }
}
