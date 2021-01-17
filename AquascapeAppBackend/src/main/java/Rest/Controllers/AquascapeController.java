package Rest.Controllers;

import Rest.Entities.Aquascape;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Rest.Entities.Fish;
import Rest.Services.AquascapeCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AquascapeController {

    @Autowired
    private AquascapeCollectionService aquascapeCollectionService;

    @RequestMapping(value = "/hello")
    public ResponseEntity<String> sayHi(){
        try {
            return new ResponseEntity<String>("Hi", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

    /*@GET
    @Path("/aquascapes")
    @Produces(MediaType.APPLICATION_JSON)*/
    @RequestMapping(value = "/aquascapes")
    public ResponseEntity<List<Aquascape>> getAllAquascpaes() {
        try {
            return new ResponseEntity<>(aquascapeCollectionService.getAllAquascapes(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /*
    @RequestMapping(value = "/aquascapes/{id}")
    public ResponseEntity<List<Aquascape>> getAllAquascapesByUser(int userId) {
        try {
            return new ResponseEntity<>(aquascapeCollectionService.getAllAquascapesByUser(userId), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }*/

    @RequestMapping(value = "/aquascapes/{id}")
    public ResponseEntity<Aquascape> getAquascapeById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(aquascapeCollectionService.getAquascapeById(Integer.parseInt(id)), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/aquascapes")
    public ResponseEntity addPlant(@RequestBody Aquascape aquascape) {
        try {
            aquascapeCollectionService.addAquascape(aquascape);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }
}
