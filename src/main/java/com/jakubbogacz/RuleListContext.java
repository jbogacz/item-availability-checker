package com.jakubbogacz;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JBOGACZ on 30.05.2017.
 */
@Component
public class RuleListContext {

    public static List<Rule> RULE_LIST = new ArrayList<>();

    {
        RULE_LIST.add(new Rule(
                "Gigabyte Radeon RX 570 GAMING 4GB GDDR5",
                "http://www.x-kom.pl/p/359723-karta-graficzna-pci-e-gigabyte-radeon-rx-570-gaming-4gb-gddr5.html",
                ".product-infobox p button:not([class*='temporary-unavailable'])"));
    }
}
