package com.example.family.user.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserInfoDto2 {

    private Integer userFdId;

    private String userName;

    private String userPhone;

    private String userImage;

    private Integer userType;

    private LocalDateTime updateTime;

    private Integer updatorId;

    private Integer isDelete;

    private String token;

}
