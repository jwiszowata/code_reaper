protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (target != null) {
        xw.writeAttribute(TARGET_TAG, target.getId());
        if (tileImprovementPlan != null) {
            xw.writeAttribute(TileImprovementPlan.TAG, tileImprovementPlan);
        }
    }
}