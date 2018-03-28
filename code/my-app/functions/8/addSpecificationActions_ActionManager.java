public void addSpecificationActions(Specification spec) {
    for (TileImprovementType type : spec.getTileImprovementTypeList()) {
        if (!type.isNatural()) {
            add(new ImprovementAction(freeColClient, type));
        }
    }
    update();
}