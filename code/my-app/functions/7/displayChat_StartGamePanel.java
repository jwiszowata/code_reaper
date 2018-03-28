public void displayChat(String senderName, String message, boolean privateChat) {
    if (privateChat) {
        chatArea.append(senderName + " (" + Messages.message("private") + "): " + message + '\n');
    } else {
        chatArea.append(senderName + ": " + message + '\n');
    }
}