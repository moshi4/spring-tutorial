package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

  @Autowired
  UserService userService;

  private Map<String, String> radioMarriage;

  private Map<String, String> initRadioMarriage() {
    Map<String, String> radio = new LinkedHashMap<>();

    radio.put("既婚", "true");
    radio.put("未婚", "false");

    return radio;
  }

  @GetMapping("/signup")
  public String getSignUp(@ModelAttribute SignupForm form, Model model) {
    radioMarriage = initRadioMarriage();
    model.addAttribute("radioMarriage", radioMarriage);
    return "login/signup";
  }

  @PostMapping("/signup")
  public String postSignup(@ModelAttribute @Validated SignupForm form, BindingResult bindingResult,
      Model model) {

    if (bindingResult.hasErrors()) {
      return getSignUp(form, model);
    }
    System.out.println(form);

    User user = new User();
    user.setUserId(form.getUserId());
    user.setPassword(form.getPassword());
    user.setUserName(form.getUserName());
    user.setBirthday(form.getBirthday());
    user.setAge(form.getAge());
    user.setMarriage(form.isMarriage());
    user.setRole("ROLE GENERAL");

    boolean result = userService.insert(user);

    if (result == true) {
      System.out.println("insert success");
    } else {
      System.out.println("insert failed");
    }

    return "redirect:/login";
  }
}
