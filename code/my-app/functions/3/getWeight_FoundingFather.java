public int getWeight(int age) {
    return (age >= 0 && age < weight.length) ? weight[age] : 0;
}