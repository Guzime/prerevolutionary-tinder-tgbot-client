package ru.liga.prerevolutionarytindertgbotclient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
public class Person {
    private Long id;
    private Sex sex;
    private String name;
    private StringBuilder description;
    private Sex typeSearch;
    private BotState botState;

}
