package com.aklil.gswebsecurity.security;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findTopByEmail(String email);
}
