package com.jakubbogacz.task;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jbogacz on 30.05.2017.
 */
@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void skan() throws IOException {
        log.info("The time is now {}", dateFormat.format(new Date()));
        Document document =
                Jsoup.connect("https://www.x-kom.pl/p/359723-karta-graficzna-pci-e-gigabyte-radeon-rx-570-gaming-4gb-gddr5.html").get();
        Elements select = document.select(".product-infobox p button[class*='temporary-unavailable']");

        int i = 0;

    }
}
