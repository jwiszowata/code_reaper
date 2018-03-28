protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    if (xr.shouldClearContainers()) {
        skills = null;
        regions = null;
    }
    final Specification spec = getSpecification();
    IndianNationType parent = xr.getType(spec, EXTENDS_TAG, IndianNationType.class, this);
    if (parent != this) {
        if (parent.skills != null && !parent.skills.isEmpty()) {
            if (skills == null)
                skills = new ArrayList<>();
            skills.addAll(parent.skills);
        }
        if (parent.regions != null && !parent.regions.isEmpty()) {
            if (regions == null)
                regions = new ArrayList<>();
            regions.addAll(parent.regions);
        }
    }
    super.readChildren(xr);
}