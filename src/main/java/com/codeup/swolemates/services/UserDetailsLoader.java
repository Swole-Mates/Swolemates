package com.codeup.swolemates.services;

import com.codeup.swolemates.models.UserWithRoles;
import com.codeup.swolemates.repositories.UserRepo;
import com.codeup.swolemates.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepo userDao;

    public UserDetailsLoader(UserRepo users) {
        this.userDao = users;
    }

    @Override
    public UserWithRoles loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        return new UserWithRoles(user);
    }
}
