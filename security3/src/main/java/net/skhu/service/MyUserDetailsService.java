package net.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import net.skhu.config.MyUserDetails;
import net.skhu.dto.User;
import net.skhu.mapper.UserMapper;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
   	 /**
         * 
         * username 로그인 네임으로 사용자를 조회해서
      	   앞에서 구현한 MyUserDetails 사용자 정보 객체를 만들어서 리턴해야 한다.
      	   만약 username 로그인 네임의 사용자를 찾을 수 없다면, UsernameNotFoundException 객체를 throw 한다.
      	   사용자가 로그인하려 할 때, Spring Security가 이 메소드를 호출하여 사용자 정보 객체를 구하고,
  			이 메소드가 리턴한 MyUserDetails 객체의 패스워드와, 입력된 패스워드를 비교해서
  			로그인 과정을 자동으로 처리해 준다.

    	
         * 
         */
        User user = userMapper.findByLoginName(username);
        if (user == null) throw new UsernameNotFoundException(username);
        return new MyUserDetails(user);
        //https://itstory.tk/entry/Spring-Security-%ED%98%84%EC%9E%AC-%EB%A1%9C%EA%B7%B8%EC%9D%B8%ED%95%9C-%EC%82%AC%EC%9A%A9%EC%9E%90-%EC%A0%95%EB%B3%B4-%EA%B0%80%EC%A0%B8%EC%98%A4%EA%B8%B0
        //현재 로그인한 사용자 정보 가져오기 참조
    }

}
