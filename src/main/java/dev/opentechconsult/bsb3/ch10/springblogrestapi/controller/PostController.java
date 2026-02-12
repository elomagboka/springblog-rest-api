package dev.opentechconsult.bsb3.ch10.springblogrestapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class PostController {

    @ResponseBody
    @GetMapping("/posts")
    public String getPosts() {
        return "Posts";
    }
}
