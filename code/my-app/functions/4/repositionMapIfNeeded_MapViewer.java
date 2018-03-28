private void repositionMapIfNeeded() {
    if (bottomRow < 0 && focus != null)
        positionMap(focus);
}