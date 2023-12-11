package com.itoudis.alex.application.service;

import com.itoudis.alex.configuration.DefaultUsers;
import com.itoudis.alex.model.AlexUserDetails;
import com.itoudis.alex.model.DevelopmentToken;
import com.itoudis.alex.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UserService {

    private AuthenticationManager authenticationManager;
    private SecurityContextRepository securityContextRepository;


    public void login(String username){
        Authentication token = authenticationManager.authenticate(new DevelopmentToken(username));
        SecurityContextHolder.getContext().setAuthentication(token);
        saveContext();
    }

    private void saveContext() {
        if (RequestContextHolder.getRequestAttributes() != null) {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                HttpServletRequest request = attributes.getRequest();
                HttpServletResponse response = attributes.getResponse();
                securityContextRepository.saveContext(SecurityContextHolder.getContext(), request, response);
            }
        }
    }

    public User getLoggedInUser() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof String) {
            return null;
        }

        AlexUserDetails userDetails =
                (AlexUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return DefaultUsers.getDefaultUsers().stream()
                .filter(user -> user.getUsername().equals(userDetails.getUsername()))
                .findFirst()
                .orElse(null);
    }


}
