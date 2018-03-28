protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (RandomChoice<Effect> choice : getEffects()) {
        choice.getObject().toXML(xw);
    }
}