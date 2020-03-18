package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
class PostController {


    private final PostRepo postDao;

    public PostController(PostRepo postDao){
        this.postDao = postDao;
    }



    //      SHOW ALL POSTS
    @GetMapping("/posts")
    public String getPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    //      EDIT POST
    @GetMapping("/posts/{id}/edit")
    public String editPostDetails(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post post){
        postDao.save(post);
        return "redirect:/posts";
    }

    //      Delete a Post
    @PostMapping("/posts/delete")
    public String deletePostById(@RequestParam long postId, Model model) {
        postDao.deleteById(postId);
        return "redirect:/posts";
    }


    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable long id, Model model) {
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

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id){
        postDao.deleteById(id);
        return "redirect:/posts";
    }



}
