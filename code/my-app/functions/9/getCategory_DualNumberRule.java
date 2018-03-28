public Category getCategory(double input) {
    if (input == 1) {
        return Category.one;
    } else if (input == 2) {
        return Category.two;
    } else {
        return Category.other;
    }
}