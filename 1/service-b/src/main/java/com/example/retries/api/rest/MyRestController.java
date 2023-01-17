package com.example.retries.api.rest;

import java.util.Map;
import java.util.Set;
import java.util.List;
import static java.util.stream.Collectors.toList;

import  org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.retries.handlers.MyHandler;
import com.example.retries.dtos.MyDto;

import lombok.RequiredArgsConstructor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ConstraintViolation;

@RestController
@RequiredArgsConstructor
public class MyRestController {
    
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MyRestController.class);

    private final MyHandler myHandler;

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @PostMapping()
    public ResponseEntity<MyDto> doSomething(@RequestBody final MyDto myDto) {

        log.info(myDto.toString());

        final Set<ConstraintViolation<MyDto>> violations = validator.validate(myDto);

        if ( violations.size() > 0 ) {
            final List<Object> errors = violations.stream()
                .map(e -> Map.of(e.getPropertyPath().toString(), e.getMessage()))
                .collect(toList());
            log.error(errors.toString());
            return ResponseEntity.badRequest().build();
        }

        final MyDto result = myHandler.doSomething( myDto );

        return ResponseEntity.ok(result);
    }
}
