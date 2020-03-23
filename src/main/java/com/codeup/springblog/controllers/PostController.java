package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepo;
import com.codeup.springblog.repositories.UserRepo;
import com.codeup.springblog.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
class PostController {


    private PostRepo postDao;
    private UserRepo userDao;


    @Autowired
    private  MailService emailService;

    public PostController(PostRepo postDao, UserRepo userDao, MailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userId", u.getId());
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

        String emailSubject = "This is the email subject.";
        String emailBody = "Email Body Text";
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(u);
        postDao.save(post);
        emailService.prepareAndSend(post, emailSubject, emailBody);
        return "redirect:/posts/";
    }

    //      Delete a Post
    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.getId() == postDao.getOne(id).getUser().getId())
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
