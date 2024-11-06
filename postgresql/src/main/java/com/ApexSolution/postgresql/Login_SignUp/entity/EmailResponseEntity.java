package com.ApexSolution.postgresql.Login_SignUp.entity;


public class EmailResponseEntity extends LoginEntity {

    private String subject;
    private String message;

    public EmailResponseEntity(){
    }

    public EmailResponseEntity(String userEmail, String subject, String message, String token) {
        super(userEmail, token);
        this.subject = subject;
        this.message = message;

        super.setUserEmail(userEmail);
        super.setToken(token);
    }

    @Override
    public String toString() {
        return "{\n" +
                "   toEmail: '" + getUserEmail() + '\'' +
                ",\n   subject: '" + subject + '\'' +
                ",\n   message: '" + message + '\'' +
                ",\n   token: '" + getToken() + '\'' +
                "\n}";
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
