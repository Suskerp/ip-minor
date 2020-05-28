package be.ucll.todolist.model.service;

import be.ucll.todolist.model.DTO.CreateUserDTO;
import be.ucll.todolist.model.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	UserDTO createUser(CreateUserDTO userDTO);
}
