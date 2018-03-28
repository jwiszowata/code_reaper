protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    nationalAdvantages = xr.getAttribute(NATIONAL_ADVANTAGES_TAG, Advantages.class, Advantages.SELECTABLE);
}