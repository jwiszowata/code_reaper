public String getChatText() {
    String message = field.getText();
    field.setText("");
    return message;
}