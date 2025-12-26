public class Node extends ListItem {
    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem li) {
        this.rightLink = li;
        return this.rightLink;
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem li) {
        this.leftLink = li;
        return this.leftLink;
    }

    @Override
    int compareTo(ListItem li) {
        //return this.getValue().toString().compareTo(li.getValue().toString());
        return ((Integer) this.getValue()).compareTo((Integer) li.getValue());
    }

}
