protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (LEFT_HAND_SIDE_TAG.equals(tag) || OLD_LEFT_HAND_SIDE_TAG.equals(tag)) {
        leftHandSide = new Operand(xr);
    } else if (RIGHT_HAND_SIDE_TAG.equals(tag) || OLD_RIGHT_HAND_SIDE_TAG.equals(tag)) {
        rightHandSide = new Operand(xr);
    } else {
        super.readChild(xr);
    }
}