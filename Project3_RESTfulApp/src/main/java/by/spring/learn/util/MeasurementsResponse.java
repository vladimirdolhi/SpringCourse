package by.spring.learn.util;

import by.spring.learn.dto.MeasurementDTO;

import java.util.List;

/**
 * @Author Vladimir Dolgiy
 * @Version 1.1
 **/
public class MeasurementsResponse {

    private List<MeasurementDTO> measurements;

    public MeasurementsResponse(List<MeasurementDTO> measurements) {
        this.measurements = measurements;
    }

    public List<MeasurementDTO> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<MeasurementDTO> measurements) {
        this.measurements = measurements;
    }
}
