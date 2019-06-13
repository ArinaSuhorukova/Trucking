package by.itechart.server.service.impl;

import by.itechart.server.dto.UserDto;
import by.itechart.server.entity.User;
import by.itechart.server.repository.UserRepository;
import by.itechart.server.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(final UserDto user) {
        userRepository.save(user.transformToEntity());
    }

    @Override
    public Page<UserDto> findAll(final Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return new PageImpl<>(users.stream().map(User::transformToDto)
                .sorted(Comparator.comparing(UserDto::getSurname))
                .collect(Collectors.toList()), pageable, users.getTotalElements());
        }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(User::transformToDto).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(final int id) {
        return userRepository.findById(id).isPresent() ? userRepository.findById(id).get().transformToDto() : null;
    }

    @Override
    public void delete(final UserDto user) {
        userRepository.delete(user.transformToEntity());
    }

    @Override
    public void deleteById(final int id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean existsByLogin(final String login) {
        return userRepository.existsByLogin(login);
    }

    @Override
    public boolean existsByEmail(final String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public UserDto findByEmailIgnoreCase(final String email) {
        return userRepository.findByEmailIgnoreCase(email).transformToDto();
    }
}