public static synchronized void initializeFromSpecification(Specification spec) {
    if (pioneerRole != null)
        return;
    pioneerRole = spec.getRoleWithAbility(Ability.IMPROVE_TERRAIN, null);
    scoutRole = spec.getRoleWithAbility(Ability.SPEAK_WITH_CHIEF, null);
    liftBoycottCheatPercent = spec.getInteger(GameOptions.LIFT_BOYCOTT_CHEAT);
    equipScoutCheatPercent = spec.getInteger(GameOptions.EQUIP_SCOUT_CHEAT);
    equipPioneerCheatPercent = spec.getInteger(GameOptions.EQUIP_PIONEER_CHEAT);
    landUnitCheatPercent = spec.getInteger(GameOptions.LAND_UNIT_CHEAT);
    offensiveLandUnitCheatPercent = spec.getInteger(GameOptions.OFFENSIVE_LAND_UNIT_CHEAT);
    offensiveNavalUnitCheatPercent = spec.getInteger(GameOptions.OFFENSIVE_NAVAL_UNIT_CHEAT);
    transportNavalUnitCheatPercent = spec.getInteger(GameOptions.TRANSPORT_NAVAL_UNIT_CHEAT);
}