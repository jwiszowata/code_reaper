public final Stream<Scope> getScopes() {
    return (this.scopes == null) ? Stream.<Scope>empty() : this.scopes.stream();
}