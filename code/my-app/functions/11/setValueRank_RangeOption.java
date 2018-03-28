public void setValueRank(int rank) {
    int curValue = UNDEFINED;
    Iterator<Integer> iterator = getItemValues().keySet().iterator();
    while (rank >= 0) {
        if (!iterator.hasNext())
            break;
        curValue = iterator.next();
        rank--;
    }
    setValue(curValue);
}