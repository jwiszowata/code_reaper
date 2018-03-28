public void handleQuery(DOMMessage msg, int replyId) throws FreeColException, IOException {
    Element element = msg.toXMLElement(), reply;
    element = (Element) element.getFirstChild();
    reply = handleElement(element);
    msg = new DOMMessage(REPLY_TAG, NETWORK_REPLY_ID_TAG, Integer.toString(replyId));
    if (reply != null)
        msg.add(reply);
    send(msg);
}