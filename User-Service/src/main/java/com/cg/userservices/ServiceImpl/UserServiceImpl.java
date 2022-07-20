package com.cg.userservices.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.userservices.Repository.UserRepository;
import com.cg.userservices.Service.UserService;
import com.cg.userservices.entity.User;
import com.cg.userservices.exception.NoProperDataException;
import com.cg.userservices.exception.UserNotFoundException;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;{
	}
	
	@Override
	public List<User> getAllUsers() throws UserNotFoundException {
		// TODO Auto-generated method stub
		log.info("get all users  from here");
        if (userRepository.findAll().isEmpty()) {
            throw new UserNotFoundException("No User Found");
        } else {
            return userRepository.findAll();
        }
    }
	

	@Override
	public User addUser(User user) throws NoProperDataException {
		// TODO Auto-generated method stub
		User users = userRepository.save(user);
	        if (users == null) {
	            throw new NoProperDataException("Please fill fields");
	        }
	        return users;
	    }

	@Override
	public String updateUser(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> users=userRepository.findById(user.getUserid());
		User use=null;
		if(!users.isPresent()) {
			log.debug("user not found");
			throw new UserNotFoundException("User with the id "+user.getUserid()+" doesn't exist for update");
			
		}else {
			use=users.get();
			use.setUserid(user.getUserid());
			use.setUname(user.getUname());
			use.setPassword(user.getPassword());
			use.setAdmin(user.isAdmin());
			use.setAddress(user.getAddress());
			use.setGender(user.getGender());
			log.debug("updated successfully {}",use);
		}
		
		return use+ "\n updated successfully....";
	}
//	@Override
//	public User updateUser(User user, Integer id) throws UserNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("update");
//		User  users = userRepository.findById(id)
//	              .orElseThrow(() -> new UserNotFoundException("No user Available with this id"));
//		     users.setUserid(user.getUserid());
//		     users.setUname(user.getUname());
//		     users.setPassword(user.getPassword());
//		     users.setAdmin(user.isAdmin());
//		     users.setAddress(user.getAddress());
//		     users.setGender(user.getGender());
//	      final User updateduser = userRepository.save(users);
//	      return updateduser;
//	      // ResponseEntity.ok(updatedProduct);
//	  }

	

	@Override
	public String deleteUser(Integer id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		log.info("delete By Id");
        var isRemoved = userRepository.findById(id);
        if (isRemoved.isPresent()) {
        	userRepository.deleteById(id);
            log.debug("deleted succesfully {}", isRemoved.get());
        } else {
            throw new UserNotFoundException("User not available to delete on given id");
        }
        log.info("end");
        return "deleted";
	}

	@Override
	public User getUserById(Integer id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found with id " + id));
        return user;
        // ResponseEntity.ok().body(lo);
        // getById id takes only id has input (it will not take object Product product)

    }
	}

//	@Override
//	public ResponseEntity<List<User>> getAllUser() throws UserNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("get all user from here");
//		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity<User> getUserById(int id) throws UserNotFoundException {
//		// TODO Auto-generated method stub
//		User user = userRepository.findById(id)
//				.orElseThrow(() -> new UserNotFoundException("user Not Found" + id));
//
//		return ResponseEntity.ok().body(user);
//	}
//
//	@Override
//	public ResponseEntity<User> addUser(User user) throws NoProperDataException {
//		// TODO Auto-generated method stub
//		log.info("start");
//		if (user != null) {
//			userRepository.save(user);
//			System.out.println("user added");
//		} else {
//			throw new NoProperDataException("Please fill fields");
//		}
//		return ResponseEntity.ok(user);
//	}
//
//	@Override
//	public ResponseEntity<User> updateUser(User user, int id) throws UserNotFoundException {
//		// TODO Auto-generated method stub
//		User userdetails = userRepository.findById(id)
//				.orElseThrow(() -> new UserNotFoundException("user not available for this id: " + id));
//
//		userdetails.setUserid(user.getUserid());
//		userdetails.setUname(user.getUname());
//		userdetails.setPassword(user.getPassword());
//		userdetails.setAdmin(user.isAdmin());
//		userdetails.setAddress(user.getAddress());
//		userdetails.setGender(user.getGender());
//	    userdetails.setId(user.getId());
//
//		final User updatedUser = userRepository.save(userdetails);
//		return ResponseEntity.ok(updatedUser);
//	
//	}
//
//	@Override
//	public ResponseEntity<String> deleteUser(Integer id) throws UserNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("Start delete");
//		var isRemoved = userRepository.findById(id);
//		if (isRemoved.isPresent()) {
//			userRepository.deleteById(id);
//			log.debug("deleted successfully {}", isRemoved.get());
//		} else {
//			throw new UserNotFoundException("Id Not Available");
//		}
//		log.info(" deleted End");
//		return ResponseEntity.ok(id + " deleted successfully");
//	}
//	}
//
//

//	@Override
//	public ResponseEntity<List<User>> getAllUser() throws UserNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("get all user from here");
//		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity<User> getUserById(int id) throws UserNotFoundException {
//		// TODO Auto-generated method stub
//		User user = userRepository.findById(id)
//				.orElseThrow(() -> new UserNotFoundException("user Not Found" + id));
//
//		return ResponseEntity.ok().body(user);
//	}
//
//	@Override
//	public ResponseEntity<User> addUser(User user) throws NoProperDataException {
//		// TODO Auto-generated method stub
//		log.info("start");
//		if (user != null) {
//			userRepository.save(user);
//			System.out.println("user added");
//		} else {
//			throw new NoProperDataException("Please fill fields");
//		}
//		return ResponseEntity.ok(user);
//	}
//
//	@Override
//	public ResponseEntity<User> updateUser(User user, int id) throws UserNotFoundException {
//		// TODO Auto-generated method stub
//		User userdetails = userRepository.findById(id)
//				.orElseThrow(() -> new UserNotFoundException("user not available for this id: " + id));
//
//		userdetails.setUserid(user.getUserid());
//		userdetails.setUname(user.getUname());
//		userdetails.setPassword(user.getPassword());
//		userdetails.setAdmin(user.isAdmin());
//		userdetails.setAddress(user.getAddress());
//		userdetails.setGender(user.getGender());
//	    userdetails.setId(user.getId());
//
//		final User updatedUser = userRepository.save(userdetails);
//		return ResponseEntity.ok(updatedUser);
//	}
//
//	@Override
//	public ResponseEntity<String> deleteUser(Integer id) throws UserNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("Start delete");
//		var isRemoved = userRepository.findById(id);
//		if (isRemoved.isPresent()) {
//			userRepository.deleteById(id);
//			log.debug("deleted successfully {}", isRemoved.get());
//		} else {
//			throw new UserNotFoundException("Id Not Available");
//		}
//		log.info(" deleted End");
//		return ResponseEntity.ok(id + " deleted successfully");
//	}
//	}
