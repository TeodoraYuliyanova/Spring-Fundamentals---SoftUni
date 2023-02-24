package com.example.mobilelele.services.impl;

import com.example.mobilelele.models.beans.LoggedUser;
import com.example.mobilelele.models.dtos.banding.UserLoginDTO;
import com.example.mobilelele.models.dtos.banding.UserRegisterDTO;
import com.example.mobilelele.models.dtos.model.UserDTO;
import com.example.mobilelele.models.entites.User;
import com.example.mobilelele.repositories.UserRepository;
import com.example.mobilelele.services.UserRoleService;
import com.example.mobilelele.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private UserRepository userRepository;

    private UserRoleService userRoleService;

    private LoggedUser loggedUser;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, UserRoleService userRoleService, LoggedUser loggedUser) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.loggedUser = loggedUser;
    }


    @Override
    public boolean areImported() {
        return this.userRepository.count() > 0;
    }


    @Override
    public UserDTO register(UserRegisterDTO userRegisterDTO) {
        UserDTO userDTO = this.modelMapper.map(userRegisterDTO, UserDTO.class);

        userDTO.setRole(this.userRepository.count() == 0
                ? this.userRoleService.findAllRoles()
                : List.of(this.userRoleService.findRoleByName("USER")));

        final User userToSave = this.modelMapper.map(userDTO, User.class);

        return this.modelMapper.map(this.userRepository.saveAndFlush(userToSave), UserDTO.class);
    }

    @Override
    public UserDTO login(UserLoginDTO userLoginDTO) {
        Optional<User> loginCandidate = this.userRepository.findByUsername(userLoginDTO.getUsername());

        UserDTO confirmedUser = loginCandidate.isPresent() &&
                loginCandidate.get().getPassword().equals(userLoginDTO.getPassword())
                ? this.modelMapper.map(loginCandidate.get(), UserDTO.class)
                : new UserDTO();

        if (confirmedUser.isValid()) {
            this.loggedUser
                    .setId(confirmedUser.getId())
                    .setUsername(confirmedUser.getUsername())
                    .setRoles(confirmedUser.getRole());
        }

        return confirmedUser;

    }

    @Override
    public void logout() {
        this.loggedUser.clearFields();
    }


}
