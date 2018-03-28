public boolean retry() {
    return tries++ < MAX_TRY;
}