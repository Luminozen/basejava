package com.topjava.basejava.webapp.common;

import com.topjava.basejava.webapp.model.*;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume1;
        Resume resume2;

        /*List<String> achievements = List.of("С 2013 года: разработка проектов " +
                        "\"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. " +
                        "Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". " +
                        "Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");

        List<Organization> organisation = new ArrayList<>();//EXPERIENCE
        List<Organization> education = new ArrayList<>();//EDUCATION

        /*Organization javaOps = new Organization("JavaOps", "http://javaops.ru/", "Автор проекта",
                YearMonth.of(2013, 10), YearMonth.now(),
                "Создание, организация и проведение Java онлайн проектов и стажировок.");
        Organization eduCoursera = new Organization("Coursera", "coursera.org", "",
                YearMonth.of(2013, 03), YearMonth.of(2013, 05),
                "Functional Programming Principles in Scala\" by Martin Odersky");*/

        /*organisation.add(javaOps);
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
        testResume.addSection(SectionType.EDUCATION, new OrganisationSection(education));*/

        resume1 = createResume("UUID_1", "NAME_1");
        resume2 = createResume("UUID_2", "NAME_2");
        showResume(resume1);
        showResume(resume2);

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

    public static Resume createResume(String uuid, String fullname){
        Resume resume = new Resume(uuid, fullname);
        resume.addContact(ContactsType.PHONE_NUMBER, "+0(000) 00-0000");
        resume.addContact(ContactsType.SKYPE, "person.skype");
        resume.addContact(ContactsType.EMAIL, "person.dummy@email.com");
        resume.addContact(ContactsType.LINKEDIN, "https://www.linkedin.com/in/persondummy");
        resume.addContact(ContactsType.GITHUB, "https://github.com/persondummy");
        resume.addContact(ContactsType.STUCKOVERFLOW, "https://stackoverflow.com/users/548473/person-dummy");
        resume.addContact(ContactsType.HOMEPAGE, "http://persondummy.ru/");

        resume.addSection(SectionType.PERSONAL, new TextSection("PERSONAL QUALITIES"));
        resume.addSection(SectionType.OBJECTIVE, new TextSection("OBJECTIVE QUALITIES"));
        resume.addSection(SectionType.ACHIEVEMENT, new ListSection("ACHIEVEMENT_1", "ACHIEVEMENT_2", "ACHIEVEMENT_3"));
        resume.addSection(SectionType.QUALIFICATIONS, new ListSection("QUALIFICATION_1","QUALIFICATION_2","QUALIFICATION_3"));

        resume.addSection(SectionType.EXPERIENCE, new OrganisationSection(
                new Organization("COMPANY_1", "http://company1.ru/",
                        new Organization.Position("POSITION_11",YearMonth.of(2007,10), YearMonth.of(2010,10),"DESCRIPTION_11"),
                        new Organization.Position("POSITION_12",YearMonth.of(2010,10), YearMonth.of(2013,10),"DESCRIPTION_12"),
                        new Organization.Position("POSITION_13",YearMonth.of(2013,10), YearMonth.now(),"DESCRIPTION_13")),
                new Organization("COMPANY_2", "http://company2.ru/",
                        new Organization.Position("POSITION_21",YearMonth.of(2007,10), YearMonth.of(2010,10),"DESCRIPTION_21"),
                        new Organization.Position("POSITION_22",YearMonth.of(2010,10), YearMonth.of(2013,10),"DESCRIPTION_22"),
                        new Organization.Position("POSITION_23",YearMonth.of(2013,10), YearMonth.now(),"DESCRIPTION_23"))

        ));

        resume.addSection(SectionType.EDUCATION, new OrganisationSection(
                new Organization("SCHOOL_1", "http://school1.ru/",
                        new Organization.Position("POSITION_11",YearMonth.of(2007,10), YearMonth.of(2010,10),"DESCRIPTION_11"),
                        new Organization.Position("POSITION_12",YearMonth.of(2010,10), YearMonth.of(2013,10),"DESCRIPTION_12"),
                        new Organization.Position("POSITION_13",YearMonth.of(2013,10), YearMonth.now(),"DESCRIPTION_13")),
                new Organization("SCHOOL_2", "http://school1.ru/",
                        new Organization.Position("POSITION_21",YearMonth.of(2007,10), YearMonth.of(2010,10),"DESCRIPTION_21"),
                        new Organization.Position("POSITION_22",YearMonth.of(2010,10), YearMonth.of(2013,10),"DESCRIPTION_22"),
                        new Organization.Position("POSITION_23",YearMonth.of(2013,10), YearMonth.now(),"DESCRIPTION_23"))
        ));
        return resume;
    }

}
