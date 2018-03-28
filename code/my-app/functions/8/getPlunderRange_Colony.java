public RandomRange getPlunderRange(Unit attacker) {
    if (canBePlundered()) {
        int upper = (owner.getGold() * (getUnitCount() + 1)) / (owner.getColoniesPopulation() + 1);
        if (upper > 0)
            return new RandomRange(100, 1, upper + 1, 1);
    }
    return null;
}