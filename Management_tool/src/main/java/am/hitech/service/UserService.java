package am.hitech.service;

import am.hitech.model.User;
import am.hitech.model.dto.request.UserRequestDto;
import am.hitech.util.exception.DuplicateException;
import am.hitech.util.exception.NotFoundException;

import java.util.List;

public interface UserService {

    User getById(int id) throws NotFoundException;

    List<User> getAll();

    User getByUserName(String email);

    void create(UserRequestDto requestDto) throws DuplicateException;
}
