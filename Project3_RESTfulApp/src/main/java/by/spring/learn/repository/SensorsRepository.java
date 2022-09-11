package by.spring.learn.repository;

import by.spring.learn.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author Vladimir Dolgiy
 * @Version 1.1
 **/

@Repository
public interface SensorsRepository extends JpaRepository<Sensor, String> {

     Optional<Sensor> findByName(String name);

}
