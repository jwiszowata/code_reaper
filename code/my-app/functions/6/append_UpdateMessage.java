private void append(FreeColObject fco, List<String> flds) {
    if (fco != null && FreeColGameObject.class.isAssignableFrom(fco.getClass())) {
        this.fcgos.add((FreeColGameObject) fco);
        this.fields.add(flds);
    }
}