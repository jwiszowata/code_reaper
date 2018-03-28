public static List<UnitType> getLabourTypes(Player player) {
    return transform(player.getSpecification().getUnitTypeList(), ut -> ut.hasSkill() && ut.isAvailableTo(player));
}