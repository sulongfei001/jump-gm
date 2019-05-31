package com.sulongfei.jump.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class JumpException extends RuntimeException {
    private static final long serialVersionUID = -2013396565671482319L;

    private int code;

    public JumpException(int code, String message) {
        super(message);
        this.code = code;
    }

    public JumpException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
