package com.example.mobilelele.services.impl;

import com.example.mobilelele.models.dtos.model.UserRoleDTO;
import com.example.mobilelele.models.dtos.view.UserRoleViewDTO;
import com.example.mobilelele.models.entites.UserRole;
import com.example.mobilelele.models.enums.Role;
import com.example.mobilelele.repositories.UserRoleRepository;
import com.example.mobilelele.services.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository, ModelMapper modelMapper) {
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
        this.imported();
    }

    @Override
    public boolean areImported() {
        return this.userRoleRepository.count() > 0;
    }

    @Override
    public void imported() {
        if (!areImported()){
            List<UserRole> roles = new ArrayList<>();

            roles.add(new UserRole().setRole(Role.USER));
            roles.add(new UserRole().setRole(Role.ADMIN));

            this.userRoleRepository.saveAllAndFlush(roles);
        }
    }

    @Override
    public List<UserRoleViewDTO> getAll() {
        return this.userRoleRepository.findAll()
                .stream()
                .map(r -> this.modelMapper.map(r, UserRoleViewDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserRoleDTO> findAllRoles() {
      return this.userRoleRepository.findAll()
              .stream()
              .map(r -> this.modelMapper.map(r,UserRoleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserRoleDTO findRoleByName(String name) {
     return this.modelMapper.map(this.userRoleRepository.findByRole(Role.valueOf(name))
               .orElseThrow(NoSuchElementException::new),
               UserRoleDTO.class);
    }


}
