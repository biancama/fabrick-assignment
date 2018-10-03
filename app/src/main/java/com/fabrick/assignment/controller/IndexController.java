package com.fabrick.assignment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
@Controller
@Slf4j
public class IndexController {
    @GetMapping(path = {"", "index"})
    public String index(Model model) {
        model.addAttribute("message", "HELLO Admin");
        model.addAttribute("date", LocalDateTime.now());
        return "index";
    }
}
