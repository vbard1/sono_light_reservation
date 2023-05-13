package sono_light_reservation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sono_light_reservation.api.dto.UserDto;
import sono_light_reservation.api.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Read the details of the user get by id
     * @param id
     * @return userDto
     */
    @GetMapping("/User/{id}")
    public Optional<UserDto> getOneUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    /**
     * Update the details of the user get by id
     * @param id
     * @param updatedUserDto
     * @return userDto with modifications
     */
    @PutMapping("/User/{id}")
    public UserDto updateUser(@PathVariable int id, @RequestBody UserDto updatedUserDto) {
        return userService.updateUser(id, updatedUserDto);
    }

    /**
     * Delete existant user
     * @param id
     * @return String messsage : confirm of the suppression
     */
    @DeleteMapping("/User/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }


    /**
     * List of all the users
     * @return the list of the usersDto
     */
    @GetMapping("/User")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }


    /**
     * Create a new user
     * @param newUserDto
     * @return the details of the new userDto
     */
    @PostMapping("/User")
    public UserDto createUser(@RequestBody UserDto newUserDto) {
        return userService.saveUser(newUserDto);
    }
}
