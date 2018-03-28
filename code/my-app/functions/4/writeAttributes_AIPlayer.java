protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(RANDOM_STATE_TAG, Utils.getRandomState(aiRandom));
}