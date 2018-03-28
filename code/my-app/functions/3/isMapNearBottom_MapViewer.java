private boolean isMapNearBottom(int y) {
    return y >= getGame().getMap().getHeight() - bottomRows;
}