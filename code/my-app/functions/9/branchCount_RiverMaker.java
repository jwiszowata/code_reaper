private static int branchCount(int[] branches) {
    int result = 0;
    for (int branche : branches) {
        if (branche > 0) {
            result++;
        }
    }
    return result;
}