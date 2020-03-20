package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepo;
import com.codeup.springblog.repositories.UserRepo;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
class PostController {


    private PostRepo postDao;
    private UserRepo userDao;

    public PostController(PostRepo postDao, UserRepo userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }


    //      SHOW ALL POSTS
    @GetMapping("/posts")
    public String getPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    //      Show post details
    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }

    //      Create Post
    @GetMapping("/posts/create")
    public String postCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post){
        post.setUser(userDao.getOne(1L));
        postDao.save(post);
        return "redirect:/posts/";
    }

    //      Delete a Post
    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id){
        postDao.deleteById(id);
        return "redirect:/posts";
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
}
