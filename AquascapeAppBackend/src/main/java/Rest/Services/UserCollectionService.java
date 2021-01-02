package Rest.Services;

import Rest.Entities.User;
import Rest.Repositories.IUserCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCollectionService
{
    @Autowired
    private IUserCollectionRepository userCollectionRepository;

    public Optional<User> getUserByName(String username)
    {
        return userCollectionRepository.findById(username);
    }

    public void addUser(User user)
    {
        userCollectionRepository.save(user);
    }
}
