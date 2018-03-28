public Color forceDefaultColor() {
    Color ret = defaultColors.get(getId());
    setColor(ret);
    return ret;
}