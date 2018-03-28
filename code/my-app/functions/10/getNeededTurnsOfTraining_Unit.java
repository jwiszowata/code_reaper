public int getNeededTurnsOfTraining() {
    int result = 0;
    if (student != null) {
        result = getSpecification().getNeededTurnsOfTraining(getType(), student.getType());
        if (getColony() != null) {
            result -= getColony().getProductionBonus();
        }
    }
    return result;
}