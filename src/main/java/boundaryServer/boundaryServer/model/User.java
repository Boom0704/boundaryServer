package boundaryServer.boundaryServer.model;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class User {
    private Integer id;
    private String username;
    private String email;
    private String profilePictureUrl;
    private String bio;
    private String website;
    private List<Post> posts;
    private List<User> friends;
    private List<Hashtag> hashtags;
    private String gender;
    private String birthday;
    private ProfileVisibility visibility;
    private boolean isActive;
    private Date createdAt;
    private Date updatedAt;
}
