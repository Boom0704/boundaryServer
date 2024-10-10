package boundaryServer.boundaryServer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;  // 메시지 보낸 유저

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver;  // 메시지 받는 유저

    private String content;  // 메시지 내용

    @Temporal(TemporalType.TIMESTAMP)
    private Date sentAt;  // 전송 시간
}
