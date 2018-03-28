public Message handle(Message message) throws FreeColException {
    message.clientHandler(getFreeColClient());
    return null;
}