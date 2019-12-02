package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import https.www_howtodoinjava_com.xml.school.EmpDetailsRequest;
import https.www_howtodoinjava_com.xml.school.EmpDetailsResponse;

@Endpoint
public class EmpEndpoint
{
    private static final String NAMESPACE_URI = "https://www.howtodoinjava.com/xml/school";

    private EmpRepository EmpRepository;

    @Autowired
    public EmpEndpoint (EmpRepository EmpRepository)
    {
        this.EmpRepository = EmpRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EmpDetailsRequest")
    @ResponsePayload
    public EmpDetailsResponse getEmployee(@RequestPayload EmpDetailsRequest request)
    {
        EmpDetailsResponse response = new EmpDetailsResponse();
        response.setEmployee(EmpRepository.findEmployee(request.getName()));
        return response;
    }

}
