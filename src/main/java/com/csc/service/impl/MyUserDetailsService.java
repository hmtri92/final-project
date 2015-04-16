package com.csc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.csc.dao.AuthenticationDAO;
import com.csc.entities.Role;
import com.csc.entities.State;
import com.csc.entities.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	AuthenticationDAO authenticationDao;
	
	private static final Logger logger = Logger.getLogger("MyUserDetailsService");
	
	@Override
	public UserDetails loadUserByUsername(String loginId)
			throws UsernameNotFoundException {
		logger.info("Login id: " + loginId);
		
		User user = authenticationDao.getUserByLoginID(loginId) ;
		
		boolean enabled = (user.getState().getIdState() == State.ACTIVE);
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		List<GrantedAuthority> authorities = getAuthorities(user.getRole().getIdRole());
		
		return new org.springframework.security.core.userdetails.User(user.getId(),
				user.getPassword(), enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
	}

	private List<GrantedAuthority> getAuthorities(int idRole) {
		List<String> roles = getRoles(idRole);
		List<GrantedAuthority> authList = getGrantedAuthorities(roles);
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