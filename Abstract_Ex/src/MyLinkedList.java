public class MyLinkedList implements NodeList {

    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem itemToAdd) {

        if (itemToAdd == null)
            return false;

        if (root == null) {
            root = itemToAdd;
            return true;
        }
        var currentItem = root;
        while (currentItem != null) {
            int value = currentItem.compareTo(itemToAdd);
            if (value == 0) {
                return false;
            } else if (value > 0) {
                if (currentItem.previous() == null) {
                    currentItem.setPrevious(itemToAdd);
                    itemToAdd.setNext(currentItem);
                    root = itemToAdd;
                } else {
                    var prev = currentItem.previous();
                    prev.setNext(itemToAdd);
                    itemToAdd.setPrevious(prev);
                    currentItem.setPrevious(itemToAdd);
                    itemToAdd.setNext(currentItem);
                }
                return true;
            } else { // value < 0
                if (currentItem.next() == null) {
                    currentItem.setNext(itemToAdd);
                    itemToAdd.setPrevious(currentItem);
                    return true;
                } else {
                    currentItem = currentItem.next();
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem itemToRemove) {
        if (itemToRemove == null) {
            return false;
        }
        var currentItem = root;

        while (currentItem != null) {
            int value = currentItem.compareTo(itemToRemove);
            if (value == 0) {
                if (currentItem == root) {
                    root = currentItem.next();
                } else {
                    var prev = currentItem.previous(); //5
                    var next = currentItem.next(); //9
                    prev.setNext(next);
                    if (next != null) {
                        next.setPrevious(prev);
                    }
                }
                return true;
            } else if (value < 0) {
                currentItem = currentItem.next();
            } else {
                return false; // smallest item
            }
        }
        return false; // largest item
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
            return;
        }
        var currentItem = root;
        while (currentItem != null) {
            System.out.println(currentItem.getValue());
            currentItem = currentItem.next();
        }
    }
}
