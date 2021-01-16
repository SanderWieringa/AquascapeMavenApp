package Rest.Services;

import Rest.Repositories.IUserCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService
{

    @Autowired
    private IUserCollectionRepository userCollectionRepository;

    /*@Override
    public UserDetails getUserByName(String username) throws UsernameNotFoundException
    {
        return userCollectionRepository.findById(username);
    }*/

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
    {
        //return user by username
        return new User("foo", "foo", new ArrayList<>());
    }
}