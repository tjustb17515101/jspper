package com.lin.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lin.mapper.UserMapper;
import com.lin.mapper.impl.UserDao;
import com.lin.pojo.User;
import com.lin.service.UserService;
import com.lin.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/list/{page}"})
    public String user(Model model,@PathVariable("page") int page){
        model.addAttribute("pageInfo",userService.findAll(page,10,"id",8));
        return "list";
    }

    @ResponseBody
    @PostMapping("/user")
    public int add(){
        int flag = 0;
        for (int i = 0; i < 45; i++) {
            String timestemp = ((Object)System.currentTimeMillis()).toString();
            Integer uno = Integer.parseInt(timestemp.substring(timestemp.length()-8));
            String uname = UUID.randomUUID().toString().substring(0,2);
            String upass = UUID.randomUUID().toString().substring(0,7);
            byte sex = (byte) (Math.random()>0.5?1:0);
            User user = new User(uno, upass, uname, sex);
            int a = userService.addUser(user);
            if(a>0 ){
                flag+=a;
            }
        }
        return flag;
    }

    @GetMapping("/del/{page}/{delId}")
    public String del(Model model ,@PathVariable("page") int page ,@PathVariable("delId") int delId){
        userService.delete(delId);
        model.addAttribute("pageInfo",userService.findAll(page,10,"id",8));
        return "list";
    }

    @PostMapping("login")
    public String login(User user , HttpServletRequest request){
        if(user!=null&&!user.getUno().equals("")&&!user.getUpass().equals("")){
            User byUno = userService.findByUno(user.getUno());
            if(byUno!=null&&byUno.getUpass().equals(user.getUpass())){
                request.getSession().setAttribute("user",byUno);
                return "redirect:"+request.getContextPath()+"/list/1";
            }
            request.setAttribute("loginTip","账号密码不匹配");
        }
        String contextPath = request.getSession().getServletContext().getContextPath();
        System.out.println(contextPath);
        return "forward:/WEB-INF/pages/login.jsp";
    }
}
