private void addLandDefensiveModifiers(FreeColGameObject attacker, Unit defender, Set<Modifier> result) {
    final Specification spec = defender.getSpecification();
    final Tile tile = defender.getTile();
    final Settlement settlement = (tile == null) ? null : tile.getSettlement();
    if (tile != null) {
        boolean disableFortified = false;
        disableFortified |= hasStrongDefenceModifier(tile.getType());
        if (settlement == null) {
            result.addAll(tile.getType().getDefenceModifiers());
            if (defender.hasAbility(Ability.BOMBARD) && defender.getState() != Unit.UnitState.FORTIFIED) {
                result.addAll(toList(spec.getModifiers(Modifier.ARTILLERY_IN_THE_OPEN)));
            }
        } else {
            result.addAll(settlement.getDefenceModifiers());
            if (defender.hasAbility(Ability.BOMBARD) && attacker != null && ((Unit) attacker).getOwner().isIndian()) {
                result.addAll(toList(spec.getModifiers(Modifier.ARTILLERY_AGAINST_RAID)));
            }
            Role autoRole = defender.getAutomaticRole();
            if (autoRole != null) {
                result.addAll(autoRole.getDefenceModifiers());
            }
            if (settlement instanceof Colony) {
                Building stockade = ((Colony) settlement).getStockade();
                if (stockade != null) {
                    disableFortified |= hasStrongDefenceModifier(stockade.getType());
                }
            }
        }
        if (defender.getState() == Unit.UnitState.FORTIFIED && !disableFortified) {
            result.addAll(toList(spec.getModifiers(Modifier.FORTIFIED)));
        }
    }
}