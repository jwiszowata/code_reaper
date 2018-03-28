public boolean isLand() {
    return type != null && !type.isWater();
}