public boolean sendAndWaitElement(Element request) {
    DummyConnection other = getOtherConnection();
    if (other == null)
        return false;
    if (request == null)
        return true;
    final String tag = request.getTagName();
    try {
        log(request, true);
        Element reply = other.handleElement(request);
        log(reply, false);
        return true;
    } catch (FreeColException fce) {
        logger.log(Level.WARNING, "Dummy send-handler fail: " + tag, fce);
    }
    return false;
}