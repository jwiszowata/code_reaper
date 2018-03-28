private static void readFromXML(FreeColXMLReader xr) throws XMLStreamException {
    while (xr.moreTags()) {
        String tag = xr.getLocalName();
        if (null != tag)
            switch(tag) {
                case VERSION_TAG:
                    xr.nextTag();
                    break;
                case GENERATION_TAG:
                    xr.nextTag();
                    break;
                case PLURALS_TAG:
                    while (xr.moreTags()) {
                        tag = xr.getLocalName();
                        if (PLURAL_RULES_TAG.equals(tag)) {
                            readChild(xr);
                        }
                    }
                    break;
            }
    }
}