protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(BASIC_MOVE_COST_TAG, basicMoveCost);
    xw.writeAttribute(BASIC_WORK_TURNS_TAG, basicWorkTurns);
    xw.writeAttribute(IS_FOREST_TAG, forest);
    xw.writeAttribute(IS_WATER_TAG, water);
    xw.writeAttribute(IS_ELEVATION_TAG, elevation);
    xw.writeAttribute(IS_CONNECTED_TAG, connected);
    xw.writeAttribute(CAN_SETTLE_TAG, canSettle);
}