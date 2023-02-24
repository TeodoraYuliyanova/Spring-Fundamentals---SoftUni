package com.example.mobilelele.services;

import com.example.mobilelele.models.dtos.model.UserRoleDTO;
import com.example.mobilelele.models.dtos.view.UserRoleViewDTO;

import java.util.List;

public interface UserRoleService {

    boolean areImported();

    void imported();

    List<UserRoleViewDTO> getAll();

    List<UserRoleDTO> findAllRoles();

    UserRoleDTO findRoleByName(String name);


}
