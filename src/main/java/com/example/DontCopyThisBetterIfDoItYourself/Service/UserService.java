package com.example.DontCopyThisBetterIfDoItYourself.Service;

import com.example.DontCopyThisBetterIfDoItYourself.Model.User;
import com.example.DontCopyThisBetterIfDoItYourself.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private TokenService tokenService;

    public UserService(UserRepository userRepo, TokenService tokenService) {
        this.userRepo = userRepo;
        this.tokenService = tokenService;
    }
    public User userRegistration(User user) {
        return userRepo.save(user);
    }

    public String userLogin(String userName, String password) {
        boolean foundUsers = existByEmail(userName);
        if(foundUsers) {
            User user = userRepo.getUserByUserName(userName);
            if(user.getUserPassword1().equals(password)) {
                return "{" +
                        "\"message\" :"+"Successfully logged in\",\n"+
                        "\"data\" :"+user+",\n"+
                        "\"UserName: " + user.getUserName() + "\n"+
                        "\"token: " + tokenService.createTokenFunction(user.getUserId())+ "\" "+
                        "}";
            }
        }
        return "{" +
                "\"message\":"+"Authentication Failed\",\n"+
                "}";
    }
    public Boolean  existByEmail(String email){
        Optional<User> usersObj = Optional.ofNullable(userRepo.getUserByUserName(email));
//        System.out.println(usersObj);
        if(!usersObj.isEmpty()){
            return true;
        }
        return false;
    }

    public User getUserById(int userId) {
        return userRepo.findById(userId).get();
    }
}
