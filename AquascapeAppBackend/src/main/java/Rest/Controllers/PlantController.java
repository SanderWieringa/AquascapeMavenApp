package Rest.Controllers;

import Rest.Entities.Aquascape;
import Rest.Entities.Plant;
import Rest.Services.PlantCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlantController {

    @Autowired
    private PlantCollectionService plantCollectionService;

    @CrossOrigin
    @RequestMapping(value = "/plants")
    public ResponseEntity<List<Plant>> getAllPlants() {
        try {
            return new ResponseEntity<>(plantCollectionService.getAllPlants(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/plants")
    public ResponseEntity addPlant(@RequestBody Plant plant) {
        try {
            plantCollectionService.addPlant(plant);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/plants/{id}")
    public ResponseEntity<Plant> getPlantById(int id) {
        try {
            return new ResponseEntity<>(plantCollectionService.getPlantById(id), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
