public String getFeatureString() {
    String k = getKey();
    if (k == null) {
        k = "";
    } else {
        k = Messages.getName(k);
        if (isMatchNegated())
            k = "!" + k;
    }
    return k;
}