package com.rk8.Internationalization_as_a_Service.Controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class CustomErrorController implements ErrorController {

    private ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public ResponseEntity<Map<String, Object>> handleError(WebRequest webRequest) {
        Map<String, Object> errorDetails = errorAttributes.
                getErrorAttributes(webRequest, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE));

        int status = (int) errorDetails.getOrDefault("status", 500);
        HttpStatus httpStatus = HttpStatus.valueOf(status);

        Map<String, Object> response = new HashMap<>();
        response.put("status", status);
        response.put("error", httpStatus.getReasonPhrase());
        response.put("message", errorDetails.getOrDefault("message", "An unexpected error occurred"));
        response.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(response,httpStatus);
    }
}
