public AIUnit getAIUnit(Unit unit) {
    return getAIObject(unit.getId(), AIUnit.class);
}