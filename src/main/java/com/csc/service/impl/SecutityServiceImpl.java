package com.csc.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.csc.dao.AuthenticationDAO;
import com.csc.entities.Role;
import com.csc.entities.User;


public class SecutityServiceImpl implements UserDetailsService {

	@Autowired
	AuthenticationDAO authentication;
	
	@Override
	public UserDetails loadUserByUsername(String loginId)
			throws UsernameNotFoundException {
		User user = authentication.getUserByLoginID(loginId) ;
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		return new org.springframework.security.core.userdetails.User(user.getId(),
				user.getPassword(), enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked,
				getAuthorities(user.getRole().getIdRole()));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(int idRole) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(idRole));
		return authList;
	}

	private List<String> getRoles(int idRole) {
		
		List<String> roles = new ArrayList<String>();
		
		switch (idRole) {
		case Role.ADMIN:
			roles.add("ROLE_ADMIN");
			break;
		case Role.USER_SUPPORT:
			roles.add("USER_SUPPORT");
			break;
		case Role.CUSTOMER:
			roles.add("CUSTOMER");
			break;
		case Role.REPORT_SUPPORT:
			roles.add("REPORT_SUPPORT");
			break;
		case Role.ACCOUNT_SUPPORT:
			roles.add("ACCOUNT_SUPPORT");
			break;
		default:
			break;
		}
		
		return roles;
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new GrantedAuthorityImpl(role));
		}
		return authorities;
	}


}
