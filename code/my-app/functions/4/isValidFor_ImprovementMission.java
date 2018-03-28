public static boolean isValidFor(Unit unit) {
    final Specification spec = unit.getGame().getSpecification();
    return any(spec.getTileImprovementTypeList(), ti -> ti.isWorkerAllowed(unit));
}