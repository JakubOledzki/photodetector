package com.joledzki.photodetector.controller;

import com.joledzki.photodetector.config.ApiKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
public class MainController {

    @Autowired
    ApiKey apiKey;

    @GetMapping("/")
    public String setUrl(){
        return "index";
    }

    @GetMapping("/picture")
    public String getInfo(@RequestParam String url, Model model){
        model.addAttribute("url", url);
        model.addAttribute("modelList",apiKey.getInfo(url).get(0).data());
        return "picture";
    }

}
