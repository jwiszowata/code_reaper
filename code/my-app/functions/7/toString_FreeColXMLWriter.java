public String toString() {
    String ret = super.toString();
    if (this.scopeType == WriteScopeType.CLIENT) {
        ret += ":" + ((this.player == null) ? "INVALID" : this.player.getId());
    }
    return ret;
}