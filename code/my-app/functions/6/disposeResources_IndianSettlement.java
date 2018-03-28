public void disposeResources() {
    while (!ownedUnits.isEmpty()) {
        ownedUnits.remove(0).changeHomeIndianSettlement(null);
    }
    super.disposeResources();
}