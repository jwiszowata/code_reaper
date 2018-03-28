public UnitTypeOption clone() {
    UnitTypeOption result = new UnitTypeOption(getId(), getSpecification());
    result.value = value;
    result.addNone = addNone;
    result.selector = selector;
    result.generateChoices();
    result.isDefined = true;
    return result;
}