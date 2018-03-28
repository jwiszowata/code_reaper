public String checkSortConsistency() {
    LogBuilder lb = new LogBuilder(256);
    lb.add("AI object sort inconsistencies");
    lb.mark();
    AIObject[] objects = getAIObjects().toArray(new AIObject[0]);
    for (int i0 = 0; i0 < objects.length; i0++) {
        for (int i1 = i0 + 1; i1 < objects.length; i1++) {
            int c0 = objects[i0].compareTo(objects[i1]);
            int c1 = objects[i1].compareTo(objects[i0]);
            if (c0 == 0 && c1 == 0)
                continue;
            if (c0 == -1 && c1 == 1)
                continue;
            if (c0 == 1 && c1 == -1)
                continue;
            lb.add("\n  ", objects[i0], " ", objects[i1], " = ", c0, "/", c1);
        }
    }
    return (lb.grew()) ? lb.toString() : null;
}