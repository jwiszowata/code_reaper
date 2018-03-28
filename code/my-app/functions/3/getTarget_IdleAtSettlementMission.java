public Location getTarget() {
    return (isSafe()) ? null : findTarget();
}