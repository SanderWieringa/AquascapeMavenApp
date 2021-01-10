package Rest.Controllers;

import Rest.Entities.Aquascape;
import Rest.Entities.Plant;
import Rest.Services.AquascapeCollectionService;
import Rest.Services.PlantCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AquascapeController {

    @Autowired
    private AquascapeCollectionService aquascapeCollectionService;

    @CrossOrigin
    @RequestMapping(value = "/hello")
    public ResponseEntity<String> sayHi(){
        try {
            return new ResponseEntity<String>("Hi", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

    /*@CrossOrigin
    @RequestMapping(value = "/aquascapes/{id}")
    public ResponseEntity<List<Aquascape>> getAllAquascapesByUser(int userId) {
        try {
            return new ResponseEntity<>(aquascapeCollectionService.getAllAquascapesByUser(userId), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }*/

    @CrossOrigin
    @RequestMapping(value = "/aquascapes/{id}")
    public ResponseEntity<Aquascape> getAquascapeById(int id) {
        try {
            return new ResponseEntity<>(aquascapeCollectionService.getAquascapeById(id), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
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
