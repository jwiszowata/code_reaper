protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    String tag = xr.getLocalName();
    if (NATION_OPTION_TAG.equals(tag)) {
        Nation nation = xr.getType(spec, ID_ATTRIBUTE_TAG, Nation.class, (Nation) null);
        NationState state = xr.getAttribute(STATE_TAG, NationState.class, (NationState) null);
        if (nation != null && state != null) {
            nations.put(nation, state);
        }
        xr.closeTag(NATION_OPTION_TAG);
    } else if (OLD_NATIONS_TAG.equals(tag)) {
        while (xr.moreTags()) {
            tag = xr.getLocalName();
            if (OLD_NATION_TAG.equals(tag)) {
                Nation nation = xr.getType(spec, ID_ATTRIBUTE_TAG, Nation.class, (Nation) null);
                NationState state = xr.getAttribute(STATE_TAG, NationState.class, (NationState) null);
                if (nation != null && state != null) {
                    nations.put(nation, state);
                }
                xr.closeTag(OLD_NATION_TAG);
            } else {
                throw new XMLStreamException("Bogus " + OLD_NATION_TAG + " tag: " + tag);
            }
        }
    } else {
        super.readChild(xr);
    }
}