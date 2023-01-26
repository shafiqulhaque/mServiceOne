package com.mServiceOne.userservice.VO;

import com.mServiceOne.userservice.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVo {

    private Users users;
    private Department department;

}
