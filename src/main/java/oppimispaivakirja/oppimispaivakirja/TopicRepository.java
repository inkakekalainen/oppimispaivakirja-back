package oppimispaivakirja.oppimispaivakirja;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer> {
   /* List<Topic> findAllByName(String title);*/
    List<Topic> deleteById(int id);
}
