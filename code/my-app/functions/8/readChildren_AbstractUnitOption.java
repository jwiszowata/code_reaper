public void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    super.readChildren(xr);
    AbstractUnit au = null;
    if (unitType != null && role != null && number != null) {
        au = new AbstractUnit(unitType.getValue(), role.getValue(), number.getValue());
    }
    setValue(au);
}