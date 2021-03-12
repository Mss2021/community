package mss.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

/**
 * Created by MSS on 2021/3/8
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name="name",required=false, defaultValue="World")String name,Model model){
        model.addAttribute("name",name);
        return "hello";
    }
}
