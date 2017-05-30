package com.jakubbogacz;

import lombok.Data;

/**
 * Created by JBOGACZ on 30.05.2017.
 */
public class Rule {

    private String name;
    private String url;
    private String selector;

    public Rule(String name, String url, String selector) {
        this.name = name;
        this.url = url;
        this.selector = selector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", selector='" + selector + '\'' +
                '}';
    }
}
