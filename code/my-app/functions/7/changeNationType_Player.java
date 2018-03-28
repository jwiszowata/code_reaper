public void changeNationType(NationType newNationType) {
    if (nationType != null)
        removeFeatures(nationType);
    setNationType(newNationType);
    if (newNationType != null)
        addFeatures(newNationType);
}