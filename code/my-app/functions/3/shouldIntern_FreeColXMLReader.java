public boolean shouldIntern() {
    return this.readScope != ReadScope.NOINTERN;
}