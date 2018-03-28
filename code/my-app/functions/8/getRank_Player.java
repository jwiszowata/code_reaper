public int getRank() {
    int ret = (isEuropean()) ? 1 : 0;
    if (isAI())
        ret |= 2;
    if (isAdmin())
        ret |= 4;
    return ret;
}