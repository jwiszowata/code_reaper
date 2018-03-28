protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (startingUnitMap != null && !startingUnitMap.isEmpty()) {
        Map<String, AbstractUnit> map;
        if ((map = startingUnitMap.get(null)) != null) {
            for (Map.Entry<String, AbstractUnit> entry : map.entrySet()) {
                writeUnit(xw, entry.getKey(), entry.getValue(), false);
            }
        }
        if ((map = startingUnitMap.get(Boolean.TRUE.toString())) != null) {
            for (Map.Entry<String, AbstractUnit> entry : map.entrySet()) {
                writeUnit(xw, entry.getKey(), entry.getValue(), true);
            }
        }
    }
}