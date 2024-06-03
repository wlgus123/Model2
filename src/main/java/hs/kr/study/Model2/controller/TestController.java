package hs.kr.study.Model2.controller;

import hs.kr.study.Model2.dto.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

//    @PostMapping("/test4")
//    public String test4(@RequestParam("id") String id,
//                        @RequestParam("pass") String pass,
//                        Model model) {
//        if(id.equals("lee") && pass.equals("3333")) {
//            model.addAttribute("id", id);
//            model.addAttribute("pass", pass);
//        }
//        else {
//            return "wrong";
//        }
//
//        return "test4";
//    }

    @PostMapping("/test4")
    // @ModelAttribute로 받아서 아이디, 비번 체크하기
    public String test4(@ModelAttribute LoginDTO dto, Model model) {
        // LoginDTO dto : 사용자의 입력을 받아서 자동으로 set메서드 이용해서 LoginDTO에 넣어준다.
        String uid = dto.getId();
        String upass = dto.getPass();

        if(uid.equals("lee") && upass.equals("3333")) {
            model.addAttribute("id", uid);
            model.addAttribute("pass", upass);

            return "test4";
        }

        return "wrong";
    }
}
