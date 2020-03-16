package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
class PostController {



    @GetMapping("/posts")
    public String getPosts(Model model) {
        ArrayList<Post> postList = new ArrayList<>();
        postList.add(new Post(2,"second post", "body sfsdfadsfasfsd"));
        postList.add(new Post(3,"third post", "body adfasfsdfsdfsdfsd"));

        model.addAttribute("posts", postList);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable int id, Model model) {
        Post post1 = new Post(id, "Europa's First Post", "Remote Learning Today!");
        model.addAttribute("title", post1.getTitle());
        model.addAttribute("body", post1.getBody());
        return "posts/show";
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

    @RequestMapping(path="/posts", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(){
        return "DELETE!!";
    }

}
