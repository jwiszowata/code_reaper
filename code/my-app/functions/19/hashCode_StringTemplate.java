public int hashCode() {
    int hash = super.hashCode();
    hash = 31 * hash + this.templateType.ordinal();
    hash = 31 * hash + Utils.hashCode(this.defaultId);
    switch(this.templateType) {
        case TEMPLATE:
            for (String key : getKeys()) {
                hash = 31 * hash + Utils.hashCode(key);
            }
        case LABEL:
            for (StringTemplate replacement : getReplacements()) {
                hash = 31 * hash + Utils.hashCode(replacement);
            }
            break;
        default:
            break;
    }
    return hash;
}