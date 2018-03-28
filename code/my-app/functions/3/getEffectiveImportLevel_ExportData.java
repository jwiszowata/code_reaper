public final int getEffectiveImportLevel(int capacity) {
    return (this.importLevel >= 0) ? this.importLevel : capacity;
}