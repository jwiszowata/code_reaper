public boolean fireChanges() {
    final int newCount = europe.getUnitCount();
    if (newCount != this.unitCount) {
        europe.firePropertyChange(Europe.UNIT_CHANGE, unitCount, newCount);
        return true;
    }
    return false;
}