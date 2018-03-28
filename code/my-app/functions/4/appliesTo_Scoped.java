default default boolean appliesTo(FreeColObject object) {
    List<Scope> scopes = getScopeList();
    return (scopes == null || scopes.isEmpty()) ? true : any(scopes, s -> s.appliesTo(object));
}