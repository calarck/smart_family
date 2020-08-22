package com.example.family.user.dto;

import lombok.Data;

@Data
public class UserInfoDto {
    private Long userId;

    private String userName;

    private String userPhone;

    private Long loginDate;

    public UserInfoDto(Long userId, String userName, String userPhone, Long loginDate) {
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.loginDate = loginDate;
    }
}
