package co.com.events.exceptions;

import co.com.events.models.enums.Messages;
import co.com.events.models.exceptions.BadRequestException;
import co.com.events.models.exceptions.ForbiddenException;
import co.com.events.models.exceptions.NotFoundException;
import co.com.events.models.exceptions.UnauthorizedException;
import co.com.events.responses.ErrorResponse;
import co.com.events.responses.GeneralResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GeneralResponse<Map<String,String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        log.error("Bad Request Exception: {}", ex.getMessage(),ex);
        Map<String,String> errors= new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error->{
            String fieldName= ((FieldError) error).getField();
            String message=error.getDefaultMessage();
            errors.put(fieldName,message);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                body(
                        GeneralResponse.<Map<String,String>>builder()
                                .message(Messages.MESSAGE_ERROR_DATA_INCORRECT.getMessage())
                                .response(errors)
                                .build()
                );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<GeneralResponse<ErrorResponse>> handleBadRequestException(BadRequestException ex, WebRequest request) {
        log.error("Bad Request Exception: {}", ex.getMessage(),ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                body(
                        GeneralResponse.<ErrorResponse>builder()
                                .message(Messages.MESSAGE_GENERAL_BAD_REQUEST.getMessage())
                                .response(
                                        ErrorResponse.builder()
                                                .timeStamp(LocalDateTime.now())
                                                .details(request.getDescription(false))
                                                .message(ex.getMessage())
                                                .build()
                                )
                                .build()
                );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<GeneralResponse<ErrorResponse>> handleNotFoundException(NotFoundException ex, WebRequest request) {
        log.error("Not Found Exception: {}", ex.getMessage(),ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body(
                        GeneralResponse.<ErrorResponse>builder()
                                .message(Messages.MESSAGE_GENERAL_NOT_FOUND.getMessage())
                                .response(
                                        ErrorResponse.builder()
                                                .timeStamp(LocalDateTime.now())
                                                .details(request.getDescription(false))
                                                .message(ex.getMessage())
                                                .build()
                                )
                                .build()
                );
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<GeneralResponse<ErrorResponse>> handleForbiddenException(ForbiddenException ex, WebRequest request) {
        log.error("Forbidden Exception: {}", ex.getMessage(),ex);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).
                body(
                        GeneralResponse.<ErrorResponse>builder()
                                .message(Messages.MESSAGE_GENERAL_FORBIDDEN.getMessage())
                                .response(
                                        ErrorResponse.builder()
                                                .timeStamp(LocalDateTime.now())
                                                .details(request.getDescription(false))
                                                .message(ex.getMessage())
                                                .build()
                                )
                                .build()
                );
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<GeneralResponse<ErrorResponse>> handleNoHandlerFoundException(UnauthorizedException ex, WebRequest request) {
        log.error("No Handler Found Exception: {}", ex.getMessage(),ex);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).
                body(
                        GeneralResponse.<ErrorResponse>builder()
                                .message(Messages.MESSAGE_GENERAL_UNAUTHORIZED.getMessage())
                                .response(
                                        ErrorResponse.builder()
                                                .timeStamp(LocalDateTime.now())
                                                .details(request.getDescription(false))
                                                .message(ex.getMessage())
                                                .build()
                                )
                                .build()
                );
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<GeneralResponse<ErrorResponse>> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex, WebRequest request) {
        log.error("Method Not Supported: {}", ex.getMessage(),ex);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).
                body(
                        GeneralResponse.<ErrorResponse>builder()
                                .message(Messages.MESSAGE_GENERAL_METHOD_NOT_ALLOW.getMessage())
                                .response(
                                        ErrorResponse.builder()
                                                .timeStamp(LocalDateTime.now())
                                                .details(request.getDescription(false))
                                                .message(ex.getMessage())
                                                .build()
                                )
                                .build()
                );
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<GeneralResponse<ErrorResponse>> handleNoResourceFoundException(NoResourceFoundException ex, WebRequest request) {
        log.error("Method Not Supported: {}", ex.getMessage(),ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body(
                        GeneralResponse.<ErrorResponse>builder()
                                .message(Messages.MESSAGE_GENERAL_NOT_FOUND.getMessage())
                                .response(
                                        ErrorResponse.builder()
                                                .timeStamp(LocalDateTime.now())
                                                .details(request.getDescription(false))
                                                .message(ex.getMessage())
                                                .build()
                                )
                                .build()
                );
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<GeneralResponse<ErrorResponse>> handelGeneralException(Exception ex, WebRequest request) {
        log.error("Internal Server Exception: {}", ex.getMessage(),ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                body(
                        GeneralResponse.<ErrorResponse>builder()
                                .message(Messages.MESSAGE_EXCEPTION.getMessage())
                                .response(
                                        ErrorResponse.builder()
                                                .timeStamp(LocalDateTime.now())
                                                .details(request.getDescription(false))
                                                .message(Messages.MESSAGE_EXCEPTION.getMessage())
                                                .build()
                                )
                                .build()
                );
    }
}
