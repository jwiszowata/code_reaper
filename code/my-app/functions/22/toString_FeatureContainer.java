public String toString() {
    StringBuilder sb = new StringBuilder(256);
    sb.append("[FeatureContainer");
    int siz = sb.length();
    for (Ability ability : iterable(getAbilities(null, null, null))) {
        sb.append(' ').append(ability);
    }
    if (sb.length() > siz) {
        sb.insert(siz, " [abilities");
        sb.append(']');
    }
    siz = sb.length();
    for (Modifier modifier : iterable(getModifiers(null, null, null))) {
        sb.append(' ').append(modifier);
    }
    if (sb.length() > siz) {
        sb.insert(siz, "[modifiers");
        sb.append(']');
    }
    sb.append(']');
    return sb.toString();
}