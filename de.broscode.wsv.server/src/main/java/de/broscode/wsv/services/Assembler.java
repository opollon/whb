package de.broscode.wsv.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import de.broscode.wsv.domain.user.Role;

public class Assembler {

  public static UserDetails buildUserFromUserEntity(de.broscode.wsv.domain.user.User userEntity) {

    String username = userEntity.getName();
    String password = userEntity.getPassword();
    boolean enabled = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;

    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    for (Role role : userEntity.getRollen()) {
      authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
    }

    User user = new User(username, password, enabled,
      accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    return user;
  }
}