private static float calcScaledSize(FontSize fontSize, float scaleFactor) {
    float pixelSize;
    switch(fontSize) {
        case TINY:
            pixelSize = 12f;
            break;
        case SMALLER:
            pixelSize = 16f;
            break;
        case SMALL:
            pixelSize = 24f;
            break;
        case MEDIUM:
            pixelSize = 36f;
            break;
        case BIG:
            pixelSize = 48f;
            break;
        default:
            logger.warning("Unknown FontSize: " + fontSize.toString());
            return -1.0f;
    }
    return pixelSize * scaleFactor;
}