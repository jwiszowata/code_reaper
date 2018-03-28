protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    stance = xr.getAttribute(STANCE_TAG, Stance.class, (Stance) null);
}