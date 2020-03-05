package oppimispaivakirja.oppimispaivakirja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/aihe")
    public Iterable<Topic> haekaikki() {
        return topicRepository.findAll();
    }

   /* @GetMapping("/etsi/{title}")
    public List<Topic> haeotsikolla(@PathVariable(name = "title", required = true) String title) {
        return topicRepository.findAllByName(title);
    }*/
   @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(path="/aihe")
    public void lisaaKayttaja(@RequestBody Topic topic){
        topicRepository.save(topic);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @DeleteMapping("aihe/{id}")
    public List<Topic> deleteTopic(@PathVariable(name = "id", required = true)int id){

        return topicRepository.deleteById(id);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @PutMapping("aihe/{id}")
    public void paivitaTopic(@RequestBody Topic topic, @PathVariable(name = "id", required = true)int id){
        Optional<Topic> top = topicRepository.findById(id);
        Topic tmp = top.orElseThrow(RuntimeException::new);
        tmp.setAdditionalsource(topic.getAdditionalsource());
        tmp.setComplete(topic.isComplete());
        topicRepository.save(tmp);
    }


}
