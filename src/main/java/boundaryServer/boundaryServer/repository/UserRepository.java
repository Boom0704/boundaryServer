package boundaryServer.boundaryServer.repository;

import boundaryServer.boundaryServer.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User regist(User user);
    Optional <User> findById(Integer id);
    Optional <User> findByUsername(String username);
    List<User> findAll();
}
