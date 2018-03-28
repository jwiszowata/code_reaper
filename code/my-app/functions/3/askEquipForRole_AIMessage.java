public static boolean askEquipForRole(AIUnit aiUnit, Role role, int roleCount) {
    return aiUnit.getAIOwner().askServer().equipUnitForRole(aiUnit.getUnit(), role, roleCount);
}