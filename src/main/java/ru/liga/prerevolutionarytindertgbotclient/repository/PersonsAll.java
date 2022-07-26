package ru.liga.prerevolutionarytindertgbotclient.repository;

import org.springframework.stereotype.Component;
import ru.liga.prerevolutionarytindertgbotclient.model.BotState;
import ru.liga.prerevolutionarytindertgbotclient.model.Person;
import ru.liga.prerevolutionarytindertgbotclient.model.Sex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PersonsAll {
    public static final List<Person> listPersons = Arrays.asList(
            new Person(1L, Sex.MALE, "Никита", new StringBuilder().append("много лет, пошлый"), Sex.FEMALE, BotState.DEF),
            new Person(2L, Sex.MALE, "Анатолий", new StringBuilder().append("много лет, арбузер"), Sex.FEMALE, BotState.DEF),
            new Person(4L, Sex.FEMALE, "Мария", new StringBuilder().append("интеллектуал"), Sex.MALE, BotState.DEF),
            new Person(5L, Sex.FEMALE, "Оксана", new StringBuilder().append("интеллектуал"), Sex.MALE, BotState.DEF)
            );

}
