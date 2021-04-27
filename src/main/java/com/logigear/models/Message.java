package com.logigear.models;

public class Message {
    private String generalMessage;
    private String emailMessage;
    private String passwordMessage;
    private String confirmPasswordMessage;
    private String pidMessage;

    public String getGeneralMessage() {
        return generalMessage;
    }

    public void setGeneralMessage(String generalMessage) {
        this.generalMessage = generalMessage;
    }

    public String getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    public String getPasswordMessage() {
        return passwordMessage;
    }

    public void setPasswordMessage(String passwordMessage) {
        this.passwordMessage = passwordMessage;
    }

    public String getConfirmPasswordMessage() {
        return confirmPasswordMessage;
    }

    public void setConfirmPasswordMessage(String confirmPasswordMessage) {
        this.confirmPasswordMessage = confirmPasswordMessage;
    }

    public String getPidMessage() {
        return pidMessage;
    }

    public void setPidMessage(String pidMessage) {
        this.pidMessage = pidMessage;
    }
}
