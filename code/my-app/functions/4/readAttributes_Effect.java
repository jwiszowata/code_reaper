protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    probability = xr.getAttribute(PROBABILITY_TAG, 0);
}