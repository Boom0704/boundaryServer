package boundaryServer.boundaryServer.service;

import boundaryServer.boundaryServer.model.User;
import boundaryServer.boundaryServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 유저 조회 (ID로 조회)
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    // 유저 등록 (회원가입)
    public User registerUser(User user) {
        return userRepository.regist(user);
    }

    // 유저명으로 유저 조회
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // 유저 중복 체크
    public boolean isUserExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    // 유저 전부 가져오기
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
