public static String message(String messageId) {
    if (messageId == null) {
        throw new NullPointerException("Message id must not be null!");
    }
    String message = messageBundle.get(messageId);
    if (message == null)
        return messageId;
    message = replaceChoices(message, null);
    return message.trim();
}