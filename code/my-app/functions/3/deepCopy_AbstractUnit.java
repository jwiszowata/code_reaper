public static List<AbstractUnit> deepCopy(List<AbstractUnit> units) {
    return transform(units, alwaysTrue(), au -> new AbstractUnit(au.getId(), au.getRoleId(), au.getNumber()));
}