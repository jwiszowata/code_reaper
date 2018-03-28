protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (UNIT_TAG.equals(tag)) {
        String id = xr.readId();
        String type = xr.getAttribute(TYPE_TAG, (String) null);
        String roleId = xr.getAttribute(ROLE_TAG, Specification.DEFAULT_ROLE_ID);
        boolean ex = xr.getAttribute(EXPERT_STARTING_UNITS_TAG, false);
        addStartingUnit(id, new AbstractUnit(type, roleId, 1), ex);
        xr.closeTag(UNIT_TAG);
    } else {
        super.readChild(xr);
    }
}