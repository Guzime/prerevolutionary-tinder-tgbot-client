package ru.liga.prerevolutionarytindertgbotclient.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.liga.prerevolutionarytindertgbotclient.model.PreReformText;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TranslateServiceTest {

    @Autowired
    TranslateService translateService;

    @SneakyThrows
    @Test
    void simpleRequest() {
        PreReformText preReformText = new PreReformText("Поэтъ-безумецъ! Мистическiй анархистъ, ходящiй надъ безднами");
        assertThat(translateService.translate("Поэт-безумец! Мистический анархист, ходящий над безднами").toString())
                .isEqualTo(preReformText.toString());
    }
}