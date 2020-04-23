package com.topjava.basejava.webapp.common;

import com.topjava.basejava.webapp.model.*;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume testResume = new Resume("UUID_1", "Petro");

        List<String> achievements = List.of("С 2013 года: разработка проектов " +
                        "\"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. " +
                        "Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". " +
                        "Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");

        List<Organization> organisation = new ArrayList<>();//EXPERIENCE
        List<Organization> education = new ArrayList<>();//EDUCATION

        Organization javaOps = new Organization(new Link("JavaOps", "http://javaops.ru/"), "Автор проекта",
                YearMonth.of(2013, 10), YearMonth.now(),
                "Создание, организация и проведение Java онлайн проектов и стажировок.");
        Organization eduCoursera = new Organization(new Link("Coursera", "coursera.org"), "",
                YearMonth.of(2013, 03), YearMonth.of(2013, 05),
                "Functional Programming Principles in Scala\" by Martin Odersky");

        organisation.add(javaOps);
        education.add(eduCoursera);

        testResume.addContact(ContactsType.PHONE_NUMBER, "+7(921) 855-0482");
        testResume.addContact(ContactsType.SKYPE, "grigory.kislin");
        testResume.addContact(ContactsType.EMAIL, "gkislin@yandex.ru");
        testResume.addContact(ContactsType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        testResume.addContact(ContactsType.GITHUB, "https://github.com/gkislin");
        testResume.addContact(ContactsType.STUCKOVERFLOW, "https://stackoverflow.com/users/548473/grigory-kislin");
        testResume.addContact(ContactsType.HOMEPAGE, "http://gkislin.ru/");

        testResume.addSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        testResume.addSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));

        testResume.addSection(SectionType.ACHIEVEMENT, new ListSection(achievements));

        testResume.addSection(SectionType.EXPERIENCE, new OrganisationSection(organisation));
        testResume.addSection(SectionType.EDUCATION, new OrganisationSection(education));

        showResume(testResume);

    }

    public static void showResume(Resume resume) {
        System.out.println("Имя: " + resume);
        for (ContactsType type : ContactsType.values()) {
            System.out.println(type.getTitle());
            System.out.println("      " + resume.getContact(type));
        }

        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle());
            System.out.println("      " + resume.getSection(type));
        }
    }


}
