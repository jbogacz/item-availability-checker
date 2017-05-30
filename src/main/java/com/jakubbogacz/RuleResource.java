package com.jakubbogacz;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by JBOGACZ on 30.05.2017.
 */
@RestController
@RequestMapping("/rules")
public class RuleResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Rule>> rules() {
        return new ResponseEntity<>(RuleListContext.RULE_LIST, HttpStatus.OK);
    }

}
