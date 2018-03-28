public <T extends FreeColGameObject> T getFreeColGameObject(String id, Class<T> returnClass) {
    FreeColGameObject fcgo = getFreeColGameObject(id);
    try {
        return returnClass.cast(fcgo);
    } catch (ClassCastException e) {
        return null;
    }
}