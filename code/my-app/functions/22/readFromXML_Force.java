public void readFromXML(FreeColXMLReader xr) throws XMLStreamException {
    clearLandUnits();
    clearNavalUnits();
    while (xr.moreTags()) {
        final String tag = xr.getLocalName();
        if (LAND_UNITS_TAG.equals(tag)) {
            while (xr.moreTags()) {
                AbstractUnit au = new AbstractUnit(xr);
                if (au != null)
                    add(au);
            }
        } else if (NAVAL_UNITS_TAG.equals(tag)) {
            while (xr.moreTags()) {
                AbstractUnit au = new AbstractUnit(xr);
                if (au != null)
                    add(au);
            }
        } else {
            logger.warning("Bogus Force tag: " + tag);
        }
    }
}