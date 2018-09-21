package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PageController {
    @RequestMapping("/viral")
    public String index(){
        return "viral";
    }

    @RequestMapping("/challenge")
    public String challenge(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name",name);
        return "challenge";
    }

    @RequestMapping(value= {"/challenge","challenge/{name}"})
    public String challengePath(@PathVariable Optional<String> name, Model model){
        if (name.isPresent()){
            model.addAttribute("name", name.get());
        }
        else {
            model.addAttribute("name", "KB");
        }
        return "challenge";
    }

    @RequestMapping("/generator")
    public String generator(@RequestParam(value = "a", required = false, defaultValue = "0") Integer a,
                            @RequestParam(value = "b", required = false, defaultValue = "0") Integer b,
                            Model model){
        model.addAttribute("a", a);
        model.addAttribute("b", b);

        String hm = "h";

        if (a.equals(0) || b.equals(0) || a.equals(1) || b.equals(1)){
            hm = "hm";

            String hm2 = hm;
            for (int i=0; i<b-1 ;i++){
                hm += " "+hm2;
            }
            model.addAttribute("hm",hm);
        }
        else if (a>1 || b>1){
            for (int i=0; i<a ;i++){
                hm += "m";
            }

            String hm2 = hm;
            for (int i=0; i<b-1 ;i++){
                hm += " "+hm2;
            }

            model.addAttribute("hm",hm);

        }
        else {
            model.addAttribute("hm", "hm");
        }
        return "generator";
    }

}
