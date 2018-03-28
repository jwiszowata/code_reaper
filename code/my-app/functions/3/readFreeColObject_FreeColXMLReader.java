public <T extends FreeColObject> T readFreeColObject(Game game, Class<T> returnClass) throws XMLStreamException {
    return (shouldIntern()) ? internedRead(game, returnClass) : uninternedRead(game, returnClass);
}