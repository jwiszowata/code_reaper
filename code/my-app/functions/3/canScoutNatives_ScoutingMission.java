private static boolean canScoutNatives(AIUnit aiUnit) {
    return aiUnit.getUnit().hasAbility(Ability.SPEAK_WITH_CHIEF);
}