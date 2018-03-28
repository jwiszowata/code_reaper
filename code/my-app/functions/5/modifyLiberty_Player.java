public void modifyLiberty(int amount) {
    setLiberty(Math.max(0, liberty + amount));
    if (isRebel())
        interventionBells += amount;
}