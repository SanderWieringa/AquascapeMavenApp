package Rest.Services;

import Rest.Entities.User;
import Rest.Repositories.IUserCollectionRepository;
import Rest.models.AuthenticationRequest;
import Rest.util.PasswordHasher;
import Rest.util.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserCollectionService implements UserDetailsService {

    @Autowired
    private IUserCollectionRepository userCollectionRepository;

    public User login(AuthenticationRequest authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {
        User user = new User();
        Optional<User> userToCheck = userCollectionRepository.findByUserName(authenticationRequest.getUserName());
        if (userToCheck.isPresent()) {
            if (PasswordValidator.validatePassword(authenticationRequest.getPassword(), userToCheck.get().getPassword())) {
                user.setUserName(authenticationRequest.getUserName());
                user.setPassword(authenticationRequest.getPassword());
                return user;
            }

        }

        return null;
    }

    public void addUser(User user) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (userCollectionRepository.findByUserName(user.getUserName()).isEmpty()) {
            String hashedPassword = PasswordHasher.generateStrongPasswordHash(user.getPassword());
            user.setPassword(hashedPassword);
            userCollectionRepository.save(user);
        }
    }

    public User getById(int userId) {
        Optional<User> userToConvert = userCollectionRepository.findById(userId);
        if (userToConvert.isPresent()) {
            return new User(userToConvert.get().getUserId(), userToConvert.get().getUserName(), userToConvert.get().getPassword());
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userToConvert = userCollectionRepository.findByUserName(username);
        if (userToConvert.isPresent()) {
            return new org.springframework.security.core.userdetails.User(userToConvert.get().getUserName(), userToConvert.get().getPassword(), new ArrayList<>());
        }

        return null;
    }
}
