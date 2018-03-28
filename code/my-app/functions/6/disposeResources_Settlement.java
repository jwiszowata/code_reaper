public void disposeResources() {
    if (owner != null) {
        owner.removeSettlement(this);
    }
    super.disposeResources();
}