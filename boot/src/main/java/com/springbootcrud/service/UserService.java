package com.springbootcrud.service;

import com.springbootcrud.exception.UserNotFounExceptiom;
import com.springbootcrud.user.User;
import com.springbootcrud.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository rep;

    public List<User> listAll(){
        return (List<User>) rep.findAll();
    }

    public void save(User user) {
        rep.save(user);
    }

    public User getById(Integer id) throws UserNotFounExceptiom {
        Optional<User> result = rep.findById(id);
        if (result.isPresent()){
            return result.get();
        } throw new UserNotFounExceptiom("Not Fount User With Id" + id);
    }

    public void delete(Integer id) throws UserNotFounExceptiom {
        Long count = rep.countById(id);
        if (count == null || count == 0){
            throw new UserNotFounExceptiom("Not Fount User With Id" + id);
        }
        rep.deleteById(id);
    }
}
