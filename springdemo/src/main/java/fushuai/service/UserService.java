package fushuai.service;

import fushuai.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User login(String username, String password);
    void register(String username, String password);
}
