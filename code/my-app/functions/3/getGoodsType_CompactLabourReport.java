private GoodsType getGoodsType() {
    return (isSummary()) ? null : unitData.getUnitType().getExpertProduction();
}