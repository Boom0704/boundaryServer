package boundaryServer.boundaryServer.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Comment {
    private Integer id;
    private String postId;
    private User author; // IUser -> User
    private String content;
    private List<User> likes;
    private Date createdAt;
    private Date updatedAt;
}
