public boolean isWorkerAllowed(Unit unit) {
    return isWorkerTypeAllowed(unit.getType()) && (requiredRole == null || unit.getRole() == requiredRole);
}