package be.ucll.todolist.model.service;

import be.ucll.todolist.model.UserRole;
import be.ucll.todolist.model.DTO.CreateUserDTO;
import be.ucll.todolist.model.DTO.UserDTO;
import be.ucll.todolist.model.Repository.UserRepository;
import be.ucll.todolist.model.domain.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;

		User user = new User();
		user.setUsername("admin");
		user.setPassword(passwordEncoder.encode("t"));
		user.setRole(UserRole.ADMIN);
		repository.save(user);

		User user1 = new User();
		user1.setUsername("user");
		user1.setPassword(passwordEncoder.encode("t"));
		user1.setRole(UserRole.MEMBER);
		repository.save(user1);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User does not exist");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name())));
	}

	@Override
	public UserDTO createUser(CreateUserDTO userDTO) {
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setRole(userDTO.getUsername().endsWith("a") ? UserRole.ADMIN : UserRole.MEMBER);
		user = repository.save(user);
		return convert(user);
	}

	private UserDTO convert(User user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setRole(user.getRole());
		return dto;
	}
}
