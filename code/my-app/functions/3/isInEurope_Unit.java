public boolean isInEurope() {
    return (isOnCarrier()) ? getCarrier().isInEurope() : getLocation() instanceof Europe;
}