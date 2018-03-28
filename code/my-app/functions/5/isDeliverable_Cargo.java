public boolean isDeliverable() {
    if (getMode().isCollection() || !isCarried())
        return false;
    return Map.isSameLocation(plan.cdst, carrier.getLocation());
}