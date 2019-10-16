package com.cpf.backend.user.service.imp;

import com.cpf.backend.common.entity.BusinessException;
import com.cpf.backend.user.entity.User;
import com.cpf.backend.user.service.UserTestService;
import org.springframework.stereotype.Service;

@Service
public class UserTestServiceImp implements UserTestService {

    @Override
    public User userTest(User user) {
        if (user.getAge()<18){
            throw BusinessException.throwBusinessException("BUS000001","未成年！");
        }
        return user;
    }
}
