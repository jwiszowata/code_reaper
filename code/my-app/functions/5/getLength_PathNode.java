public int getLength() {
    int n = 0;
    for (PathNode temp = this; temp != null; temp = temp.next) n++;
    return n;
}