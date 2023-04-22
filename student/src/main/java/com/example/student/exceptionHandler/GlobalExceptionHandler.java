//package com.example.student.exceptionHandler;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import com.example.student.ResponseDTO.LoginResponseDTO;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//    
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
//        ErrorResponse errorResponse = new ErrorResponse();
//        errorResponse.setMessage(ex.getMessage());
//        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<LoginResponseDTO> handleResourceNotFoundException(ResourceNotFoundException ex) {
//        ErrorResponse errorResponse = new ErrorResponse();
//        errorResponse.setMessage(ex.getMessage());
//        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
//        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//    }
//    
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
//        BindingResult bindingResult = ex.getBindingResult();
//        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//        
//        ErrorResponse errorResponse = new ErrorResponse();
//        errorResponse.setMessage("Validation error");
//        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
//        
//        List<ValidationError> validationErrors = new ArrayList<>();
//        for (FieldError fieldError : fieldErrors) {
//            ValidationError validationError = new ValidationError();
//            validationError.setField(fieldError.getField());
//            validationError.setMessage(fieldError.getDefaultMessage());
//            validationErrors.add(validationError);
//        }
//        errorResponse.setValidationErrors(validationErrors);
//        
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }
//}
//
