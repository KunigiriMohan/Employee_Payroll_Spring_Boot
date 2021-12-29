package com.application.EmployeePayrollApp.exceptions;

import java.util.List;
import java.util.stream.Collectors;
import com.application.EmployeePayrollApp.DTO.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @ControllerAdvice : to handle all Exception throw in application
 * @ExceptionHandler : to declare a method to handle particular Exception
 */

@Slf4j
@ControllerAdvice
public class EmployeePayrollExceptionHandler {

    private static final String message = "Exception while processing REST Request";
    
    /**
     * method to handle any Exception thrown
     * @param exception
     * @return : ResponseEntity of Exception
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO(message, errMsg);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
    }

    /**
     * Exception Hanling method to handle HttpMessageNotReadableException 
     * @param exception
     * @return : ResponseEntity of Exception ResponseDTO
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDTO> handlingHttpMessageNotReadableException(HttpMessageNotReadableException exception){
        log.error("Invalid Date Format",exception);
        ResponseDTO responseDTO = new ResponseDTO(message ,"Should have date in the Format dd MM yyyy");
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
    }

    /**
     * method to handle when user Id not found
     * @param exception
     * @return : Response Entity of Exception
     */
    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDTO> handlerEmployeePayrollException(EmployeePayrollException exception){
        ResponseDTO responseDTO = new ResponseDTO(message, exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
    }
}