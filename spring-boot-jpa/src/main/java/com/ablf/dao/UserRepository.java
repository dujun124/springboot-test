package com.ablf.dao;

import com.ablf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by du on 2019/2/20.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
