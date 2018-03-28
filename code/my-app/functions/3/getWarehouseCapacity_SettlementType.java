public int getWarehouseCapacity() {
    return GoodsContainer.CARGO_SIZE * getClaimableRadius();
}