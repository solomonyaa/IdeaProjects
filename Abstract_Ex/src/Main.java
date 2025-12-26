public class Main {

    public static void main(String[] args) {

        /*MyLinkedList mli = new MyLinkedList(null);
        for (int i = -1; i <= 10; i++) {
            ListItem li = new Node(i);
            mli.addItem(li);
        }
        ListItem li1 = new Node(50);
        mli.addItem(li1);
        ListItem li2 = new Node(30);
        mli.addItem(li2);
        ListItem li3 = new Node(60);
        mli.addItem(li3);

        mli.traverse(mli.getRoot());

        System.out.println(mli.removeItem(new Node(-1)));
        System.out.println(mli.removeItem(new Node(10)));
        System.out.println(mli.removeItem(new Node(60)));
        System.out.println(mli.removeItem(new Node(100)));

        System.out.println("-".repeat(30));

        mli.traverse(mli.getRoot());*/

        SearchTree searchTree = new SearchTree(new Node(4));
        searchTree.addItem(new Node(2));
        searchTree.addItem(new Node(6));
        searchTree.addItem(new Node(1));
        searchTree.addItem(new Node(3));
        searchTree.addItem(new Node(5));
        searchTree.addItem(new Node(7));
        searchTree.addItem(new Node(8));
        searchTree.addItem(new Node(-5));


        searchTree.removeItem(new Node(4));



        searchTree.traverse(searchTree.getRoot());
    }
}