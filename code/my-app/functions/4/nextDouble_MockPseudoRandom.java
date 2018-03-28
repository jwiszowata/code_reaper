public double nextDouble() {
    int number = getNext();
    return (number < 0) ? random.nextDouble() : number * scale;
}