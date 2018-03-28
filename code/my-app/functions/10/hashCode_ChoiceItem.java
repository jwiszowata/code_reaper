public int hashCode() {
    int hash = super.hashCode();
    hash = 31 * hash + Utils.hashCode(this.text);
    hash = 31 * hash + Utils.hashCode(this.object);
    hash = 31 * hash + ((this.enabled) ? 1 : 0);
    hash = 31 * hash + ((this.optionOK) ? 1 : 0);
    hash = 31 * hash + ((this.optionCancel) ? 1 : 0);
    hash = 31 * hash + ((this.optionDefault) ? 1 : 0);
    return hash;
}