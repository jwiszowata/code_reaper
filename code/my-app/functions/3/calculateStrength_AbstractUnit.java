public static double calculateStrength(Specification spec, List<AbstractUnit> units) {
    return sumDouble(units, au -> au.getOffence(spec));
}