package com.iyzico.bootmon.server;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/clients")
public class BootmonClientController {

    @PostMapping
    public HttpEntity<BootmonClient> create(@RequestBody BootmonClient bootmonClient) {
        bootmonClient.add(linkTo(methodOn(BootmonClientController.class)
                .create(bootmonClient))
                .slash(bootmonClient.getId())
                .withSelfRel());

        return new ResponseEntity<BootmonClient>(bootmonClient, HttpStatus.OK);
    }
}
