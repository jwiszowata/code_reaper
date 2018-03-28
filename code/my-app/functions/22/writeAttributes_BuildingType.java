protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (upgradesFrom != null) {
        xw.writeAttribute(UPGRADES_FROM_TAG, upgradesFrom);
    }
    xw.writeAttribute(WORKPLACES_TAG, workPlaces);
    if (minSkill != UNDEFINED) {
        xw.writeAttribute(MINIMUM_SKILL_TAG, minSkill);
    }
    if (maxSkill < INFINITY) {
        xw.writeAttribute(MAXIMUM_SKILL_TAG, maxSkill);
    }
    if (upkeep > 0) {
        xw.writeAttribute(UPKEEP_TAG, upkeep);
    }
    if (priority != Consumer.BUILDING_PRIORITY) {
        xw.writeAttribute(PRIORITY_TAG, priority);
    }
    xw.writeAttribute(EXPERTS_WITH_CONNECTION_PRODUCTION_TAG, this.expertConnectionProduction);
    xw.writeAttribute(COMPETENCE_FACTOR_TAG, this.competenceFactor);
    xw.writeAttribute(REBEL_FACTOR_TAG, this.rebelFactor);
}