private <T extends FreeColObject> T internedRead(Game game, Class<T> returnClass) throws XMLStreamException {
    T ret = makeFreeColObject(game, FreeColObject.ID_ATTRIBUTE_TAG, returnClass, false);
    if (ret != null)
        ret.readFromXML(this);
    return ret;
}