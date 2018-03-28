public boolean isAtSea() {
    return (isOnCarrier()) ? getCarrier().isAtSea() : getLocation() instanceof HighSeas;
}