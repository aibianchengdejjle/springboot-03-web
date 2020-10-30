package com.jjl.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import java.net.http.HttpRequest;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public  String  login(HttpSession session, @PathParam("username") String username, @PathParam("password") String password, Model model){
        if(password.equals("123")){
            session.setAttribute("sessino",username);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","error");
            return "redirect:/index1";
        }

    }

}
