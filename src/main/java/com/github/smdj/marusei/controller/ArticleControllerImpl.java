package com.github.smdj.marusei.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;


@Controller
class ArticleControllerImpl implements ArticleController {
    // class이름을 넘겨주면 log이름으로 class이름을 사용한다.
    public static final Logger log = LoggerFactory.getLogger(ArticleControllerImpl.class);

    @Override
    public String createForm() {
        if (log.isTraceEnabled()) {
            log.trace("{} is called!", "createForm");
        }

        return "page/article/create";
    }

    @Override
    public String preview() {
        if (log.isTraceEnabled()) {
            log.trace("{} is called!", "preview");
        }

        return "page/article/preview";
    }

    @Override
    public String create() {
        if (log.isTraceEnabled()) {
            log.trace("{} is called!", "create");
        }

        return "page/article/detail";
    }

    @Override
    public String detail(long id) {
        if (log.isTraceEnabled()) {
            log.trace("{} is called!", "detail");
        }

        return "page/article/detail";
    }

    @Override
    public String editForm(long id) {
        if (log.isTraceEnabled()) {
            log.trace("{} is called!", "editForm");
        }

        return "page/article/edit";
    }

    @Override
    public String edit(long id) {
        if (log.isTraceEnabled()) {
            log.trace("{} is called!", "edit");
        }

        return "page/article/detail";
    }

    @Override
    public String delete(long id) {
        if (log.isTraceEnabled()) {
            log.trace("{} is called!", "delete");
        }

        return "page/index-user";
    }
}
