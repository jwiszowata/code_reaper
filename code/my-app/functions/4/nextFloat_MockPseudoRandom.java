public float nextFloat() {
    int number = getNext();
    return (number < 0) ? random.nextFloat() : number * scale;
}