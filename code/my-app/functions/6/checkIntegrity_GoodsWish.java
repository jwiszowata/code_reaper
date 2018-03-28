public int checkIntegrity(boolean fix) {
    int result = super.checkIntegrity(fix);
    if (goodsType == null || amountRequested <= 0)
        result = -1;
    return result;
}