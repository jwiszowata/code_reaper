public boolean isRawBuildingMaterial() {
    if (this.madeFrom != null)
        return false;
    GoodsType refinedType = makes;
    while (refinedType != null) {
        if (refinedType.isBuildingMaterial())
            return true;
        refinedType = refinedType.makes;
    }
    return false;
}