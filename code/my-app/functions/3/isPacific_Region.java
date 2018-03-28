public boolean isPacific() {
    return PACIFIC_KEY.equals(this.key) || (this.parent != null && this.parent.isPacific());
}