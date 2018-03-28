public int getRequiredDefenders() {
    return getType().getMinimumSize() - 1;
}