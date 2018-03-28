private void setArrangementAttributes(List<Arrangement> arrangements) {
    int i = 0;
    for (Arrangement a : arrangements) {
        setStringAttribute(a.unitKey(i), a.unit.getId());
        setStringAttribute(a.locKey(i), a.loc.getId());
        if (a.work != null) {
            setStringAttribute(a.workKey(i), a.work.getId());
        }
        setStringAttribute(a.roleKey(i), a.role.toString());
        setStringAttribute(a.roleCountKey(i), String.valueOf(a.roleCount));
        i++;
    }
    setIntegerAttribute(FreeColObject.ARRAY_SIZE_TAG, i);
}