package ru.liga.prerevolutionarytindertgbotclient.cache;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.liga.prerevolutionarytindertgbotclient.model.BotState;
import ru.liga.prerevolutionarytindertgbotclient.model.Person;
import ru.liga.prerevolutionarytindertgbotclient.model.Sex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Getter
@ToString
@Component
public class PersonCache {

    private List<Person> persons = new ArrayList<>();

    /**
     *
     * @param userId
     * @param botState
     */
    public void addPersonCache(Long userId, BotState botState) {
        if (!containsKey(userId)) {
            log.info("Add to cache user: " + userId);
            persons.add(Person.builder().id(userId).botState(botState).build());
        }
    }

    public void setNameAndDesciption(String str, Long userId) {
        Person person = getUsersCurrentPerson(userId);
        String[] params = str.split("\n");
        for (int i = 0; i < params.length; i++) {
            if (i == 0) {
                person.setName(params[0]);
            } else {
                if (person.getDescription() == null) {
                    person.setDescription(new StringBuilder().append(params[i]));
                } else {
                    person.setDescription(person.getDescription().append(" ").append(params[i]));
                }
            }
        }
        log.info("Set to user: " + userId + " name, descr " + person);
    }

    public void setNewState(Long userId, BotState botState) {
        for (Person person : persons) {
            if (person.getId().equals(userId)) {
                person.setBotState(botState);
            }
        }
        log.info("Set to user: " + userId + " state - " + botState);
    }

    public void setNewSex(Long userId, Sex sex) {
        Person person = getUsersCurrentPerson(userId);
        person.setSex(sex);
        log.info("Set to user: " + userId + " Sex - " + sex);
    }

    public void setTypeSearch(Long userId, Sex sex) {
        Person person = getUsersCurrentPerson(userId);
        person.setTypeSearch(sex);
        log.info("Set to user: " + userId + " TypeSearch - " + sex);
    }

    public BotState getUsersCurrentBotState(Long userId) {
        for (Person person : persons) {
            if (person.getId().equals(userId)) {
                return person.getBotState();
            }
        }
        return BotState.DEF;
    }

    public Person getUsersCurrentPerson(Long userId) {
        for (Person person : persons) {
            if (person.getId().equals(userId)) {
                return person;
            }
        }
        return Person.builder().id(userId).build();
    }

    public boolean containsKey(Long userId) {
        for (Person person : persons) {
            if (person.getId().equals(userId)) {
                return true;
            }
        }
        return false;
    }
}
