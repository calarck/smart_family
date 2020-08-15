package com.example.family.user.dto;

import lombok.Data;

@Data
public class UserInfoDto {
    private Integer userId;

    private String userName;

    private String userPhone;

    private Long loginDate;

    public UserInfoDto(Integer userId, String userName, String userPhone, Long loginDate) {
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.loginDate = loginDate;
    }
}
