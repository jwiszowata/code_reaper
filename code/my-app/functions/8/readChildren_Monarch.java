protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    if (expeditionaryForce == null)
        expeditionaryForce = new Force(spec);
    if (interventionForce == null)
        interventionForce = new Force(spec);
    super.readChildren(xr);
}