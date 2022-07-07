package mss.community.controller;

import mss.community.dto.PaginationDTO;
import mss.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * Created by MSS on 2021/3/8
 */
@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index( Model model,
                        @RequestParam(name="page",defaultValue = "1") Integer page,
                        @RequestParam(name="size",defaultValue = "5") Integer size){

        PaginationDTO pagination=questionService.list(page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
