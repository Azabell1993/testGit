package com.azabellcode.blog.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;       // 닉네임
    private String username;
    private String password;
    private String emailLocalPart; // 이메일 주소의 로컬 파트
    private String emailDomain;    // 이메일 주소의 도메인
    private String customEmailDomain; // 직접 입력한 이메일 도메인
    private boolean enabled;

}
