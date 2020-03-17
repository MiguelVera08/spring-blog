package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Ad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.codeup.springblog.repositories.AdRepo;

import java.util.List;

@Controller
public class AdController {

    private AdRepo adDao;

    public AdController(AdRepo adDao){
        this.adDao = adDao;
    }

    @GetMapping("/ads")
    @ResponseBody
    public List<Ad> getAllAds(){
        return adDao.findAll();
    }

    @GetMapping("/ads/save")
    @ResponseBody
    public String saveAd(){
        Ad newAd = new Ad();
        newAd.setTitle("New AD");
        newAd.setDescription("This is a newly saved description");
        adDao.save(newAd);
        return "Saving ad";
    }

    @GetMapping("/ads/update")
    @ResponseBody
    public String UpdateAd(){
        Ad ad = adDao.getOne(1L);
        ad.setTitle("Updated Title!");
        adDao.save(ad);
        return "Updating ad";
    }

    @GetMapping("ads/search")
    public String searchAd(Model model){
        Ad ad = adDao.findByTitle("Title");
        model.addAttribute("ad",ad);
        return "ads/search";
    }
}
