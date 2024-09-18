package com.contactmanager.contact.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
// import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.contactmanager.contact.Entities.User;
import com.contactmanager.contact.helper.AppConstants;
import com.contactmanager.contact.helper.ResourceNotFoundException;
import com.contactmanager.contact.services.UserServices;
import com.contactmanager.contact.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    // @Autowired
    // private EmailService emailService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // @Autowired
    // private  Helper helper;
    
    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserID(userId);
    
        user.setPassword(passwordEncoder.encode(user.getPassword()));

          user.setRoleList(List.of(AppConstants.ROLE_USER));

        logger.info(user.getProvider().toString());
        String emailToken = UUID.randomUUID().toString();
        user.setEmailToken(emailToken);
        User savedUser = userRepo.save(user);
    //     String emailLink = helper.getLinkForEmailVerificatiton(emailToken);
    //     emailService.sendEmail(savedUser.getEmail(), "Verify Account : Smart  Contact Manager", emailLink);
        return savedUser;
    }

    @Override
    public Optional<User> getUserById(String id) {
        // user id have to generate 
       
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {

        User user2 = userRepo.findById(user.getUserID())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        // update karenge user2 from user
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        // user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfileLink(user.getProfileLink());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProviderID(user.getProviderID());
        // save the user in database
        User save = userRepo.save(user2);
        return Optional.ofNullable(save);

    }

    @Override
    public void deleteUser(String id) {
        // TODO Auto-generated method stub
        User user2 = userRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepo.delete(user2);
}

    @Override
    public boolean isUserExist(String userId) {
        // TODO Auto-generated method stub
        User user2 = userRepo.findById(userId).orElse(null);
        return user2 != null ? true : false;    
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        // TODO Auto-generated method stub
        User user = userRepo.findByEmail(email).orElse(null);
        return user != null ? true : false;   }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return userRepo.findAll();
        }

    @Override
    public User getUserByEmail(String email) {
        // TODO Auto-generated method stub
        return userRepo.findByEmail(email).orElse(null);    }

        // @Override
        // public User getUserByEmail(String email) {
        //     return userRepo.findByEmail(email).orElse(null);
    
        // }
}
