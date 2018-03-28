public FreeColObject getMessageDisplay(ModelMessage message) {
    String id = message.getDisplayId();
    if (id == null)
        id = message.getSourceId();
    FreeColObject o = getFreeColGameObject(id);
    if (o == null) {
        try {
            o = getSpecification().findType(id);
        } catch (Exception e) {
            o = null;
        }
    }
    return o;
}