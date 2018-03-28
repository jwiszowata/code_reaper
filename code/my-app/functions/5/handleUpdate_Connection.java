public void handleUpdate(DOMMessage msg) throws FreeColException, IOException {
    Element reply = handle(msg);
    if (reply != null)
        sendElement(reply);
}