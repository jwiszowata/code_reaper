private <T extends FreeColObject> T uninternedRead(Game game, Class<T> returnClass) throws XMLStreamException {
    T ret = Game.newInstance(game, returnClass, getReadScope() == ReadScope.SERVER);
    if (ret == null) {
        throw new XMLStreamException("Could not create instance of " + returnClass.getName());
    }
    String id = readId();
    if (id == null) {
        throw new XMLStreamException("Object identifier not found.");
    }
    uninterned.put(id, ret);
    ret.readFromXML(this);
    return ret;
}