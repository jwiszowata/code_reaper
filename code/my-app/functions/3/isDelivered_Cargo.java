public boolean isDelivered() {
    return !getMode().isCollection() && !isCarried();
}