protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (Scope scope : getScopeList()) scope.toXML(xw);
}