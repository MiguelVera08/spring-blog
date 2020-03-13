package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
class PostController {



    @GetMapping("/posts")
    @ResponseBody
    public String getPosts() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String getPost(@PathVariable int id) {
        return "Here's post number: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postCreateGetForm() {
        return "Getting the post that was created";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreatePost() {
        return "Posting a post";
    }

}
