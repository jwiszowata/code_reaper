public void setData(java.util.Map<String, String> statsData) {
    this.data = new Object[2][statsData.size()];
    int i = 0;
    for (Entry<String, String> e : mapEntriesByKey(statsData)) {
        data[NAME_COLUMN][i] = e.getKey();
        data[VALUE_COLUMN][i] = e.getValue();
        i++;
    }
}