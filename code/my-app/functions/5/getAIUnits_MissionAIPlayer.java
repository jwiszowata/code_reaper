protected List<AIUnit> getAIUnits() {
    if (aiUnits.isEmpty())
        aiUnits = super.getAIUnits();
    return new ArrayList<>(aiUnits);
}