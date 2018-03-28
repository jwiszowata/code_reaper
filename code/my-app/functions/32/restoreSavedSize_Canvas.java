public void restoreSavedSize(Component comp, Dimension d) {
    final Dimension pref = comp.getPreferredSize();
    final Dimension sugg = (d == null) ? pref : d;
    boolean save = false;
    Dimension size = getSavedSize(comp);
    if (size == null) {
        size = new Dimension(pref);
        save = true;
    }
    if (size.width < sugg.width) {
        size.width = sugg.width;
        save = true;
    }
    if (size.height < sugg.height) {
        size.height = sugg.height;
        save = true;
    }
    if (size.width < pref.width) {
        size.width = pref.width;
        save = true;
    }
    if (size.height < pref.height) {
        size.height = pref.height;
        save = true;
    }
    if (save) {
        saveSize(comp, size);
    }
    if (!pref.equals(size)) {
        comp.setPreferredSize(size);
    }
}