package com.example.exerciserepository.Controller;

import com.example.exerciserepository.ApiResponse.ApiException;
import com.example.exerciserepository.ApiResponse.ApiResponse;
import com.example.exerciserepository.Model.User;
import com.example.exerciserepository.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers(){

        return ResponseEntity.status(200).body(userService.getAllUsers());}


    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
                String message=errors.getFieldError().getDefaultMessage();

                return ResponseEntity.status(400).body(message);

         }
            userService.addUser(user);
            return ResponseEntity.status(200).body(new ApiResponse("User Added"));

        }



    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user , Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);
        }

        userService.updateUser(id,user);
        return ResponseEntity.status(200).body(new ApiResponse( "User updated"));
    }


      @DeleteMapping("/delete/{id}")
      public ResponseEntity deleteUser(@PathVariable Integer id){
         userService.deleteUser(id);
         return ResponseEntity.status(200).body(new ApiResponse("User deleted!"));
        }


    @GetMapping("/searchByEmail/{email}")
    public  ResponseEntity searchByEmail (@PathVariable String email){

        return ResponseEntity.status(200).body(userService.searchByEmail(email));

    }

    @GetMapping("/searchByRole/{role}")
    public  ResponseEntity searchByRole (@PathVariable String role){

        return ResponseEntity.status(200).body(userService.searchByRole(role));}


    @GetMapping("/searchByAge/{age}")
    public  ResponseEntity searchByAge (@PathVariable Integer age){

        return ResponseEntity.status(200).body(userService.searchByAge(age));}



    // Check if username and password are correct

    @PostMapping("/authenticate/{username}/{password}")
    public ResponseEntity authenticateUser(@PathVariable String username, @PathVariable String password) {
        if (userService.authenticate(username, password)) {
            return ResponseEntity.status(200).body(new ApiResponse("Authentication successful!"));
        } else {
            return ResponseEntity.status(401).body(new ApiResponse("Authentication failed!"));
        }
    }









    }














