public Unit getCarrier() {
    return (isOnCarrier()) ? ((Unit) getLocation()) : null;
}