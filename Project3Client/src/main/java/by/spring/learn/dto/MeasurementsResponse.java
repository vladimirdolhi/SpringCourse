package by.spring.learn.dto;

import java.util.List;

/**
 * @Author Vladimir Dolgiy
 * @Version 1.1
 **/
public class MeasurementsResponse {
    List<MeasurementDTO> measurements;

    public List<MeasurementDTO> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<MeasurementDTO> measurements) {
        this.measurements = measurements;
    }
}
