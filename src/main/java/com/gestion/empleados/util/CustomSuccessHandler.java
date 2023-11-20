package com.gestion.empleados.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

	private RedirectStrategy redirect = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String URL=this.determineTargetUrl(authentication);
		if(response.isCommitted()) 
		{
			System.out.print("response has already been committed. ..." + URL);
			return;
		} 
		
		redirect.sendRedirect(request, response, URL);
	}
	
	public String determineTargetUrl(Authentication authentication) 
	{
		String targeURL=null;
		//coleccion vacia
		Collection<String> roles=new ArrayList<>();
		
		//coleccion cargada
		for(GrantedAuthority authority:authentication.getAuthorities()) 
		{
			roles.add(authority.getAuthority());
		}
		//verificar el rol
		if(roles.contains("ROLE_DBA")) {
			targeURL="/";
		}
		else if(roles.contains("ROLE_ADMIN")) {
			targeURL="/";
		}
		else if(roles.contains("ROLE_USER")) {
			targeURL= "/";
		}
		else {
			targeURL="/";
		}
		return targeURL;
	}

}
