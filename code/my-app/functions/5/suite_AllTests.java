public static Test suite() {
    TestSuite suite = new TestSuite("Test for net.sf.freecol.client.control");
    suite.addTestSuite(MoveTest.class);
    return suite;
}