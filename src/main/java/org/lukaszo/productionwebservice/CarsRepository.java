package org.lukaszo.productionwebservice;

import io.spring.guides.gs_producing_web_service.Car;
import io.spring.guides.gs_producing_web_service.FuelType;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CarsRepository {

    private static final Map<String, Car> cars = new HashMap<>();

    @PostConstruct
    public void initData() {
        Car firstCar = new Car();
        firstCar.setName("Hyundai i30");
        firstCar.setOwner("Mateusz");
        firstCar.setLicensePlateNumber("RZ 001");
        firstCar.setYearOfProduction("2019-10-10");
        firstCar.setFuelType(FuelType.GASOLINE);
        firstCar.setIdInsured(true);

        cars.put(firstCar.getLicensePlateNumber(), firstCar);

        Car secondCar = new Car();
        secondCar.setName("Opel Astra");
        secondCar.setOwner("Kacper");
        secondCar.setLicensePlateNumber("RZ 002");
        secondCar.setYearOfProduction("2012-10-10");
        secondCar.setFuelType(FuelType.DIESEL);
        secondCar.setIdInsured(true);

        cars.put(secondCar.getLicensePlateNumber(), secondCar);

        Car thirdCar = new Car();
        thirdCar.setName("Toyota Corolla");
        thirdCar.setOwner("Krzysztof");
        thirdCar.setLicensePlateNumber("RZ 003");
        thirdCar.setYearOfProduction("2009-10-10");
        thirdCar.setFuelType(FuelType.LPG_AUTOGAS);
        thirdCar.setIdInsured(false);

        cars.put(thirdCar.getLicensePlateNumber(), thirdCar);
    }

    public Car findCar(String licensePlateNumber) {
        Assert.notNull(licensePlateNumber, "The car's license plate number cannot be null");
        return cars.get(licensePlateNumber);
    }
}
