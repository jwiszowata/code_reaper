public static Scope makeNegatedPersonScope() {
    Scope scope = new Scope();
    scope.setAbilityId("model.ability.person");
    scope.setMatchNegated(true);
    return scope;
}