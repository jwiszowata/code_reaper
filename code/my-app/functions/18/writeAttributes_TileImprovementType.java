protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(NATURAL_TAG, natural);
    xw.writeAttribute(MAGNITUDE_TAG, magnitude);
    xw.writeAttribute(ADD_WORK_TURNS_TAG, addWorkTurns);
    if (requiredImprovementType != null) {
        xw.writeAttribute(REQUIRED_IMPROVEMENT_TAG, requiredImprovementType);
    }
    if (requiredRole != null) {
        xw.writeAttribute(REQUIRED_ROLE_TAG, requiredRole);
    }
    if (expendedAmount != 0) {
        xw.writeAttribute(EXPENDED_AMOUNT_TAG, expendedAmount);
    }
    xw.writeAttribute(MOVEMENT_COST_TAG, movementCost);
    xw.writeAttribute(ZINDEX_TAG, zIndex);
    xw.writeAttribute(EXPOSE_RESOURCE_PERCENT_TAG, exposeResourcePercent);
}