private static int[] nextBranch(int[] branches) {
    for (int index = 0; index < branches.length; index++) {
        if (branches[index] == 2) {
            branches[index] = 0;
        } else {
            branches[index]++;
            break;
        }
    }
    return branches;
}