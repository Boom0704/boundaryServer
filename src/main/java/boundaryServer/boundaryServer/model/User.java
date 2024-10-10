package boundaryServer.boundaryServer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String email;
    private String profilePictureUrl;
    private String bio;
    private String website;
    private String gender;
    private String birthday;

    @Enumerated(EnumType.STRING)
    private ProfileVisibility visibility;

    private boolean isActive;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // 유저가 작성한 게시물 (OneToMany 관계)
    @OneToMany(mappedBy = "author")
    private List<Post> posts;

    // 유저의 친구 목록 (ManyToMany 관계)
    @ManyToMany
    @JoinTable(
            name = "user_friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<User> friends;

    // 유저가 사용하는 해시태그 (OneToMany 관계)
    @OneToMany(mappedBy = "user")
    private List<Hashtag> hashtags;

    // 유저가 받은 친구 요청 (OneToMany 관계)
    @OneToMany(mappedBy = "toUser")
    private List<FriendRequest> receivedFriendRequests;

    // 유저가 보낸 친구 요청 (OneToMany 관계)
    @OneToMany(mappedBy = "fromUser")
    private List<FriendRequest> sentFriendRequests;
}
