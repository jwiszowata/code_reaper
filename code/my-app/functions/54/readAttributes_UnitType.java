protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final Specification spec = getSpecification();
    UnitType parent = xr.getType(spec, EXTENDS_TAG, UnitType.class, this);
    offence = xr.getAttribute(OFFENCE_TAG, parent.offence);
    defence = xr.getAttribute(DEFENCE_TAG, parent.defence);
    if (xr.hasAttribute(OLD_DEFAULT_UNIT_TAG)) {
        defaultUnit = xr.getAttribute(OLD_DEFAULT_UNIT_TAG, false);
    } else
        defaultUnit = xr.getAttribute(DEFAULT_UNIT_TAG, false);
    movement = xr.getAttribute(MOVEMENT_TAG, parent.movement);
    if (xr.hasAttribute(OLD_LINE_OF_SIGHT_TAG)) {
        lineOfSight = xr.getAttribute(OLD_LINE_OF_SIGHT_TAG, parent.lineOfSight);
    } else
        lineOfSight = xr.getAttribute(LINE_OF_SIGHT_TAG, parent.lineOfSight);
    if (xr.hasAttribute(OLD_SCORE_VALUE_TAG)) {
        scoreValue = xr.getAttribute(OLD_SCORE_VALUE_TAG, parent.scoreValue);
    } else
        scoreValue = xr.getAttribute(SCORE_VALUE_TAG, parent.scoreValue);
    space = xr.getAttribute(SPACE_TAG, parent.space);
    if (xr.hasAttribute(OLD_HIT_POINTS_TAG)) {
        hitPoints = xr.getAttribute(OLD_HIT_POINTS_TAG, parent.hitPoints);
    } else
        hitPoints = xr.getAttribute(HIT_POINTS_TAG, parent.hitPoints);
    if (xr.hasAttribute(OLD_SPACE_TAKEN_TAG)) {
        spaceTaken = xr.getAttribute(OLD_SPACE_TAKEN_TAG, parent.spaceTaken);
    } else
        spaceTaken = xr.getAttribute(SPACE_TAKEN_TAG, parent.spaceTaken);
    if (xr.hasAttribute(OLD_MAXIMUM_EXPERIENCE_TAG)) {
        maximumExperience = xr.getAttribute(OLD_MAXIMUM_EXPERIENCE_TAG, parent.maximumExperience);
    } else
        maximumExperience = xr.getAttribute(MAXIMUM_EXPERIENCE_TAG, parent.maximumExperience);
    if (xr.hasAttribute(OLD_MAXIMUM_ATTRITION_TAG)) {
        maximumAttrition = xr.getAttribute(OLD_MAXIMUM_ATTRITION_TAG, parent.maximumAttrition);
    } else
        maximumAttrition = xr.getAttribute(MAXIMUM_ATTRITION_TAG, parent.maximumAttrition);
    if (xr.hasAttribute(OLD_SKILL_TAUGHT_TAG)) {
        skillTaught = xr.getType(spec, OLD_SKILL_TAUGHT_TAG, UnitType.class, this);
    } else
        skillTaught = xr.getType(spec, SKILL_TAUGHT_TAG, UnitType.class, this);
    if (xr.hasAttribute(OLD_RECRUIT_PROBABILITY_TAG)) {
        recruitProbability = xr.getAttribute(OLD_RECRUIT_PROBABILITY_TAG, parent.recruitProbability);
    } else
        recruitProbability = xr.getAttribute(RECRUIT_PROBABILITY_TAG, parent.recruitProbability);
    priority = xr.getAttribute(PRIORITY_TAG, Consumer.UNIT_PRIORITY);
    skill = xr.getAttribute(SKILL_TAG, parent.skill);
    price = xr.getAttribute(PRICE_TAG, parent.price);
    expertProduction = xr.getType(spec, EXPERT_PRODUCTION_TAG, GoodsType.class, parent.expertProduction);
    if (parent != this) {
        if (!xr.hasAttribute(REQUIRED_POPULATION_TAG)) {
            setRequiredPopulation(parent.getRequiredPopulation());
        }
    }
}