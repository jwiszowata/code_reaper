public void updateSoL() {
    int uc = getUnitCount();
    oldSonsOfLiberty = sonsOfLiberty;
    oldTories = tories;
    sonsOfLiberty = calculateSoLPercentage(uc, getLiberty());
    tories = uc - calculateRebels(uc, sonsOfLiberty);
}