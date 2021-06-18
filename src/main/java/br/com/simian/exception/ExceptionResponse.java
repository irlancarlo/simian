package br.com.simian.exception;

import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    private Date timestamp;

    @Getter
    private String message;

    @Getter
    private String detail;


    public ExceptionResponse(Date timestamp, String message, String detail) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.detail = detail;
    }


}
