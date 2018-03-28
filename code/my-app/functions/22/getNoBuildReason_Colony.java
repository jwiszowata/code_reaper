public NoBuildReason getNoBuildReason(BuildableType buildableType, List<BuildableType> assumeBuilt) {
    if (buildableType == null) {
        return NoBuildReason.NOT_BUILDING;
    } else if (!buildableType.needsGoodsToBuild()) {
        return NoBuildReason.NOT_BUILDABLE;
    } else if (buildableType.getRequiredPopulation() > getUnitCount()) {
        return NoBuildReason.POPULATION_TOO_SMALL;
    } else if (buildableType.hasAbility(Ability.COASTAL_ONLY) && !getTile().isCoastland()) {
        return NoBuildReason.COASTAL;
    } else {
        if (any(buildableType.getRequiredAbilities().entrySet(), e -> e.getValue() != hasAbility(e.getKey()))) {
            return NoBuildReason.MISSING_ABILITY;
        }
        if (!all(buildableType.getLimits(), l -> l.evaluate(this))) {
            return NoBuildReason.LIMIT_EXCEEDED;
        }
    }
    if (assumeBuilt == null) {
        assumeBuilt = Collections.<BuildableType>emptyList();
    }
    return buildableType.canBeBuiltInColony(this.getColony(), assumeBuilt);
}