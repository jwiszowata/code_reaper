private boolean send(DOMMessage message) {
    if (message == null)
        return true;
    final Connection c = check("send", message.getType());
    return (c == null) ? false : c.send(message);
}