package ltwu9306.community.community.controller;

import ltwu9306.community.community.dto.PageinationDTO;
import ltwu9306.community.community.dto.QuestionDTO;
import ltwu9306.community.community.mapper.QuestionMapper;
import ltwu9306.community.community.mapper.UserMapper;
import ltwu9306.community.community.model.Question;
import ltwu9306.community.community.model.User;
import ltwu9306.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "2") Integer size) {
        Cookie[] cookies = request.getCookies();
        if(cookies == null || cookies.length == 0){
            return "index";
        }
        for(Cookie cookie:cookies)
        {
            if(cookie.getName().equals("token"))
            {
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if(user!=null)
                {
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }

        PageinationDTO pageination = questionService.list(page,size);
        model.addAttribute("pageination",pageination);

        return "index";
    }
}
