private void reply(DOMMessage msg, int replyId) {
    NetworkReplyObject nro = waitingThreads.remove(replyId);
    if (nro == null) {
        logger.warning("Could not find reply: " + replyId);
    } else {
        nro.setResponse(msg);
    }
}