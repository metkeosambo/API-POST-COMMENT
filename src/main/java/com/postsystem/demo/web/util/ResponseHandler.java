package com.postsystem.demo.web.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.postsystem.demo.web.vo.response.PostPaginationResultResponseVO;

public class ResponseHandler {

	public static ResponseEntity<Object> responseWithMsg(String message, HttpStatus status)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        message = (message != null) ? message : "Request successfully";
        map.put("message", message);
        return new ResponseEntity<Object>(map, status);
    }
	
	public static <T> ResponseEntity<ResponseListDataUtils<T>> responseListData(String message, HttpStatus status , List<T> responseObj)
    {
        ResponseListDataUtils<T> response = new ResponseListDataUtils<T>(responseObj,message);

        return new ResponseEntity<ResponseListDataUtils<T>>(response, status);
    }
    public static <T> ResponseEntity<ResponseDataUtils<T>> responseData(String message, HttpStatus status , T responseObj)
    {
        ResponseDataUtils<T> response = new ResponseDataUtils<T>(message,responseObj);

        return new ResponseEntity<ResponseDataUtils<T>>(response, status);
    }
    
    public static <T> ResponseEntity<ResponsePaginationUtils<T>> responsePagination(String message, HttpStatus status , PostPaginationResultResponseVO<T> responseObj)
    {
    	ResponsePaginationUtils<T> response = new ResponsePaginationUtils<T>(responseObj.getTotalPage(),responseObj.getCurrentPage(),responseObj.getTotalItems(),responseObj.getData(),message);

        return new ResponseEntity<ResponsePaginationUtils<T>>(response, status);
    }


}
