package com.kerubinessys.v0.controller;

import com.kerubinessys.v0.model.Sale;
import com.kerubinessys.v0.model.UserApp;
import com.kerubinessys.v0.service.IUserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserAppController {

    @Autowired
    private IUserAppService userAppService;

    @GetMapping("/get")
    public List<UserApp> getUsers() {
        List<UserApp> userAppList = userAppService.getUser();
        return userAppList;
    }

    @GetMapping("/get/{id}")
    public String findUser(@PathVariable Long id){
        UserApp userApp = userAppService.findUser(id);
        if (userApp == null){
            return "The user with ID: " + id + " doesn't exits.";
        }
        return "The user with the ID: " + id + " is: " + userApp + ".";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userAppService.deleteUser(id);
        return "the user with ID: " + id + " was successfully deleted.";
    }

    @PostMapping("/create")
    public String saveUser(@RequestBody UserApp userApp){
        userAppService.saveUser(userApp);
        return "User was successfully created.";
    }

    @PutMapping("/edit/{id}")
    public UserApp editUserApp(@PathVariable Long id,
                               @RequestParam (required = false, name = "name") String name,
                               @RequestParam (required = false, name = "surname") String surname,
                               @RequestParam (required = false, name = "dni") String dni,
                               @RequestParam (required = false, name = "rol") String rol,
                               @RequestParam (required = false, name = "saleList")List<Sale> saleList){
        userAppService.editUser(id,name,surname,dni,rol,saleList);
        UserApp userApp = userAppService.findUser(id);
        return userApp;
    }

}
