void setImageLibraryAndUpdateData(ImageLibrary lib) {
    this.lib = lib;
    Dimension tileSize = lib.tileSize;
    rp = new RoadPainter(tileSize);
    tileHeight = tileSize.height;
    tileWidth = tileSize.width;
    halfHeight = tileHeight / 2;
    halfWidth = tileWidth / 2;
    fog.reset();
    fog.moveTo(halfWidth, 0);
    fog.lineTo(tileWidth, halfHeight);
    fog.lineTo(halfWidth, tileHeight);
    fog.lineTo(0, halfHeight);
    fog.closePath();
}