package com.wyf.web.security;
import org.springframework.security.core.GrantedAuthority;

/**
 * 权限封装
 * @author Louis
 * @date Jun 29, 2019
 */
public class GrantedAuthorityImpl implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;

	private String authority;

	private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public GrantedAuthorityImpl(String authority, String role) {
        this.authority = authority;
        this.role = role;
    }

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}