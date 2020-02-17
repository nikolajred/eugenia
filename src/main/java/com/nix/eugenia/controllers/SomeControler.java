package com.nix.eugenia.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeControler {

    @GetMapping ("/main")
    public String saySomething(){
        return "Go";
    }
}
