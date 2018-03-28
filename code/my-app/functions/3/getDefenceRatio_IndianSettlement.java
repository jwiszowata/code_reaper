public double getDefenceRatio() {
    return getUnitCount() * 2.0 / (getType().getMinimumSize() + getType().getMaximumSize());
}