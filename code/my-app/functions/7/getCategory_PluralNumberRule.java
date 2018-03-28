public Category getCategory(double input) {
    if (input == 1) {
        return Category.one;
    } else {
        return Category.other;
    }
}