package ru.netology.enums;

public enum ValidationMessages implements IEnumValue {
    PHONE_WRONG_NUMBER("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."),
    WRONG_DELIVERY_CITY("Доставка в выбранный город недоступна"),
    WRONG_NAME_OR_LASTNAME("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."),
    INCORRECT_DATE("Неверно введена дата");


    private String messageKey;

    ValidationMessages(String messageKey) {
        this.messageKey = messageKey;
    }


    @Override
    public String getValue() {
        return this.messageKey;
    }
}
