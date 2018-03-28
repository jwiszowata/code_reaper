protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    if (xw.validFor(getOwner())) {
        super.writeChildren(xw);
        if (workImprovement != null)
            workImprovement.toXML(xw);
    }
}