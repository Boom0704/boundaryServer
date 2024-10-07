package boundaryServer.boundaryServer.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class Post {
    private Integer id;
    private User author;
    private List<String> imageUrls;
    private String caption;
    private List<Comment> comments;
    private List<User> likes;
    private List<String> tags;
    private Date createdAt;
    private Date updatedAt;
}
