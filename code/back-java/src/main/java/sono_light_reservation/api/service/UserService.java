package sono_light_reservation.api.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.UserDto;
import sono_light_reservation.api.entity.User;
import sono_light_reservation.api.repository.UserRepository;
import sono_light_reservation.api.service.mapper.UserMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    /**
     * Read the details of the user get by id
     * @param id
     * @return userDto
     */
    public Optional<UserDto> getUser(final int id) {
        Optional<User> user = userRepository.findById(id);
        UserDto userDto = userMapper.convertToDto(user);
        return Optional.of(userDto);
    }

    /**
     * List of all the users
     * @return the list of the usersDto
     */
    public List<UserDto> getUsers() {
        return ((List<User>) userRepository.findAll()).stream().map(user -> userMapper.convertToDto(Optional.ofNullable(user))).collect(Collectors.toList());
    }

    public UserDto saveUser(UserDto userDto) {
        if (userDto.getLevel() == null){
            userDto.setLevel(3);  //1=superAdmin, 2=admin, 3=user
        }
        User user = userMapper.convertToEntity(userDto);
        userRepository.save(user);
        return userMapper.convertToDto(Optional.of(user));
    }

    /**
     * Delete existant user
     * @param id
     * @return String messsage : confirm of the suppression
     */
    public String deleteUser(final int id){
        userRepository.deleteById(id);
        if (userRepository.findById(id).isEmpty()) {
            return "User deleted";
        } else {
            return "Erreur dans la suppression";
        }
    }

    /**
     /**
     * Update the details of the user get by id
     * @param id
     * @param updatedUserDto
     * @return userDto with modifications
     */
    public UserDto updateUser(int id, UserDto updatedUserDto) {

        User user = userRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("Id user invalide:" + id));

       if (updatedUserDto.getFirstname() != null) {
           user.setFirstname(updatedUserDto.getFirstname());
       }
       if (updatedUserDto.getName() != null ) {
           user.setName(updatedUserDto.getName());
       }
       if (updatedUserDto.getEmail() != null ) {
           user.setEmail(updatedUserDto.getEmail());
       }
       if (updatedUserDto.getPhone() != null ) {
           user.setPhone(updatedUserDto.getPhone());
       }
        if (updatedUserDto.getAddress() != null ) {
            user.setPhone(updatedUserDto.getAddress());
        }
       if (updatedUserDto.getLevel() != null ) {
           user.setLevel(updatedUserDto.getLevel());
       }
       return userMapper.convertToDto(Optional.of(userRepository.save(user)));
    }
}
