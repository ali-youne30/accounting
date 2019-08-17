package com.au.accounting.config;

import com.au.accounting.exception.AccountNotFoundException;
import com.au.accounting.exception.InvalidRestParameterException;
import com.au.accounting.web.dto.response.Response;
import com.au.accounting.web.dto.response.ReturnType;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Aspect
@Configuration
@AllArgsConstructor
public class AspectConfig {

    @Around("execution(* com.au.accounting.web.controller.*.*(..))")
    public ResponseEntity<Response> around(ProceedingJoinPoint joinPoint) {

        //TODO: Logging request into table; keep log entity

        ResponseEntity<Response> result;

        try {
            result = (ResponseEntity<Response>) joinPoint.proceed();

        } catch (InvalidRestParameterException | AccountNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(ReturnType.INVALID_REQUEST_PARAMETER));

        } catch (Throwable throwable) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(ReturnType.THROWS_EXCEPTION));
        }

        //TODO: update log entity

        return result;
    }
}
