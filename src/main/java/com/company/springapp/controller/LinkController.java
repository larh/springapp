package com.company.springapp.controller;

import java.util.Collection;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {
	
	static Logger logger = LoggerFactory.getLogger(LinkController.class);
	
	@RequestMapping(value="/")
	public ModelAndView mainPage() {
		Collection<GrantedAuthority> authorities = getAuthorities();
        String rolename;
        String pagePrincipal = "home-user";
        
        for (GrantedAuthority authority : authorities) {
            rolename = authority.getAuthority();
            
            if (rolename.equals("ROLE_ADMIN")) {
                logger.debug("Directing to home page for: [" + rolename + "]");
                pagePrincipal = "home-admin";
            }
            if (rolename.equals("ROLE_TRADER")) {
                logger.debug("Directing to home page for: [" + rolename + "]");
                pagePrincipal = "home-trader";
            }
            if (rolename.equals("ROLE_USER")) {
                logger.debug("Directing to home page for: [" + rolename + "]");
                pagePrincipal = "home-user";
            }
        }
                
		return new ModelAndView(pagePrincipal);
	}

	@RequestMapping(value="/index")
	public String indexPage() {
//		return new ModelAndView("index");
		return "redirect:/";
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	private Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        return authorities;
    }
}
