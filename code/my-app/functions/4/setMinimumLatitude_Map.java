public final void setMinimumLatitude(final int newMinimumLatitude) {
    this.minimumLatitude = newMinimumLatitude;
    calculateLatitudePerRow();
}