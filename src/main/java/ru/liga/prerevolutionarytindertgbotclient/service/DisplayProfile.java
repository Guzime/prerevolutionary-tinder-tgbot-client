package ru.liga.prerevolutionarytindertgbotclient.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.liga.prerevolutionarytindertgbotclient.cache.PersonCache;
import ru.liga.prerevolutionarytindertgbotclient.model.Person;

@Component
@AllArgsConstructor
public class DisplayProfile {
    PersonCache personCache;

    String display(Long userId) {
        Person person = personCache.getUsersCurrentPerson(userId);
        return "✅Ваша анкета!\n\nИмя:" + "\n" + person.getName() + "\n" +
                "Описание:" + "\n" + person.getDescription() + "\n";
    }
}
