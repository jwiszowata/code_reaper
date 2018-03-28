protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    basicMoveCost = xr.getAttribute(BASIC_MOVE_COST_TAG, 1);
    basicWorkTurns = xr.getAttribute(BASIC_WORK_TURNS_TAG, 1);
    forest = xr.getAttribute(IS_FOREST_TAG, false);
    water = xr.getAttribute(IS_WATER_TAG, false);
    elevation = xr.getAttribute(IS_ELEVATION_TAG, false);
    canSettle = xr.getAttribute(CAN_SETTLE_TAG, !water);
    connected = xr.getAttribute(IS_CONNECTED_TAG, false);
}