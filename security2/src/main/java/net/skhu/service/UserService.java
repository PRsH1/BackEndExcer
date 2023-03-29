package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import net.skhu.dto.User;
import net.skhu.model.UserSignUp;
import net.skhu.mapper.UserMapper;

@Service
public class UserService {

    @Autowired UserMapper userRepository;
    @Autowired PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public boolean hasErrors(UserSignUp userSignUp, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return true;
        if (!userSignUp.getPasswd1().equals(userSignUp.getPasswd2())) {
            bindingResult.rejectValue("passwd2", null, "비밀번호가 일치하지 않습니다.");
            return true;
        }
        User user = userRepository.findByLoginName(userSignUp.getLoginName());
        if (user != null) {
            bindingResult.rejectValue("loginName", null, "사용자 아이디가 중복됩니다.");
            return true;
        }
        return false;
    }


    public User createEntity(UserSignUp userSignUp) {
        User user = new User();
        user.setLoginName(userSignUp.getLoginName());
        user.setPassword(passwordEncoder.encode(userSignUp.getPasswd1()));
        user.setName(userSignUp.getName());
        user.setEmail(userSignUp.getEmail());
        user.setEnabled(true);
        user.setUserType(userSignUp.getUserType());
        user.setDepartmentId(4);
        return user;
    }

    public void save(UserSignUp userSignUp) {
        User user = createEntity(userSignUp);
        userRepository.insertUser(user);
    }
    
}
