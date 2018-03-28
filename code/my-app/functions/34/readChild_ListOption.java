public void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (null != tag)
        switch(tag) {
            case OPTION_VALUE_TAG:
                String modId = xr.readId();
                logger.log(Level.FINEST, "Found old-style mod value: {0}", modId);
                if (modId != null) {
                    FreeColModFile fcmf = FreeColModFile.getFreeColModFile(modId);
                    if (fcmf != null) {
                        ModOption modOption = new ModOption(getSpecification());
                        modOption.setValue(fcmf);
                        addMember((AbstractOption<T>) modOption);
                    }
                }
                break;
            case TEMPLATE_TAG:
                xr.nextTag();
                template = (AbstractOption<T>) readOption(xr);
                xr.closeTag(TEMPLATE_TAG);
                break;
            default:
                AbstractOption<T> op = null;
                try {
                    op = (AbstractOption<T>) readOption(xr);
                } catch (XMLStreamException xse) {
                    logger.log(Level.WARNING, "Invalid option at: " + tag, xse);
                    xr.closeTag(tag);
                }
                if (op != null)
                    addMember(op);
                break;
        }
}