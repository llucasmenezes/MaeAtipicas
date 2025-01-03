package MaesAtipicas.MaeAtipicas.response;

import lombok.Builder;

@Builder
public record UserResponse(Long id, String username, String email) {
}
