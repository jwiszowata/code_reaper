public void fireChanges(List<AbstractGoods> req) {
    for (AbstractGoods ag : req) fireChanges(ag.getType(), ag.getAmount());
}