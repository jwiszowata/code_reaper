public boolean appliesTo(String level) {
    return level == null || productionLevel == null || level.equals(productionLevel);
}