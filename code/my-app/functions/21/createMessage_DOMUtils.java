public static DOMMessage createMessage(Game game, Element element) {
    if (element == null)
        return null;
    String tag = element.getTagName();
    tag = "net.sf.freecol.common.networking." + capitalize(tag) + "Message";
    DOMMessage message;
    Class<?> tagClass = Introspector.getClassByName(tag);
    if (tagClass == null) {
        message = new AttributeMessage(tag, getAttributeMap(element));
    } else {
        Class[] types = { Game.class, Element.class };
        Object[] params = { game, element };
        try {
            message = (DOMMessage) Introspector.instantiate(tag, types, params);
        } catch (Introspector.IntrospectorException ex) {
            logger.log(Level.WARNING, "Instantiation fail for:" + tag, ex);
            message = null;
        }
    }
    return message;
}