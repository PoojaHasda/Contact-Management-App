package com.contactmanager.contact.Entities;

import java.util.*;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
        @Id
        private String userID;

        @Column(name = "user_name",nullable = false)
        private String name;

        @Column(unique = true, nullable = false)
        private String email;
        private String password;
       
        @Column(length = 1000)
        private String about;
        @Column(length = 1000)
        private String profileLink; 
        @Column(name = "phone_number")
        private String phoneNumber;

         @Getter(value = AccessLevel.NONE)
        // information
        private boolean enabled = false;
        private boolean emailVerified = false;
        private boolean phoneVerified = false; 

        @Enumerated(value = EnumType.STRING)
        // signup --> SELF, GOOGLE, FACEBOOK, TWITTER, LINKEDIN, GITHUB
        private Provider provider = Provider.SELF;
        private String providerID;

        // add more fields if needed
         
        @OneToMany (mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
        private List<Contact> contacts = new ArrayList<>();

       
        private String emailToken; 


        public boolean isEnabled() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
        }


}
