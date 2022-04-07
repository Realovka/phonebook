package by.company.phonebook.service.mapper.impl;

import by.company.phonebook.service.dto.UserDto;
import by.company.phonebook.entity.User;
import by.company.phonebook.service.mapper.Mapper;

public class UserMapperImpl implements Mapper<User, UserDto> {

    private UserMapperImpl() {
    }

    private static UserMapperImpl instance = new UserMapperImpl();

    public static UserMapperImpl getInstance() {
        return instance;
    }

    @Override
    public User mapToEntity(UserDto userDto) {
        return new User.Builder()
                .setFirstName(userDto.getFirstName())
                .setLastName(userDto.getLastName())
                .setEmail(userDto.getEmail())
                .setRoles(userDto.getRoles())
                .setTelephone(userDto.getTelephones())
                .build();
    }

    @Override
    public UserDto mapToDto(User user) {
        return new UserDto.Builder()
                .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setRoles(user.getRoles())
                .setTelephones(user.getTelephones())
                .build();
    }
}
