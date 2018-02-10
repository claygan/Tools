package com.quest.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Quest on 2018/1/31.
 */
@Controller
@RequestMapping("jsp")
public class JspController {
    @RequestMapping(value = "hello")
    public String toJspPage() {
        return "/jsp/hello";
    }
}
