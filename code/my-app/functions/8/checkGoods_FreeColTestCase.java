public void checkGoods(String err, List<AbstractGoods> goods, AbstractGoods... results) {
    List<AbstractGoods> check = new ArrayList<>(goods);
    for (AbstractGoods ag : results) {
        assertTrue(err + " requires " + ag, check.contains(ag));
        check.remove(ag);
    }
    assertTrue(err + " requires more goods", check.isEmpty());
}