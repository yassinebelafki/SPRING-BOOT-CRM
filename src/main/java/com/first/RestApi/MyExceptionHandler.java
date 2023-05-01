package com.first.RestApi;


import com.first.exception.EmployeeError;
import com.first.exception.EmployeeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeError> emplExpHandler(EmployeeException exp){
        EmployeeError employeeError=new EmployeeError();
        employeeError.setStatus(HttpStatus.NOT_FOUND.value());
        employeeError.setMessage(exp.getMessage());
        employeeError.setTimstamp(System.currentTimeMillis());
        return new ResponseEntity<EmployeeError>(employeeError,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeError> otherExpHandler(Exception exp){
        EmployeeError employeeError=new EmployeeError();
        employeeError.setStatus(HttpStatus.BAD_REQUEST.value());
        employeeError.setMessage(exp.getMessage());
        employeeError.setTimstamp(System.currentTimeMillis());
        return new ResponseEntity<EmployeeError>(employeeError,HttpStatus.BAD_REQUEST);
    }


}
