package com.mServiceOne.userservice.service;

import com.mServiceOne.userservice.VO.Department;
import com.mServiceOne.userservice.VO.ResponseTemplateVo;
import com.mServiceOne.userservice.entity.Users;
import com.mServiceOne.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Users saveUsers(Users users) {
        log.info("Inside saveUser from User Service");
        return userRepository.save(users);
    }

    public ResponseTemplateVo getUsersWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment from User Service");
        ResponseTemplateVo vo = new ResponseTemplateVo();
        Users users = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + users.getDepartmentId() ,
                        Department.class);

        vo.setUsers(users);
        vo.setDepartment(department);
        return vo;
    }
}
