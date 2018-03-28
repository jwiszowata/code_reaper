protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (xw.validFor(getOwner())) {
        for (Entry<String, ExportData> e : mapEntriesByKey(exportData)) {
            e.getValue().toXML(xw);
        }
        for (WorkLocation wl : sort(getAllWorkLocations())) {
            wl.toXML(xw);
        }
        for (BuildableType item : buildQueue.getValues()) {
            xw.writeStartElement(BUILD_QUEUE_TAG);
            xw.writeAttribute(ID_ATTRIBUTE_TAG, item);
            xw.writeEndElement();
        }
        for (BuildableType item : populationQueue.getValues()) {
            xw.writeStartElement(POPULATION_QUEUE_TAG);
            xw.writeAttribute(ID_ATTRIBUTE_TAG, item);
            xw.writeEndElement();
        }
    } else {
        Building stockade = getStockade();
        if (stockade != null)
            stockade.toXML(xw);
    }
}