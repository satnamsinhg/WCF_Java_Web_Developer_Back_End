package wcf.javawebdeveloper.javawebdeveloperProject.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code =HttpStatus.BAD_REQUEST)
public class ClientNotFoundException extends Throwable {
    public ClientNotFoundException(){
        super("Client Not Found Exception");
    }
    public ClientNotFoundException(String message){
        super(message);
    }
}
