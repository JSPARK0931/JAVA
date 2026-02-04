package com.study.spring.member.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.study.spring.member.entity.MemberRole;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberDto extends User {

	private String email;
	private String pw;
	private String nickname;
	private boolean social;
//	private List<MemberRole> memberRoleList = new ArrayList<>();
	private List<String> roleNames = new ArrayList<>();
	
	public MemberDto(String email, String pw, String nickname, boolean social, List<String> roleNames ) {
		// super : User에서 상속받음 : 
		// super(username, password, authorities);
		super(email, pw, roleNames.stream()
				.map(str -> new SimpleGrantedAuthority("Role_"+str)).collect(Collectors.toList()));
		
		this.email = email;
		this.pw = pw;
		this.nickname = nickname;
		this.social = social;
		this.roleNames = roleNames;
	}
}
