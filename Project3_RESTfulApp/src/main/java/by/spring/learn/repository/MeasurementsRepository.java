package by.spring.learn.repository;

import by.spring.learn.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Vladimir Dolgiy
 * @Version 1.1
 **/
@Repository
public interface MeasurementsRepository extends JpaRepository<Measurement, Integer> {

}
