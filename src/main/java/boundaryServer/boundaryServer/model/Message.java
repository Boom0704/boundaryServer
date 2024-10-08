package boundaryServer.boundaryServer.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Message {
    private Integer id;
    private User sender;        // 메시지를 보낸 유저
    private User receiver;      // 메시지를 받는 유저
    private String content;     // 메시지 내용
    private Date sentAt;        // 메시지 전송 시간
}
