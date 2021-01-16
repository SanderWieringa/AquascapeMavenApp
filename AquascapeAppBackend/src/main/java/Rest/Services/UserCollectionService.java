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

import javax.security.auth.message.callback.PasswordValidationCallback;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

@Service
public class UserCollectionService implements UserDetailsService
{

    @Autowired
    private IUserCollectionRepository userCollectionRepository;

    /*public User getUserByName(String username)
    {
        Optional<User> user = userCollectionRepository.findByUserName(username);
        return user.orElse(null);
    }*/

    public User login(AuthenticationRequest authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {
        User user = new User();

        if (PasswordValidator.validatePassword(authenticationRequest.getPassword(), userCollectionRepository.findByUserName(authenticationRequest.getUsername()).get().getPassword())) {
            user.setUserName(authenticationRequest.getUsername());
            user.setPassword(authenticationRequest.getPassword());
            return user;
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

    public Optional<User> getById(int userId) {
        return userCollectionRepository.findById(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userCollectionRepository.findByUserName(username);
        return (UserDetails) user.orElse(null);
    }
}
