public final boolean isGeographic() {
    return this.key != null && this.type == RegionType.LAND;
}