private void append(StringBuilder result, String key, List<AbstractGoods> list) {
    if (list.isEmpty())
        return;
    result.append(key).append(": ");
    for (AbstractGoods goods : list) {
        result.append(goods);
        if (goods.getType().getStoredAs() != goods.getType()) {
            result.append(" [").append(goods.getType().getStoredAs().getId()).append(']');
        }
        result.append(", ");
    }
    int length = result.length();
    result.replace(length - 2, length, "\n");
}