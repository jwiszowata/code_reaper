public boolean isWorkerTypeAllowed(UnitType unitType) {
    return allowedWorkers == null || allowedWorkers.isEmpty() || allowedWorkers.contains(unitType.getId());
}