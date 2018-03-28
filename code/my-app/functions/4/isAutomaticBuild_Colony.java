public boolean isAutomaticBuild(BuildingType buildingType) {
    float value = owner.applyModifiers(100f, getGame().getTurn(), Modifier.BUILDING_PRICE_BONUS, buildingType);
    return value == 0f && canBuild(buildingType);
}