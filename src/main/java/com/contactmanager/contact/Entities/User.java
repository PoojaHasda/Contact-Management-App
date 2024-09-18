package com.contactmanager.contact.Entities;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {
        @Id
        private String userID;

        @Column(name = "user_name", nullable = false)
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
        private boolean enabled = true;
        private boolean emailVerified = false;
        private boolean phoneVerified = false;

        @Enumerated(value = EnumType.STRING)
        // signup --> SELF, GOOGLE, FACEBOOK, TWITTER, LINKEDIN, GITHUB
        private Provider provider = Provider.SELF;
        private String providerID;

        // add more fields if needed

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
        private List<Contact> contacts = new ArrayList<>();

        private String emailToken;

        @Override
        public boolean isEnabled() {
                // TODO Auto-generated method stub
                return this.enabled;
        }


        @ElementCollection(fetch = FetchType.EAGER)
        private List<String> roleList = new ArrayList<>();

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                // TODO Auto-generated method stub

                // list of roles[USER,ADMIN]
                // collection of SimpleGranted Authority[roles{ADMIN,USER}]
                Collection<SimpleGrantedAuthority> roles = roleList.stream().map(role-> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
         return roles;
        }

        @Override
        public String getUsername() {
                // TODO Auto-generated method stub
                return this.email;
        }

        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        // @Override
        // public boolean isEnabled(){
        // return this.enabled;
        // }

}
