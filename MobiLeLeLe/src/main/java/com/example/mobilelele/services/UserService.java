package com.example.mobilelele.services;

import com.example.mobilelele.models.dtos.banding.UserLoginDTO;
import com.example.mobilelele.models.dtos.banding.UserRegisterDTO;
import com.example.mobilelele.models.dtos.model.UserDTO;
import com.example.mobilelele.models.entites.User;

public interface UserService {

    boolean areImported();
    UserDTO register(UserRegisterDTO userRegisterDTO);

    UserDTO login(UserLoginDTO userLoginDTO);

    void logout();
}
