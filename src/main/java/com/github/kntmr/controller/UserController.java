package com.github.kntmr.controller;

import com.github.kntmr.entity.User;
import com.github.kntmr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> get() {
        return userService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public User get(@PathVariable long id) {
        return userService.find(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User insert(@ModelAttribute User user) {
        return userService.insert(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public User update(@PathVariable long id, @ModelAttribute User user) {
        return userService.update(id, user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public int delete(@PathVariable long id) {
        return userService.delete(id);
    }

}
