private final void calculateLatitudePerRow() {
    this.latitudePerRow = 1f * (maximumLatitude - minimumLatitude) / (getHeight() - 1);
}