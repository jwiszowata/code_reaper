public void generateChoices() {
    if (selector == null) {
        choices.add(getValue());
    } else {
        List<UnitType> unitTypeList = getSpecification().getUnitTypeList();
        choices.clear();
        switch(selector) {
            case UNITS:
                choices.addAll(unitTypeList);
                break;
            case IMMIGRANTS:
                choices.addAll(transform(unitTypeList, UnitType::isRecruitable));
                break;
            case NAVAL_UNITS:
                choices.addAll(transform(unitTypeList, UnitType::isNaval));
                break;
            case LAND_UNITS:
                choices.addAll(transform(unitTypeList, ut -> !ut.isNaval()));
                break;
        }
        if (addNone) {
            choices.add(0, null);
        }
    }
}