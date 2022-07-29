package ru.liga.prerevolutionarytindertgbotclient.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.liga.prerevolutionarytindertgbotclient.model.Person;
import ru.liga.prerevolutionarytindertgbotclient.model.Sex;
import ru.liga.prerevolutionarytindertgbotclient.repository.PersonsAll;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SearchPerson {

    public List<Person> getPersonSex(Sex typeSearch) {
        return PersonsAll.listPersons.stream().filter(person -> person.getTypeSearch().equals(typeSearch)).collect(Collectors.toList());
    }

}
