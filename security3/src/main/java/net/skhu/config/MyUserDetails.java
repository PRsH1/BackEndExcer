package net.skhu.config;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.Data;
import net.skhu.dto.User;

@Data
public class MyUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;

    final boolean accountNonExpired = true;
    final boolean accountNonLocked = true;
    final boolean credentialsNonExpired = true;
    final String password;
    final String username;
    final boolean isEnabled;
    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

    //Spring Security의 필수 요소 1
    //맴버 변수들의 Getter 존재해야 함
    
    final String name;
    final String email;
    final String userType;
    
   //Spring Security와는 무관하니 마음대로 수정해도 된다.

    public MyUserDetails(User user) {
    	//MyUserDetails 생성자 파라미터
    	//User 엔터티 객체
    	
        switch (user.getUserType()) {
        case "교수": authorities.add(new SimpleGrantedAuthority("ROLE_PROFESSOR")); break;
        case "학생": authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT")); break;
        case "관리자": authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN")); break;
        //authorities 객체는 현재 사용자의 권한 목록
        //사용자 권한은 ROLE_#### 형태로 만들어야 한다
        //(예: ROLE_ADMIN, ROLE_PROFESSOR,  ROLE_STUDENT, , ROLE_TA, ROLE_STAFF)
        /**
         *   다음과 같은 코드로 사용자 권한을 등록한다.
  			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
  			user 객체의 userType 속성 값이 "관리자"/"교수"/"학생"이면,
  			authorities 권한 목록에 ROLE_ADMIN/ROLE_PROFESSOR/ROLE_STUDENT 권한을 추가한다.


         */
        }
        this.username = user.getLoginName();
        this.password = user.getPassword();
        this.isEnabled = user.isEnabled();
        //필수 요소 2

        this.name = user.getName();
        this.email = user.getEmail();
        this.userType = user.getUserType();
        
        //Spring Security와는 무관하니 마음대로 수정해도 된다.
    }
}


