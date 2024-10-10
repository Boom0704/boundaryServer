package boundaryServer.boundaryServer.repository;

import boundaryServer.boundaryServer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class OracleUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OracleUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 유저 등록 (회원가입)
    @Override
    public User regist(User user) {
        String sql = "INSERT INTO users (username, email, profile_picture_url, bio, website, gender, birthday, is_active, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                user.getUsername(),
                user.getEmail(),
                user.getProfilePictureUrl(),
                user.getBio(),
                user.getWebsite(),
                user.getGender(),
                user.getBirthday(),
                user.isActive(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
        return user;  // 실제로는 등록 후 생성된 ID를 반환해야 할 수 있습니다.
    }

    // ID로 유저 조회
    @Override
    public Optional<User> findById(Integer id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, new UserRowMapper()).stream().findFirst();
    }

    // 유저명으로 유저 조회
    @Override
    public Optional<User> findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        return jdbcTemplate.query(sql, new Object[]{username}, new UserRowMapper()).stream().findFirst();
    }

    // 모든 유저 조회
    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    // 유저 RowMapper
    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setProfilePictureUrl(rs.getString("profile_picture_url"));
            user.setBio(rs.getString("bio"));
            user.setWebsite(rs.getString("website"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getString("birthday"));
            user.setActive(rs.getBoolean("is_active"));
            user.setCreatedAt(rs.getDate("created_at"));
            user.setUpdatedAt(rs.getDate("updated_at"));
            return user;
        }
    }
}
