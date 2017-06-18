package com.wladek.newsfeed.service;

import com.wladek.newsfeed.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author wladek
 */
public class UserDetailsImpl implements UserDetails {

    private static final String ROLE_PREFIX = "ROLE_";

    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
//        roles.add(new SimpleGrantedAuthority(ROLE_PREFIX + user.getUserRole().name()));
        return roles;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
//        return user.getUserState() == UserState.ACTIVE;
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
//        return user.getUserState() != UserState.LOCKED;
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
//        return user.getUserState() == UserState.ACTIVE;
        return false;
    }

    public User getUser() {
        return user;
    }
}
