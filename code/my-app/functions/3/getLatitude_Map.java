public int getLatitude(int row) {
    return minimumLatitude + (int) (row * latitudePerRow);
}