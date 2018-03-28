public int getStarvationTurns() {
    final GoodsType foodType = getSpecification().getPrimaryFoodType();
    final int food = getGoodsCount(foodType);
    final int newFood = getAdjustedNetProductionOf(foodType);
    return (newFood >= 0) ? -1 : food / -newFood;
}