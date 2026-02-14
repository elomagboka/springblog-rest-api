package dev.opentechconsult.bsb3.ch10.springblogrestapi.controller;

import dev.opentechconsult.bsb3.ch10.springblogrestapi.dto.PostDto;
import dev.opentechconsult.bsb3.ch10.springblogrestapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> listPosts() {
        return postService.findAllPosts();
    }
}
