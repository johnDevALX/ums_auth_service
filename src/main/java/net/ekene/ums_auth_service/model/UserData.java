//package net.ekene.ums_auth_service.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import net.ekene.response.UserResponseVO;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class UserData {
//    @Id
//    private long id;
//    private String email;
//    private String password;
//    private String role;
//
//    public UserResponseVO returnResponse() {
//        return UserResponseVO.builder()
//                .email(getEmail())
//                .build();
//    }
//
//    public UserResponseVO returnResponse(String token) {
//        return UserResponseVO.builder()
//                .email(getEmail())
//                .token(token)
//                .build();
//    }
//}
