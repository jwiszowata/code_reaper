public FoundingFather checkFoundingFather() {
    FoundingFather father = null;
    if (currentFather != null) {
        int extraLiberty = getRemainingFoundingFatherCost();
        if (extraLiberty <= 0) {
            boolean overflow = getSpecification().getBoolean(GameOptions.SAVE_PRODUCTION_OVERFLOW);
            setLiberty((overflow) ? -extraLiberty : 0);
            father = currentFather;
            currentFather = null;
        }
    }
    return father;
}