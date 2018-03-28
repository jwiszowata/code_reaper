public void addFather(FoundingFather father) {
    foundingFathers.add(father);
    addFeatures(father);
    for (Colony c : getColonyList()) c.invalidateCache();
}