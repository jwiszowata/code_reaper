private int getClassIndex(Object object) {
    if (object instanceof FreeColObject) {
        return ((FreeColObject) object).getClassIndex();
    } else {
        return 1000;
    }
}