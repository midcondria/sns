package com.pawland.global.exception;

import com.pawland.global.dto.ApiMessageResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponse(responseCode = "400", description = "입력 값이 올바르지 않습니다.")
    public ResponseEntity<ApiMessageResponse> invalidRequestHandler(IllegalArgumentException e) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .contentType(MediaType.APPLICATION_JSON)
            .body(new ApiMessageResponse(e.getMessage()));
    }
}
