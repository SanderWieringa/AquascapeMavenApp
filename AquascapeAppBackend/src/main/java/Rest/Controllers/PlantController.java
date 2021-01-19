package Rest.Controllers;

import Rest.Entities.Plant;
import Rest.Responses.PlantCollectionResponse;
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

    @RequestMapping(value = "/plants", method = RequestMethod.GET)
    public ResponseEntity<PlantCollectionResponse> getAllPlants() {
        try {
            PlantCollectionResponse plantCollectionResponse = new PlantCollectionResponse();
            plantCollectionResponse.setAquascapes(plantCollectionService.getAllPlants());
            return ResponseEntity.ok(plantCollectionResponse);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

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

    @RequestMapping(value = "/plants/{id}", method = RequestMethod.GET)
    public ResponseEntity<Plant> getPlantById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(plantCollectionService.getPlantById(Integer.parseInt(id)), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
