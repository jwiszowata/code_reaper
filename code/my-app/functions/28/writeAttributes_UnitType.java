protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(OFFENCE_TAG, offence);
    xw.writeAttribute(DEFENCE_TAG, defence);
    xw.writeAttribute(DEFAULT_UNIT_TAG, defaultUnit);
    xw.writeAttribute(MOVEMENT_TAG, movement);
    xw.writeAttribute(LINE_OF_SIGHT_TAG, lineOfSight);
    xw.writeAttribute(SCORE_VALUE_TAG, scoreValue);
    xw.writeAttribute(SPACE_TAG, space);
    xw.writeAttribute(SPACE_TAKEN_TAG, spaceTaken);
    xw.writeAttribute(HIT_POINTS_TAG, hitPoints);
    xw.writeAttribute(MAXIMUM_EXPERIENCE_TAG, maximumExperience);
    if (hasMaximumAttrition()) {
        xw.writeAttribute(MAXIMUM_ATTRITION_TAG, maximumAttrition);
    }
    xw.writeAttribute(RECRUIT_PROBABILITY_TAG, recruitProbability);
    if (hasSkill()) {
        xw.writeAttribute(SKILL_TAG, skill);
    }
    if (hasPrice()) {
        xw.writeAttribute(PRICE_TAG, price);
    }
    xw.writeAttribute(SKILL_TAUGHT_TAG, skillTaught);
    if (expertProduction != null) {
        xw.writeAttribute(EXPERT_PRODUCTION_TAG, expertProduction);
    }
    xw.writeAttribute(PRIORITY_TAG, priority);
}