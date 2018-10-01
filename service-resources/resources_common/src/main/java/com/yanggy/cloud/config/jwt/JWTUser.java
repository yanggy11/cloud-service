package com.yanggy.cloud.config.jwt;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * Created by yangguiyun on 2017/9/26.
 */
public class JWTUser implements UserDetails {
    
	private static final long serialVersionUID = -8265778093676125189L;
	private long userId;
    private  String username;
    private  String password;
    private  String email;
    private  String phone;
    private  String avater;
    private Collection<? extends GrantedAuthority> authorities;
    private  Date lastPasswordResetDate;
    public JWTUser(
            long id,
            String username,
            String password,
            String email,
            Collection<? extends GrantedAuthority> authorities,
            Date lastPasswordResetDate,
            String avater) {
        this.userId = id;
        this.username = username;
        this.password = password;
        this.setEmail(email);
        this.authorities = authorities;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.avater = avater;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }

    public String getAvater() {
        return avater;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
