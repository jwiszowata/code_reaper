protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    operator = xr.getAttribute(OPERATOR_TAG, Operator.class, (Operator) null);
}