public void readChild(FreeColXMLReader xr) throws XMLStreamException {
    String optionId = xr.readId();
    Option option = getOption(optionId);
    if (option == null) {
        AbstractOption abstractOption = readOption(xr);
        if (abstractOption != null) {
            add(abstractOption);
            abstractOption.setGroup(this.getId());
        }
    } else {
        option.readFromXML(xr);
    }
}