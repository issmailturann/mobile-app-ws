package app.worklib.web.ws.exceptions;

import java.io.Serial;

public class UserServiceException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1_348_771_109_171_435_607L;

    public UserServiceException(String message){

        super(message);
    }
}
