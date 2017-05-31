package com.jakubbogacz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jbogacz on 30.05.2017.
 */
@Component
public class ScheduledTasks {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Value("${scheduler.fixedRateString}")
    private Long fixedRate;

    @Autowired
    private EmailService emailService;

    @Scheduled(fixedRateString  = "${scheduler.fixedRateString}")
    public void scan() throws IOException, MessagingException {
        LOGGER.info("The time is now {}", dateFormat.format(new Date()));
        List<Rule> ruleList = RuleListContext.RULE_LIST;
        for (Rule rule : ruleList) {
            Document document =
                    Jsoup.connect(rule.getUrl()).get();
            Elements select = document.select(rule.getSelector());
            if (select.size() != 0) {
                LOGGER.info("AVAILABLE element [{}] on page [{}]", rule.getSelector(), rule.getUrl());
                LOGGER.info("SENDING NOTIFICATION EMAIL about {}", rule.getName());
                emailService.send(
                        "ITEM AVAILABLE",
                        "Item [" + rule.getName() + "] is available now on page [" + rule.getUrl() + "]. Matching selector: " + rule.getSelector());
            } else {
                LOGGER.info("NOT AVAILABLE element [{}] on page [{}]", rule.getSelector(), rule.getUrl());
            }
        }
    }

    @Scheduled(fixedRate = 300000)
    public void awakeHerokuItSelf() throws IOException {
        LOGGER.info("Awakening it self");
//        Jsoup.connect("https://infinite-reef-78093.herokuapp.com/rules").get();
        URLConnection connection = new URL("https://infinite-reef-78093.herokuapp.com/rules").openConnection();
        InputStream response = connection.getInputStream();

    }
}
