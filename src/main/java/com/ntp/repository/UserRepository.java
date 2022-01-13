/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.repository;

import com.ntp.pojos.User;
import java.util.List;

/**
 *
 * @author Phat Nguyen
 */
public interface UserRepository {
    boolean addUser(User user);
    List<User> getUsers(String username);
    User getUserById(int id);
}
