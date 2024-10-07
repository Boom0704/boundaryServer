package boundaryServer.boundaryServer.repository;

import boundaryServer.boundaryServer.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryUserRepository implements UserRepository{
    private static Map<Integer, User> store = new HashMap<>();
    private static int sequence = 0;

    @Override
    public User regist(User user) {
        user.setId(++sequence);
        store.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return store.values().stream().filter(user -> user.getUsername().equals(username)).findAny();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }
    public void clearStore(){
        store.clear();
    }
    }
