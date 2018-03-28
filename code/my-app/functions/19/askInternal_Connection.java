private DOMMessage askInternal(Element element) throws IOException {
    if (element == null)
        return null;
    final String tag = element.getTagName();
    int networkReplyId = this.receivingThread.getNextNetworkReplyId();
    if (Thread.currentThread() == this.receivingThread) {
        throw new IOException("wait(ReceivingThread) for: " + tag);
    }
    Element question = DOMUtils.createElement(QUESTION_TAG);
    question.setAttribute(NETWORK_REPLY_ID_TAG, Integer.toString(networkReplyId));
    question.appendChild(question.getOwnerDocument().importNode(element, true));
    NetworkReplyObject nro = this.receivingThread.waitForNetworkReply(networkReplyId);
    if (!sendInternal(question))
        return null;
    log(question, true);
    DOMMessage response = (DOMMessage) nro.getResponse();
    log(response, false);
    return response;
}