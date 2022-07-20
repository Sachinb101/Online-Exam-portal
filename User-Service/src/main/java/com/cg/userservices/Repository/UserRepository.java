package com.cg.userservices.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.userservices.entity.User;



@Repository
public interface UserRepository extends MongoRepository<User,Integer>{

}
