package com.github.smdj.marusei.controller;

// public을 지우면서 interface만 노출 시킨다.

import org.springframework.stereotype.Controller;

@Controller
class IndexControllerImpl implements IndexController {
    @Override
    public String index() {
        return "page/index-user";
    }
}
