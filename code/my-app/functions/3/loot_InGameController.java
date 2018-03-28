public void loot(Unit unit, List<Goods> goods, String defenderId) {
    getGUI().showCaptureGoodsDialog(unit, goods, (List<Goods> gl) -> lootCargo(unit, gl, defenderId));
}