package sono_light_reservation.api.service.mapper;

import lombok.Data;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.UserDto;
import sono_light_reservation.api.entity.User;

import java.util.Optional;

@Data
@Service
public class UserMapper {

    /**
     * Convert user information to DTO , for  userController
     * @param user
     * @return userDto
     */
    public UserDto convertToDto(Optional<User> user) {
        return new UserDto(user.get().getUser_id(), user.get().getFirstname(), user.get().getName(), user.get().getEmail(), user.get().getPhone(), user.get().getAddress(), user.get().getLevel());
    }

    /**
     * Convert user information to entity , for userRepository
     * @param userDto
     * @return user
     */
    public User convertToEntity(UserDto userDto) {
        User user = new User();
        user.setFirstname(userDto.getFirstname());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setAddress(userDto.getAddress());
        user.setLevel(userDto.getLevel());
        return user;
    }


}
