package boundaryServer.boundaryServer.repository;

import boundaryServer.boundaryServer.model.FriendRequest;
import boundaryServer.boundaryServer.model.ProfileVisibility;
import boundaryServer.boundaryServer.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    // 유저 등록 (회원가입)
    User regist(User user);

    // 유저 조회 (ID로 조회)
    Optional<User> findById(Integer id);

    // 유저 조회 (Username으로 조회)
    Optional<User> findByUsername(String username);

    // 전체 유저 리스트 조회
    List<User> findAll();

//    // 유저 삭제
//    void deleteUser(Integer id);
//
//    // 유저 프로필 관련 업데이트
//    void updateProfilePicture(Integer userId, String profilePictureUrl);  // 프로필 사진 변경
//    void updateBio(Integer userId, String bio);                          // 소개 변경
//    void updateWebsite(Integer userId, String website);                  // 웹사이트 변경
//    void updateVisibility(Integer userId, ProfileVisibility visibility); // 프로필 공개 범위 변경
//
//    // 친구 관리
//    void sendFriendRequest(Integer fromUserId, Integer toUserId);        // 친구 요청 보내기
//    void acceptFriendRequest(Integer requestId);                         // 친구 요청 수락
//    List<User> findFriendsByUserId(Integer userId);                      // 친구 리스트 조회
//    void deleteFriend(Integer userId, Integer friendId);                 // 친구 삭제
//
//    // 친구 요청 관리
//    List<FriendRequest> findFriendRequestsByUserId(Integer userId);      // 친구 요청 리스트 조회
}
