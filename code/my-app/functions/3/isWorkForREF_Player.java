public boolean isWorkForREF() {
    return (any(getUnits(), Unit::hasTile)) ? true : !getRebels().isEmpty();
}