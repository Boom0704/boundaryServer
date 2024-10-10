package boundaryServer.boundaryServer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;  // 작성자

    @ElementCollection
    private List<String> imageUrls;  // 게시물에 첨부된 이미지

    private String caption;  // 게시물 설명

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;  // 게시물에 달린 댓글

    @ManyToMany
    @JoinTable(
            name = "post_likes",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> likes;  // 게시물에 좋아요를 누른 유저 목록

    @ElementCollection
    private List<String> tags;  // 게시물의 태그

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
}
