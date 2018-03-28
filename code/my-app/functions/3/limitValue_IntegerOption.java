public int limitValue(int value) {
    return Math.min(Math.max(value, this.minimumValue), this.maximumValue);
}