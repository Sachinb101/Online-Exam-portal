package com.cg.userservices.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.userservices.ServiceImpl.SequenceGeneratorService;
import com.cg.userservices.ServiceImpl.UserServiceImpl;
import com.cg.userservices.entity.User;
import com.cg.userservices.exception.NoProperDataException;
import com.cg.userservices.exception.UserNotFoundException;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(("localhost:3000"))
@RestController
@Slf4j
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	@GetMapping("/allusers")  //users/admin
    public ResponseEntity<List<User>> getAllUsers() throws UserNotFoundException {
        //productserviceimpl.getAllProducts();
        return new  ResponseEntity<>(userServiceImpl.getAllUsers(),HttpStatus.OK);
    }
	//admin/users 
	 @GetMapping("/getuser/{id}") 
     public ResponseEntity<User> getUserById(@PathVariable Integer id) throws UserNotFoundException {
		 User user= userServiceImpl.getUserById(id);
         return ResponseEntity.ok().body(user);
     }
    @PostMapping("/addUser")  //only admin
    public ResponseEntity<User> addUser(@RequestBody User user) throws NoProperDataException {
    	user.setUserid(sequenceGeneratorService.getSequenceNumberForUser(User.SEQUENCE_NAME));
         //productserviceimpl.addProduct(product);
         return new ResponseEntity<>(userServiceImpl.addUser(user),HttpStatus.CREATED);
    }
    @PutMapping("/updateuser/{id}") // admin only @PutMapping("/updateproduct/{id}")
	public String updateUser(@Validated @RequestBody User user)
			throws UserNotFoundException {
		String use=userServiceImpl.updateUser(user);
		return use;
	}
    @DeleteMapping("/deleteuser/{id}")  //only delete
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) throws UserNotFoundException {
    	userServiceImpl.deleteUser(id);
         return ResponseEntity.ok(id+" deleted successfully");
    }  
}