package Rest.Controllers;

import Rest.Entities.Plant;
import Rest.Services.PlantCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AquascapeController {

    @Autowired
    private PlantCollectionService plantCollectionService;

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

    @CrossOrigin
    @RequestMapping(value = "/plants")
    public ResponseEntity<List<Plant>> getAllItems() {
        try {
            return new ResponseEntity<>(plantCollectionService.getAllPlants(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/plants")
    public ResponseEntity addKoffieApparaatItem(@RequestBody Plant plant) {
        try {
            plantCollectionService.addPlant(plant);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }
}
