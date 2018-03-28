public int nextInt(int n) {
    int number = getNext();
    if (number < 0 || number >= n) {
        System.err.println("MockPseudoRandom out of range: " + number);
        return random.nextInt(n);
    }
    return number;
}