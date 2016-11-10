package com.nixsolutions.spring.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nixsolutions.spring.model.db.entity.Role;
import com.nixsolutions.spring.model.service.UserServ;


@Service
public class CustomUserDetailsService  implements UserDetailsService{
	@Autowired
	UserServ userServ;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.nixsolutions.spring.model.db.entity.User user = 
				new com.nixsolutions.spring.model.db.entity.User(username);
		user = userServ.findRecordByLogin(user);
		
		if (user != null) {
			List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
			for (Role role : user.getRoles())
				auth.add(new SimpleGrantedAuthority(role.getName()));
			return new User(user.getNickname(), user.getPassword(), true, true, true, true, auth);
		} else throw new UsernameNotFoundException("Username undefined");
	}

}
