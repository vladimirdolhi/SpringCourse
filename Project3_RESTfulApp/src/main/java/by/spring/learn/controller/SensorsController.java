package by.spring.learn.controller;

import by.spring.learn.dto.SensorDTO;
import by.spring.learn.exception.MeasurementException;
import by.spring.learn.model.Sensor;
import by.spring.learn.service.SensorService;
import by.spring.learn.util.MeasurementErrorResponse;
import by.spring.learn.util.SensorValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static by.spring.learn.util.ErrorsUtil.returnErrorsToClient;

/**
 * @Author Vladimir Dolgiy
 * @Version 1.1
 **/

@RestController
@RequestMapping("/sensors")
public class SensorsController {

    private final ModelMapper modelMapper;
    private final SensorValidator sensorValidator;
    private final SensorService sensorService;


    @Autowired
    public SensorsController(ModelMapper modelMapper, SensorValidator sensorValidator, SensorService sensorService) {
        this.modelMapper = modelMapper;
        this.sensorValidator = sensorValidator;
        this.sensorService = sensorService;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid SensorDTO sensorDTO,
                                                   BindingResult bindingResult) {
        Sensor sensorToAdd = convertToSensor(sensorDTO);

        sensorValidator.validate(sensorToAdd, bindingResult);

        if (bindingResult.hasErrors())
            returnErrorsToClient(bindingResult);

        sensorService.register(sensorToAdd);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException(MeasurementException e) {
        MeasurementErrorResponse response = new MeasurementErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }
}
