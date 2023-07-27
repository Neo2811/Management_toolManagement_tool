package am.hitech.service.impl;

import am.hitech.model.User;
import am.hitech.model.dto.request.UserRequestDto;
import am.hitech.repository.UserRepository;
import am.hitech.service.UserService;
import am.hitech.util.ErrorMessage;
import am.hitech.util.exception.DuplicateException;
import am.hitech.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(int id) throws NotFoundException {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new NotFoundException("User not found for id = " + id);
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> list = userRepository.findAll();
        return list;
    }

    @Override
    public User getByUserName(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }


    @Override
    public void create(UserRequestDto requestDto) throws DuplicateException {
        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new DuplicateException(ErrorMessage.DUPLICATE_EMAIL);
        }
        User user = convertToUser(requestDto, new User());
        userRepository.save(user);
    }


    private User convertToUser(UserRequestDto requestDto, User user) {
        user.setFirstName(requestDto.getFirstName());
        user.setLastName(requestDto.getLastName());
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());
        user.setStatus(requestDto.getStatus());
        user.setRole(requestDto.getRole());

        return user;
    }
}
