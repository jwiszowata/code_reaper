public Message reader(FreeColXMLReader xr) throws FreeColException, XMLStreamException {
    MessageHandler mh = getMessageHandler();
    return (mh == null) ? null : mh.read(xr);
}