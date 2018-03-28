public static final Message handleList(DOMMessageHandler mh, Connection connection, List<Element> elements) {
    List<Element> results = new ArrayList<>();
    int i = 0;
    for (Element e : elements) {
        final String tag = e.getTagName();
        try {
            Element reply = mh.handle(connection, e);
            if (reply != null)
                results.add(reply);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Crash in multiple " + i + ", tag " + tag + ", continuing.", ex);
        }
        i++;
    }
    return (results.isEmpty()) ? null : new MultipleMessage(results);
}