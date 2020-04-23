package com.topjava.basejava.webapp.model;

public enum ContactsType {
    PHONE_NUMBER("Тел."),
    SKYPE("Skype"),
    EMAIL("Почта"),
    LINKEDIN("Профиль LinkedIn"),
    GITHUB("Профиль GitHub"),
    STUCKOVERFLOW("Профиль Stuckoverflow"),
    HOMEPAGE("Домашняя страница");

    private final String title;

    ContactsType(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
