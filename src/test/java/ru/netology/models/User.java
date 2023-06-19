package ru.netology.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String firstname;
    private String lastname;
    private String phoneNumber;
}
