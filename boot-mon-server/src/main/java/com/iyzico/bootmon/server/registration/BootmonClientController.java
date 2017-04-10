package com.iyzico.bootmon.server.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/clients")
public class BootmonClientController {

    @Autowired
    BootmonClientService bootmonClientService;

    @PostMapping
    public HttpEntity<BootmonClient> create(@RequestBody BootmonClient bootmonClient) {
        bootmonClientService.saveBootmonClient(bootmonClient);

        bootmonClient.add(linkTo(methodOn(BootmonClientController.class)
                .create(bootmonClient))
                .slash(bootmonClient.getName())
                .withSelfRel());

        return new ResponseEntity<>(bootmonClient, HttpStatus.OK);
    }
}
