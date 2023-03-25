package app.worklib.web.ws.ui.controller;

import app.worklib.web.ws.ui.model.response.UserRest;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {
    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "1") int limit,
                           @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort){

        return "get user was called page " + page + " Limit: "+ limit + "Sort: " + sort;
    }
    @GetMapping(path= "/{userId}",
            consumes = MediaType.ALL_VALUE,
            produces = {
                MediaType.APPLICATION_XML_VALUE, // XML GÖNDERİLDİĞİNDE ÇALIŞMIYOR
                MediaType.APPLICATION_JSON_VALUE
                })

    public UserRest getUser(@PathVariable String userId){

        UserRest returnValue = new UserRest();
        returnValue.setEmail("isafaturan@gmail.com");
        returnValue.setFirstName("ismail");
        returnValue.setLastName("Turan");
        returnValue.setUserId("123");

        return returnValue;
    }

    @PostMapping
    public String createUser(){
        return "create user was called";
    }

    @PutMapping
    public String updateUser(){
        return "Update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }
}
















