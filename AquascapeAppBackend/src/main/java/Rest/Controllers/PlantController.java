package Rest.Controllers;

import Rest.Entities.Plant;
import Rest.Responses.PlantCollectionResponse;
import Rest.Services.PlantCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlantController {

    @Autowired
    private PlantCollectionService plantCollectionService;

    @GetMapping(value = "/plants")
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

    @PostMapping(value = "/plants")
    public ResponseEntity addPlant(@RequestBody Plant plant) {
        try {
            plantCollectionService.addPlant(plant);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/plants/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(plantCollectionService.getPlantById(Integer.parseInt(id)), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
