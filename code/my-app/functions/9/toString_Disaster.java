public String toString() {
    StringBuilder sb = new StringBuilder(64);
    sb.append('[').append(getId());
    for (RandomChoice<Effect> choice : getEffects()) {
        sb.append(' ').append(choice.getObject());
    }
    sb.append(']');
    return sb.toString();
}