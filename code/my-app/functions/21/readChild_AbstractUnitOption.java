public void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (null != tag)
        switch(tag) {
            case NUMBER_TAG:
                requireNumber();
                number.readFromXML(xr);
                break;
            case ROLE_TAG:
                requireRole();
                role.readFromXML(xr);
                break;
            case UNIT_TYPE_TAG:
                requireUnitType();
                unitType.readFromXML(xr);
                break;
            default:
                super.readChild(xr);
                break;
        }
}