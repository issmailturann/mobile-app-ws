package app.worklib.web.ws.ui.controller;

import app.worklib.web.ws.ui.model.request.UpdateUserDetailsRequestModel;
import app.worklib.web.ws.ui.model.request.UserDetailsRequestModel;
import app.worklib.web.ws.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

    Map<String, UserRest> users;

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "1") int limit,
                           @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort){

        return "get user was called page " + page + " Limit: "+ limit + "Sort: " + sort;
    }
    @GetMapping(path= "/{userId}",
            consumes = MediaType.ALL_VALUE,
            produces = {
                MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
                })

    public ResponseEntity<UserRest> getUser(@PathVariable String userId){

      if (users.containsKey(userId)){
          return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);

      }else {
          return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
      }


    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    },produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){

        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path= "/{userId}", consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    },produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails){

        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        users.put(userId,storedUserDetails);

        return storedUserDetails;
    }

    @DeleteMapping(path= "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){

        users.remove(userId);

        return ResponseEntity.noContent().build();


    }
}
















