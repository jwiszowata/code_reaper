public int getInitialMovesLeft() {
    Turn turn = getGame().getTurn();
    return (int) applyModifiers(unitType.getMovement(), turn, Modifier.MOVEMENT_BONUS, unitType);
}