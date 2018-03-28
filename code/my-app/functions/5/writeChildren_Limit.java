protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    leftHandSide.toXML(xw, LEFT_HAND_SIDE_TAG);
    rightHandSide.toXML(xw, RIGHT_HAND_SIDE_TAG);
}