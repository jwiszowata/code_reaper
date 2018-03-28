public final StringTemplate getReplacement(String key) {
    if (this.keys != null && this.replacements != null) {
        for (int index = 0; index < this.keys.size(); index++) {
            if (key.equals(this.keys.get(index))) {
                return (this.replacements.size() <= index) ? null : this.replacements.get(index);
            }
        }
    }
    return null;
}