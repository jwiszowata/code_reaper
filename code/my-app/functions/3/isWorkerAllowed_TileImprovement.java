public boolean isWorkerAllowed(Unit unit) {
    return (unit == null || isComplete()) ? false : type.isWorkerAllowed(unit);
}