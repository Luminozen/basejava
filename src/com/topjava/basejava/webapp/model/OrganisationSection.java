package com.topjava.basejava.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrganisationSection extends AbstractSection {
    private final static long serialVersionUID = 1L;

    private List<Organization> organization;

    public OrganisationSection() {
    }

    public OrganisationSection(List<Organization> organization) {
        Objects.requireNonNull(organization, "organization must not be null");
        this.organization = organization;
    }

    public OrganisationSection(Organization... organizations) {
        this(Arrays.asList(organizations));
    }

    public List<Organization> getOrganization() {
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
