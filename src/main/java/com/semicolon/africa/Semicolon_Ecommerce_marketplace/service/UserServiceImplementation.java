package com.semicolon.africa.Semicolon_Ecommerce_marketplace.service;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.User;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.repositories.UserRepository;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.UserLoginRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.UserRegisterRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.UserLoginResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.UserRegisterResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.exception.EmailAlreadyExist;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.exception.EmailOrPasswordDoesNotExist;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static com.semicolon.africa.Semicolon_Ecommerce_marketplace.utils.Mapper.map;
import static com.semicolon.africa.Semicolon_Ecommerce_marketplace.utils.Mapper.mapLogin;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserRegisterResponse registerUser(UserRegisterRequest userRegisterRequest) {
        validateExistingEmail(userRegisterRequest.getEmail());
        User user = new User();
        map(userRegisterRequest, user);
        userRepository.save(user);
        return map(user);
    }

    private void validateExistingEmail(String email) {
        boolean existByEmail = userRepository.existsByEmail(email);
        if (existByEmail) throw new EmailAlreadyExist("Email Already Exist");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserLoginResponse loginUser(UserLoginRequest userLogin) {
        User user = findByEmail(userLogin.getEmail());
        validatingPassword(userLogin.getPassword());
        mapLogin(user);
        user.setLoggedIn(true);
        userRepository.save(user);
        return mapLogin(user);
    }

    private User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow( () -> new UserNotFoundException("User does not exist"));
    }

    private void validatingPassword(String password) throws NoSuchAlgorithmException {
//        MessageDigest pass = MessageDigest.getInstance("MD5");
//        pass.update(password.getBytes());
//        byte[] digest = pass.digest();
//        String hash = DatatypeConverter.printHaxBinary(digest).toUpperCase();
//        return hash;
        boolean validatePassword = userRepository.validatePassword(password);
        if (!validatePassword) throw new EmailOrPasswordDoesNotExist("Email and Password is Wrong or Does not Exist");
        return ;
}
