package Rest.Controllers;

import Rest.Entities.Fish;
import Rest.Services.FishCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class FishController {

    @Autowired
    private FishCollectionService fishCollectionService;

    @GetMapping(value = "/fishes")
    public ResponseEntity<List<Fish>> getAllFishes() {
        try {
            return new ResponseEntity<>(fishCollectionService.getAllFishes(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/fishes")
    public ResponseEntity addFish(@RequestBody Fish fish) {
        try {
            fishCollectionService.addFish(fish);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/fishes/{id}")
    public ResponseEntity<Fish> getFishById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(fishCollectionService.getFishById(Integer.parseInt(id)), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
