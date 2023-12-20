package com.employee.employeedemo.exception;

import com.employee.employeedemo.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage employeeNotFoundHandler(EmployeeNotFoundException exception){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return message;
    }

//    GENERIC EXCEPTION
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage genericExceptionHandler(Exception exception){
        ErrorMessage message = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return message;
    }


}



//        #
//        # Complete the 'weatherStation' function below.
//        #
//        # The function is expected to return a STRING_ARRAY.
//        # The function accepts STRING keyword as parameter.
//        #
//        # Base URL: https://jsonmock.hackerrank.com/api/weather/search?name={keyword}
//        #
//        #
//
//        def weatherStation(keyword):
//        final_result = []
//        url ="https://jsonmock.hackerrank.com/api/weather/search"
//        weather_request = requests.get(url=url, params=keyword)
//        # print("=====================")
//        if(weather_request.status_code==200):
//        data = weather_request.json()['data']
//        print(data)
//        for name in sorted(data, key=lambda x: x[-1]):
//        print(name)
//        return data.sorted()