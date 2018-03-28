private static StringTemplate stpl(String messageId) {
    return (Messages.containsKey(messageId)) ? StringTemplate.template(messageId) : null;
}