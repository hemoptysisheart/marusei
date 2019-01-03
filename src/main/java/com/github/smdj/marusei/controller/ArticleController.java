package com.github.smdj.marusei.controller;


import org.springframework.web.bind.annotation.*;

@RequestMapping("/articles")
public interface ArticleController {
    @GetMapping("/create")
    String createForm();

    @PostMapping("/preview")
    String preview();

    @PostMapping()
    String create();

    @GetMapping("/{id:\\d+}")
    String detail(@PathVariable("id") long id);

    @GetMapping("/{id:\\d+}/edit")
    String editForm(@PathVariable("id") long id);

    @PatchMapping("/{id:\\d+}")
    String edit(@PathVariable("id") long id);

    @DeleteMapping("{id:\\d+}")
    String delete(@PathVariable("id") long id);
}
