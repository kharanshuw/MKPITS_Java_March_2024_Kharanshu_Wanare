package com.bankapplication.auditconfig;

import org.springframework.data.domain.AuditorAware;

import com.bankapplication.model.User;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class ApplicationAudit implements AuditorAware<Integer> {



    @Override
    public Optional<Integer> getCurrentAuditor() {

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();


        //if this user is not authenticated or is anonymous then return null for audition entry
        if (authentication == null ||
                !authentication.isAuthenticated()
                || authentication instanceof AnonymousAuthenticationToken
        )
        {
            return Optional.empty();
        }
               
        
        User userPrincipal = (User) authentication.getPrincipal();



        return Optional.ofNullable(userPrincipal.getId());
    }
    
    
    
}