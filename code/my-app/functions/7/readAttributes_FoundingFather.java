protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    type = xr.getAttribute(TYPE_TAG, FoundingFatherType.class, null);
    for (int i = 0; i < weight.length; i++) {
        weight[i] = xr.getAttribute(WEIGHT_TAG + (i + 1), 0);
    }
}