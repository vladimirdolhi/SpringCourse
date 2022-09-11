package by.spring.learn.service;

import by.spring.learn.model.Sensor;
import by.spring.learn.repository.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Author Vladimir Dolgiy
 * @Version 1.1
 **/
@Service
public class SensorService {
    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    public List<Sensor> findAll() {
        return sensorsRepository.findAll();
    }

    public Optional<Sensor> findByName(String name) {
        return sensorsRepository.findByName(name);
    }

    @Transactional
    public void register(Sensor sensor){
        sensorsRepository.save(sensor);
    }


}
