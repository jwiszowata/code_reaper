public int getUnitCount(boolean naval) {
    return count(getUnits(), u -> u.isNaval() == naval);
}