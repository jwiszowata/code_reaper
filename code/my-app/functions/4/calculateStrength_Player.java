public int calculateStrength(boolean naval) {
    final CombatModel cm = getGame().getCombatModel();
    return (int) sumDouble(getUnits(), u -> u.isNaval() == naval, u -> cm.getOffencePower(u, null));
}