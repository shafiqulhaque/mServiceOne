package com.mServiceOne.userservice.service;

import com.mServiceOne.userservice.VO.Department;
import com.mServiceOne.userservice.VO.ResponseTemplateVo;
import com.mServiceOne.userservice.entity.User;
import com.mServiceOne.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser from User Service");
        return userRepository.save(user);
    }

    public ResponseTemplateVo getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment from User Service");
        ResponseTemplateVo vo = new ResponseTemplateVo();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId() ,
                        Department.class);

        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
