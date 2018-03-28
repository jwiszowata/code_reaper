public int getRow(int latitude) {
    return (int) ((latitude - minimumLatitude) / latitudePerRow);
}