public Integer getValue(Game game) {
    return (this.value != null) ? this.value : (this.scopeLevel == ScopeLevel.GAME) ? calculateGameValue(game) : null;
}