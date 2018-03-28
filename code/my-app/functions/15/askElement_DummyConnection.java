public Element askElement(Element request) throws IOException {
    if (!isAlive() || request == null)
        return null;
    final String tag = request.getTagName();
    Element reply;
    try {
        log(request, true);
        reply = getOtherConnection().handleElement(request);
        log(reply, false);
    } catch (FreeColException fce) {
        logger.log(Level.WARNING, "Dummy-ask handler fail: " + tag, fce);
        reply = null;
    }
    return reply;
}