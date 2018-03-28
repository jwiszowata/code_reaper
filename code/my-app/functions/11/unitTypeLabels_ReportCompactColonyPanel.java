private List<JLabel> unitTypeLabels(Map<UnitType, Integer> unitTypeMap, int maxSize, StringTemplate t) {
    List<JLabel> result = new ArrayList<>();
    int n = 0;
    for (Entry<UnitType, Integer> e : mapEntriesByValue(unitTypeMap, descendingIntegerComparator)) {
        ImageIcon icon = new ImageIcon(this.lib.getTinyUnitImage(e.getKey(), false));
        result.add(newLabel(Integer.toString(e.getValue()), icon, cPlain, t));
        if (++n >= maxSize)
            break;
    }
    return result;
}