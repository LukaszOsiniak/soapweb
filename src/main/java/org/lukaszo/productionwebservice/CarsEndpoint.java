package org.lukaszo.productionwebservice;

import io.spring.guides.gs_producing_web_service.GetCarRequest;
import io.spring.guides.gs_producing_web_service.GetCarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CarsEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private CarsRepository carsRepository;

    @Autowired
    public CarsEndpoint(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCarRequest")
    @ResponsePayload
    public GetCarResponse getCar(@RequestPayload GetCarRequest request) {
        GetCarResponse response = new GetCarResponse();
        response.setCar(carsRepository.findCar(request.getLicensePlateNumber()));
        return response;
    }
}
