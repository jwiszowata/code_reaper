protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (name != null)
        xw.writeAttribute(NAME_TAG, name);
    xw.writeAttribute(UNIT_TYPE_TAG, unitType);
    xw.writeAttribute(MOVES_LEFT_TAG, movesLeft);
    xw.writeAttribute(STATE_TAG, state);
    xw.writeAttribute(ROLE_TAG, role);
    xw.writeAttribute(ROLE_COUNT_TAG, roleCount);
    if (!xw.validFor(getOwner()) && isOwnerHidden()) {
        xw.writeAttribute(OWNER_TAG, getGame().getUnknownEnemy());
    } else {
        xw.writeAttribute(OWNER_TAG, getOwner());
        if (nationality != null) {
            xw.writeAttribute(NATIONALITY_TAG, nationality);
        }
        if (ethnicity != null) {
            xw.writeAttribute(ETHNICITY_TAG, ethnicity);
        }
    }
    if (location != null) {
        xw.writeLocationAttribute(LOCATION_TAG, location);
    }
    xw.writeAttribute(TREASURE_AMOUNT_TAG, treasureAmount);
    if (xw.validFor(getOwner())) {
        if (entryLocation != null) {
            xw.writeLocationAttribute(ENTRY_LOCATION_TAG, entryLocation);
        }
        xw.writeAttribute(TURNS_OF_TRAINING_TAG, turnsOfTraining);
        if (workType != null)
            xw.writeAttribute(WORK_TYPE_TAG, workType);
        if (experienceType != null) {
            xw.writeAttribute(EXPERIENCE_TYPE_TAG, experienceType);
        }
        xw.writeAttribute(EXPERIENCE_TAG, experience);
        xw.writeAttribute(INDIAN_SETTLEMENT_TAG, indianSettlement);
        xw.writeAttribute(WORK_LEFT_TAG, workLeft);
        xw.writeAttribute(HIT_POINTS_TAG, hitPoints);
        xw.writeAttribute(ATTRITION_TAG, attrition);
        if (student != null)
            xw.writeAttribute(STUDENT_TAG, student);
        if (teacher != null)
            xw.writeAttribute(TEACHER_TAG, teacher);
        if (destination != null) {
            xw.writeLocationAttribute(DESTINATION_TAG, destination);
        }
        if (tradeRoute != null) {
            xw.writeAttribute(TRADE_ROUTE_TAG, tradeRoute);
            xw.writeAttribute(CURRENT_STOP_TAG, currentStop);
        }
    } else {
        if (getType().canCarryGoods()) {
            xw.writeAttribute(VISIBLE_GOODS_COUNT_TAG, getVisibleGoodsCount());
        }
    }
}