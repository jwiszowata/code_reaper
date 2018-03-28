protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (EXPEDITIONARY_FORCE_TAG.equals(tag)) {
        expeditionaryForce.readFromXML(xr);
    } else if (INTERVENTION_FORCE_TAG.equals(tag)) {
        interventionForce.readFromXML(xr);
    } else if (Force.LAND_UNITS_TAG.equals(tag)) {
        expeditionaryForce.clearLandUnits();
        while (xr.moreTags()) {
            AbstractUnit newUnit = new AbstractUnit(xr);
            expeditionaryForce.add(newUnit);
        }
    } else if (MERCENARY_FORCE_TAG.equals(tag)) {
        new Force(getSpecification()).readFromXML(xr);
    } else if (Force.NAVAL_UNITS_TAG.equals(tag)) {
        expeditionaryForce.clearNavalUnits();
        while (xr.moreTags()) {
            AbstractUnit newUnit = new AbstractUnit(xr);
            expeditionaryForce.add(newUnit);
        }
    } else {
        super.readChild(xr);
    }
}