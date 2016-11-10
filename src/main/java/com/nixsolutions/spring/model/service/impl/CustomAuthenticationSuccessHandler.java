package com.nixsolutions.spring.model.service.impl;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, 
			Authentication authentication) throws IOException, ServletException {
		
		Collection<? extends GrantedAuthority> auths = authentication.getAuthorities();
		if (auths.size() == 1) {
			for (GrantedAuthority authorities : auths) {
	            if (authorities.getAuthority().equals("Administrator")) {
	            	response.sendRedirect("admin_area");
	            } else if (authorities.getAuthority().equals("Director")) {
	            	response.sendRedirect("director_area");
	            } else {
	            	response.sendRedirect("client_area");
	            }
	        }
		} else {
			for (GrantedAuthority authorities : auths) {
				if (authorities.getAuthority().equals("Administrator")) {
					request.setAttribute("admin", true);
	            } else if (authorities.getAuthority().equals("Director")) {
	            	request.setAttribute("dir", true);
	            } else {
	            	request.setAttribute("client", true);
	            }
			}
			request.getRequestDispatcher("/WEB-INF/jsp/role.jsp").forward(request, response);
		}
	}

}
