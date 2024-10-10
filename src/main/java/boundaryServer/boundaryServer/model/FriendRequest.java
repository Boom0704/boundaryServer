package boundaryServer.boundaryServer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "friend_requests")
public class FriendRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "from_user_id", nullable = false)
    private User fromUser;  // 요청 보낸 유저

    @ManyToOne
    @JoinColumn(name = "to_user_id", nullable = false)
    private User toUser;    // 요청 받은 유저

    @Temporal(TemporalType.TIMESTAMP)
    private Date requestedAt;  // 요청 시간

    private boolean isAccepted;  // 친구 요청 수락 여부
}
