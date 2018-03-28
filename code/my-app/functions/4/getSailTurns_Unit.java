public int getSailTurns() {
    float base = getSpecification().getInteger(GameOptions.TURNS_TO_SAIL);
    return (int) getOwner().applyModifiers(base, getGame().getTurn(), Modifier.SAIL_HIGH_SEAS, unitType);
}