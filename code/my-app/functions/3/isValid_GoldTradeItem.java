public boolean isValid() {
    return gold >= 0 && getSource().checkGold(gold);
}