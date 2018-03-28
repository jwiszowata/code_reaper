public Element handle(Connection connection, Element element) throws FreeColException {
    if (element == null)
        return null;
    Element reply = super.handle(connection, element);
    if (currentPlayerIsMyPlayer()) {
        String sound = DOMUtils.getStringAttribute(element, "sound");
        if (sound != null && !sound.isEmpty()) {
            getGUI().playSound(sound);
        }
        if (DOMUtils.getBooleanAttribute(element, "flush", false)) {
            invokeLater(displayModelMessagesRunnable);
        }
    }
    return reply;
}