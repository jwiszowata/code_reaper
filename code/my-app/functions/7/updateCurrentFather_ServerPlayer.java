public void updateCurrentFather(FoundingFather ff) {
    setCurrentFather(ff);
    clearOfferedFathers();
    if (ff != null) {
        logger.finest(getId() + " is recruiting " + ff.getId() + " in " + getGame().getTurn());
    }
}