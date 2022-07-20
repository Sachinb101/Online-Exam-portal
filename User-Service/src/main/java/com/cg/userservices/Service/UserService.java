package com.cg.userservices.Service;

import java.util.List;


import com.cg.userservices.entity.User;
import com.cg.userservices.exception.NoProperDataException;
import com.cg.userservices.exception.UserNotFoundException;



public interface UserService {
	public List<User> getAllUsers() throws  UserNotFoundException;
    public User addUser(User user)  throws NoProperDataException;
    public String updateUser(User user) throws UserNotFoundException;
    public String deleteUser(Integer id) throws UserNotFoundException;
    public User getUserById(Integer id) throws UserNotFoundException;
}