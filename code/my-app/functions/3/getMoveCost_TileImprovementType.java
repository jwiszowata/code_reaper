public int getMoveCost(int originalCost) {
    return (movementCost > 0 && movementCost < originalCost) ? movementCost : originalCost;
}