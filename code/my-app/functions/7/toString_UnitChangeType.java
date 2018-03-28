public String toString() {
    StringBuilder sb = new StringBuilder(32);
    sb.append(this.from.getSuffix()).append("->").append(this.to.getSuffix()).append('/').append(this.probability);
    if (this.turns > 0)
        sb.append('/').append(this.turns);
    return sb.toString();
}