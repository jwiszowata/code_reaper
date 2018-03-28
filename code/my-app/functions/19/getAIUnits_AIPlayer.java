protected List<AIUnit> getAIUnits() {
    List<AIUnit> aiUnits = new ArrayList<>();
    for (Unit u : getPlayer().getUnitList()) {
        if (u.isDisposed()) {
            logger.warning("getAIUnits ignoring: " + u.getId());
            continue;
        }
        AIUnit a = getAIUnit(u);
        if (a != null) {
            if (a.getUnit() != u) {
                throw new IllegalStateException("getAIUnits fail: " + u + "/" + a);
            }
            aiUnits.add(a);
        } else {
            logger.warning("Could not find the AIUnit for: " + u + " (" + u.getId() + ")");
        }
    }
    return aiUnits;
}