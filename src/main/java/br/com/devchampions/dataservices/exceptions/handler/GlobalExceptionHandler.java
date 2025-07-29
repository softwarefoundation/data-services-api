package br.com.devchampions.dataservices.exceptions.handler;


import br.com.devchampions.dataservices.exceptions.RegistroNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {

    @Value("${app.url.base}")
    private String appUrlBase;

    @ExceptionHandler({RegistroNotFoundException.class})
    public ResponseEntity<?> handleRegistroNaoLocalizadoException(RegistroNotFoundException ex) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setType(URI.create(appUrlBase.concat("/wiki/problems/404-registro-nao-localizado")));

        return prepararResponseEntity(problemDetail);
    }

    private ResponseEntity<Object> prepararResponseEntity(ProblemDetail detail) {
        return ResponseEntity.status(detail.getStatus()).contentType(MediaType.APPLICATION_PROBLEM_JSON).body(detail);
    }

}
