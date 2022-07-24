package ru.liga.prerevolutionarytindertgbotclient.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.liga.prerevolutionarytindertgbotclient.model.BotState;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersonCacheTest {

    @Autowired
    PersonCache personCache;

    @Test
    void addPersonCache() {
        personCache.addPersonCache(323444L, BotState.SET_SEX);
        assertThat(personCache.containsKey(323444L)).isTrue();

    }

    @Test
    void addPersonCacheTwo() {
        personCache.addPersonCache(323444L, BotState.SET_SEX);
        personCache.addPersonCache(323444L, BotState.SET_SEX);
        assertThat(personCache.getPersons().size() == 1).isTrue();

    }

    @Test
    void getUsersCurrentBotState() {
        personCache.addPersonCache(323444L, BotState.SET_SEX);
        assertThat(personCache.getUsersCurrentBotState(323444L)).isEqualTo(BotState.SET_SEX);
    }
}