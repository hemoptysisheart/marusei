package com.github.smdj.marusei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping
public interface IndexController {
    @GetMapping("")
    String index();
}
