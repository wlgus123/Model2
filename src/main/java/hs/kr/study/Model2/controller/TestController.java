package hs.kr.study.Model2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class TestController {
    @GetMapping("/test1")
    public String test1(@RequestParam("name") String name,
                        @RequestParam("pass") String pass,
                        Model model) {

        model.addAttribute("name", name);
        model.addAttribute("pass", pass);

        return "test1";
    }

    @GetMapping("/test2/{name}/{pass}/{area}")
    public String test2(@PathVariable("name") String name,
                        @PathVariable("pass") String pass,
                        @PathVariable("area") String area,
                        Model model) {
        model.addAttribute("name", name);
        model.addAttribute("pass", pass);
        model.addAttribute("area", area);

        return "test2";
    }

    @GetMapping("/test3")
    public ModelAndView mav() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "lee");
        mv.addObject("pass", "2222");
        mv.setViewName("test3");  // return "test3" 과 같음

        return mv;  // ModelAndView 타입으로 한 번에 보내기
    }

    @PostMapping("/test4")
    public String test4(@RequestParam("id") String id,
                        @RequestParam("pass") String pass,
                        Model model) {
        if(id.equals("lee") && pass.equals("3333")) {
            model.addAttribute("id", id);
            model.addAttribute("pass", pass);
        }
        else {
            return "wrong";
        }

        return "test4";
    }
}
