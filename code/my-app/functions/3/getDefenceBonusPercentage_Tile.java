public int getDefenceBonusPercentage() {
    return (int) getType().applyModifiers(100f, getGame().getTurn(), Modifier.DEFENCE) - 100;
}