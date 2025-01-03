package MaesAtipicas.MaeAtipicas.mapper;

import MaesAtipicas.MaeAtipicas.model.User;
import MaesAtipicas.MaeAtipicas.request.UserRequest;
import MaesAtipicas.MaeAtipicas.response.UserResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest request){
        return User.builder()
                .username(request.username())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

}
