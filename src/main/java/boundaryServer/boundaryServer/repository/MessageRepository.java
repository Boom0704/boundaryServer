package boundaryServer.boundaryServer.repository;

import boundaryServer.boundaryServer.model.Message;

import java.util.List;

public interface MessageRepository {
    // 메시지 전송
    Message sendMessage(Message message);

    // 특정 유저가 받은 메시지 목록 조회
    List<Message> findMessagesByReceiverId(Integer receiverId);

    // 특정 유저가 보낸 메시지 목록 조회
    List<Message> findMessagesBySenderId(Integer senderId);
}
