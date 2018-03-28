public boolean isValid() {
    return (this.scopeType == WriteScopeType.CLIENT) == (this.player != null);
}