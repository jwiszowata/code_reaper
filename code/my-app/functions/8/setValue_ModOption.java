protected void setValue(String valueString, String defaultValueString) throws XMLStreamException {
    String id = (valueString != null) ? valueString : defaultValueString;
    FreeColModFile fcmf = FreeColModFile.getFreeColModFile(id);
    if (fcmf == null) {
        throw new XMLStreamException("Could not find mod for: " + id);
    }
    setValue(fcmf);
}