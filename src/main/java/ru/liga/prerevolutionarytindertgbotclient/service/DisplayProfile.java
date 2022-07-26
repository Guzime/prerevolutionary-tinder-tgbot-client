package ru.liga.prerevolutionarytindertgbotclient.service;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.liga.prerevolutionarytindertgbotclient.cache.PersonCache;
import ru.liga.prerevolutionarytindertgbotclient.model.Person;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
@AllArgsConstructor
public class DisplayProfile {
    PersonCache personCache;
    TranslateService translateService;

    @SneakyThrows
    String display(Long userId) {
        Person person = personCache.getUsersCurrentPerson(userId);
        return "✅Ваша анкета! \n\nИмя:" + "\n" + translateService.translate(person.getName()).getText() + "\n" +
                "Описание: " + "\n" + translateService.translate(person.getDescription().toString()).getText() + "\n";
    }

    @SneakyThrows
    void displayFile(){
        File file = new File("src/main/resources/prerev-background.jpg");
        BufferedImage image = ImageIO.read(file);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.RED);
        g.setFont(new Font("Courier New", Font.BOLD, 50));
        g.drawString("Какой-то текст", 20, 50);
        ImageIO.write(image, "jpg", new File(file.getParentFile(), "фото_гор_с_текстом.jpg"));
    }

}
