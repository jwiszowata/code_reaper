public void changeWorkType(GoodsType type) {
    setWorkType(type);
    if (type != null)
        experienceType = type;
    WorkLocation wl = getWorkLocation();
    if (wl != null)
        wl.updateProductionType();
}