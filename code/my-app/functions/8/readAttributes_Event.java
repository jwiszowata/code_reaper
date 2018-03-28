protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    value = xr.getAttribute(VALUE_TAG, (String) null);
    if (xr.hasAttribute(OLD_SCORE_VALUE_TAG)) {
        scoreValue = xr.getAttribute(OLD_SCORE_VALUE_TAG, 0);
    } else
        scoreValue = xr.getAttribute(SCORE_VALUE_TAG, 0);
}