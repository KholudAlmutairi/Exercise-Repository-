package com.example.exerciserepository.Repository;

import com.example.exerciserepository.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
User findUserById(Integer id);
User findUserByEmail(String email);
List<User> findUserByRole(String role);
@Query("select u from User u where u.age>=?1 ")
List<User>pleasFindBYUser(Integer age);

User findUserByUsername(String username);


//• Get user by email
//• Get All users with specific role
//• Get All users with specific age or above
//• Check if username and password are correct


}
