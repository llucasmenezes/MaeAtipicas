package MaesAtipicas.MaeAtipicas.service;

import MaesAtipicas.MaeAtipicas.model.User;
import MaesAtipicas.MaeAtipicas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }
}
