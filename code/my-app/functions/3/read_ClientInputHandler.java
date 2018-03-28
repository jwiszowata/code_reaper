public Message read(FreeColXMLReader xr) throws FreeColException, XMLStreamException {
    return Message.read(getGame(), xr);
}