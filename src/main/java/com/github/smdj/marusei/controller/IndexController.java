package com.github.smdj.marusei.controller;

import com.github.smdj.marusei.controller.request.SignUpRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@RequestMapping
public interface IndexController {
    @GetMapping("")
    String index();

    @GetMapping("/signup")
    String signUpForm(Model model);

    @PostMapping("/signup")
    String signUp(@ModelAttribute @Valid SignUpRequest signUpRequest, BindingResult bindingResult, Model model);
}
