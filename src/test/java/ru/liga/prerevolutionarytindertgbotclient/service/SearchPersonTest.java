package ru.liga.prerevolutionarytindertgbotclient.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.liga.prerevolutionarytindertgbotclient.model.Sex;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SearchPersonTest {
    @Autowired
    SearchPerson searchPerson;

    @Test
    public void getPersonBySexMale() {
        System.out.println(searchPerson.getPersonSex(Sex.MALE));
        assertThat(searchPerson.getPersonSex(Sex.MALE).size()==2).isTrue();
    }

    @Test
    public void getPersonBySexFemale() {
        System.out.println(searchPerson.getPersonSex(Sex.FEMALE));
        assertThat(searchPerson.getPersonSex(Sex.MALE).size()==2).isTrue();
    }
}