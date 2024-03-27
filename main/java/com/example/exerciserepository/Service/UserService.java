package com.example.exerciserepository.Service;

import com.example.exerciserepository.ApiResponse.ApiException;
import com.example.exerciserepository.Model.User;
import com.example.exerciserepository.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {



    private final UserRepository userRepository;

    //• Get all the Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //• Add new User
    public void addUser(User user) {
        userRepository.save(user);
    }

    //• Update User
    public void updateUser(Integer id,User user) {
         User u=userRepository.findUserById(id);
        if (u == null) {
            throw new ApiException("Wrong id");
        }
    //User class: ID , name , username , password, email ,role, age
        u.setName(user.getName());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        u.setRole(user.getRole());
        u.setAge(user.getAge());
         userRepository.save(u);
        }


    //• Delete User
    public void deleteUser(Integer id) {
        User u=userRepository.findUserById(id);
        if (u == null) {
            throw new ApiException("Wrong id");
        }
        userRepository.delete(u);



    }

    //• Get user by email
    public User searchByEmail(String email){
        User user=userRepository.findUserByEmail(email);
        if (user == null) {
            throw new ApiException("Email not found");
        }
        return user;
    }

    //• Get All users with specific role
    public List<User> searchByRole(String role){
        List<User> users =userRepository.findUserByRole(role);
        if (users.isEmpty()) {
            throw new ApiException("Role not found");
        }
        return users;
    }

    //• Get All users with specific age or above
    public List<User> searchByAge(Integer age){
        List<User> users =userRepository.pleasFindBYUser(age);
        if (users.isEmpty()) {
            throw new ApiException("Age not found");
        }
        return users;
    }


    //• Check if username and password are correct
    public void authenticate(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new ApiException("username not found");
        }
        if (!password.equals(user.getPassword())) {
            throw new ApiException("incorrect password");
        }
    }








}
