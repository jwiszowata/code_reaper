public int evaluateFor(Player player) {
    int result = 0;
    for (Unit u : getUnitList()) {
        int v = u.evaluateFor(player);
        if (v == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        result += v;
    }
    return result;
}