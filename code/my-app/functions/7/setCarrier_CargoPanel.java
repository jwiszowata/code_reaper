public void setCarrier(final Unit newCarrier) {
    if (newCarrier != carrier) {
        cleanup();
        this.carrier = newCarrier;
        initialize();
    }
}