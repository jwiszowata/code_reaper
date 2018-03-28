private void addPolarRegions() {
    for (int x = 0; x < this.width; x++) {
        for (int y = 0; y < Map.POLAR_HEIGHT; y++) setLand(x, y);
        int limit = this.height - 1 - Map.POLAR_HEIGHT;
        for (int y = limit; y < this.height; y++) setLand(x, y);
    }
}