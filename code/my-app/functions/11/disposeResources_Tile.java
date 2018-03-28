public void disposeResources() {
    if (settlement != null) {
        settlement.disposeResources();
        settlement = null;
    }
    if (tileItemContainer != null) {
        tileItemContainer.disposeResources();
        tileItemContainer = null;
    }
    super.disposeResources();
}