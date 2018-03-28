public boolean isComplete() {
    return target != null && target.hasTileImprovement(getType());
}