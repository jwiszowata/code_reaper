public List<AbstractGoods> getRequiredGoodsList(int roleCount) {
    List<AbstractGoods> result = getRequiredGoodsList();
    if (roleCount > 1 && !result.isEmpty()) {
        for (AbstractGoods ag : result) {
            ag.setAmount(roleCount * ag.getAmount());
        }
    }
    return result;
}