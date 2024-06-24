package CRUDApp.controller;

import CRUDApp.model.User;
import CRUDApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping( "/")
    public String printUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam("name")String name, @RequestParam("email")String email) {
        userService.insertUser(new User(name,email));
        return "redirect:/";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id")int id) {
        User user = userService.getUserById(id);
        if(user != null) {
            userService.deleteUser(user);
        }
        return "redirect:/";
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam("id") int id,@RequestParam("name")String name, @RequestParam("email")String email) {
        User user = userService.getUserById(id);
        user.setName(name);
        user.setEmail(email);
        userService.updateUser(id,new User(name,email));

        return "redirect:/";
    }

}
