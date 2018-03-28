public Modifier makeTeaPartyModifier() {
    final Specification spec = getGame().getSpecification();
    final Turn turn = getGame().getTurn();
    Modifier modifier = first(spec.getModifiers(Modifier.COLONY_GOODS_PARTY));
    if (modifier != null) {
        modifier = Modifier.makeTimedModifier("model.goods.bells", modifier, turn);
        modifier.setModifierIndex(Modifier.PARTY_PRODUCTION_INDEX);
    }
    return modifier;
}