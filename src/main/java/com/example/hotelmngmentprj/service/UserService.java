package com.example.hotelmngmentprj.service;
import java.util.List;

import com.example.hotelmngmentprj.dto.Userdto;
import com.example.hotelmngmentprj.model.User;
public interface UserService {
	
	User insert(Userdto ud);

    List<User> getAll();

    User search(Long id);

    User searchByEmail(String email);
    
    void delete(Long id);
}
