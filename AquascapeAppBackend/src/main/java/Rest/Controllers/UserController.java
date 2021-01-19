package Rest.Controllers;

import Rest.Entities.User;
import Rest.Services.MyUserDetailsService;
import Rest.Services.UserCollectionService;
import Rest.models.AuthenticationRequest;
import Rest.models.AuthenticationResponse;
import Rest.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserCollectionService userCollectionService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            userCollectionService.addUser(user);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        try {
            User user = userCollectionService.getById(Integer.parseInt(id));

            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/users/userName", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByUsername(@RequestParam("userName") String userName) {
        try {
            User user = (User) userCollectionService.loadUserByUsername(userName);

            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            userCollectionService.login(authenticationRequest);
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) userCollectionService.loadUserByUsername(authenticationRequest.getUserName());

        final String jwt = jwtTokenUtil.generateToken(user);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
