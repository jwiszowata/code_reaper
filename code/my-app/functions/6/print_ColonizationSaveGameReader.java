public void print() {
    System.out.println(name + " [" + x + ", " + y + "], " + numberOfColonists + " colonists");
    for (Colonist colonist : colonists) {
        colonist.print();
    }
}