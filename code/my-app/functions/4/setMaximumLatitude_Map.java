public final void setMaximumLatitude(final int newMaximumLatitude) {
    this.maximumLatitude = newMaximumLatitude;
    calculateLatitudePerRow();
}