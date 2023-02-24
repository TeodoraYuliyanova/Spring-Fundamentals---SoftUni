package com.example.mobilelele.web;

import com.example.mobilelele.models.dtos.banding.UserLoginDTO;
import com.example.mobilelele.models.dtos.banding.UserRegisterDTO;
import com.example.mobilelele.models.dtos.model.UserDTO;
import com.example.mobilelele.models.dtos.view.UserRoleViewDTO;
import com.example.mobilelele.services.UserRoleService;
import com.example.mobilelele.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    private final UserRoleService userRoleService;
    private final UserService userService;

    @Autowired
    public UserController(UserRoleService userRoleService, UserService userService) {
        this.userRoleService = userRoleService;
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView getRegister(ModelAndView modelAndView) {

        List<UserRoleViewDTO> allRoles = this.userRoleService.getAll();

        modelAndView.addObject("roles", allRoles);
        modelAndView.setViewName("auth-register");
        return modelAndView;
    }


    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute(name = "userRegisterDTO") UserRegisterDTO userRegisterDTO,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);
            return "auth-register";
        }

        this.userService.register(userRegisterDTO);
        return "redirect:login";
    }

    @ModelAttribute(name = "userRegisterDTO")
    public UserRegisterDTO userRegisterDTO() {
        return new UserRegisterDTO();
    }

    @GetMapping("/login")
    public String getLogin(){
        return "auth-login";
    }

    @PostMapping("/login")
    public String postLogin(@Valid @ModelAttribute(name = "userLoginDTO") UserLoginDTO userLoginDTO,
                            BindingResult bindingResult,RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userLoginDTO",userLoginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO",bindingResult);
            return "redirect:login";
        }

        UserDTO userToLogin =  this.userService.login(userLoginDTO);

        if (userToLogin.getId() == null){
            return "redirect:login";
        }

        return "index";

    }

    @ModelAttribute(name = "userLoginDTO")
    public UserLoginDTO userLoginDTO(){
        return new UserLoginDTO();
    }


    @PostMapping("/logout")
    public String logout(){
        this.userService.logout();
        return "index";
    }

}
