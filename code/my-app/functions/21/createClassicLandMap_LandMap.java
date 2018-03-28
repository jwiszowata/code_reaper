private void createClassicLandMap(int distanceToEdge, int minNumberOfTiles, Random random) {
    final int edg = distanceToEdge * 2;
    final int wid = getWidth() - edg * 2;
    final int hgt = getHeight() - edg * 2;
    int x, y;
    while (this.numberOfLandTiles < minNumberOfTiles) {
        int failCounter = 0;
        do {
            x = edg + randomInt(logger, "ClassicW", random, wid);
            y = edg + randomInt(logger, "ClassicH", random, hgt);
            failCounter++;
            if (failCounter > 100) {
                failCounter = 0;
                minNumberOfTiles--;
                break;
            }
        } while (isLand(x, y));
        setLand(x, y, distanceToEdge, random);
    }
    addPolarRegions();
}