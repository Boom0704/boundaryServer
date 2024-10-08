package boundaryServer.boundaryServer.repository;

import boundaryServer.boundaryServer.model.FriendRequest;

import java.util.List;

public interface FriendRequestRepository {
    FriendRequest sendFriendRequest(FriendRequest request);
    void acceptFriendRequest(Integer requestId);
    List<FriendRequest> findRequestsByToUserId(Integer userId);
    void deleteFriendRequest(Integer requestId);
}