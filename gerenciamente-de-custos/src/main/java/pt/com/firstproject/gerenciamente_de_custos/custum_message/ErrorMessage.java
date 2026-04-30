package pt.com.firstproject.gerenciamente_de_custos.custum_message;


public class ErrorMessage {

    private String message;
    private String details;
    private String type;

    

    public ErrorMessage(String message, String details, String type) {
        this.message = message;
        this.details = details;
        this.type = type;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

}
