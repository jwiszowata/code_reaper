public <T extends FreeColObject> T copy(Game game, Class<T> returnClass) throws XMLStreamException {
    setReadScope(ReadScope.NOINTERN);
    nextTag();
    return uninternedRead(game, returnClass);
}