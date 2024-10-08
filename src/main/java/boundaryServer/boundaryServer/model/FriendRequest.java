package boundaryServer.boundaryServer.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FriendRequest {
    private Integer id;
    private User fromUser;  // 요청 보낸 유저
    private User toUser;    // 요청 받은 유저
    private Date requestedAt;
    private boolean isAccepted;
}
