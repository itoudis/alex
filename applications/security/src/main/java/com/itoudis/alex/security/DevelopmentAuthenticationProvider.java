package com.itoudis.alex.security;

import com.itoudis.alex.configuration.DefaultUsers;
import com.itoudis.alex.model.AlexUserDetails;
import com.itoudis.alex.model.AuthenticatedToken;
import com.itoudis.alex.model.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class DevelopmentAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // TODO burada getName nasıl çalışıyor?
        //  Birden fazla alan gerekli olursa nasıl çalışır?
        String username = authentication.getName();
        User user = DefaultUsers.getDefaultUsers().stream().filter(defUser -> defUser.getUsername().equals(username)).findFirst().orElseThrow(() -> new RuntimeException("User not found!"));
        UserDetails userDetails = new AlexUserDetails(user);
        return new AuthenticatedToken(userDetails);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
