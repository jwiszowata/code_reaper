private static StringTemplate stpld(String messageId) {
    messageId = Messages.descriptionKey(messageId);
    return stpl(messageId);
}