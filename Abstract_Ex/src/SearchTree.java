public class SearchTree implements NodeList {
    private ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem itemToAdd) {
        if (itemToAdd == null) {
            return false;
        }
        if (root == null) {
            root = itemToAdd;
            return true;
        }
        var currentItem = root;
        while (currentItem != null) {
            int res = currentItem.compareTo(itemToAdd);
            if (res == 0) {
                return false;
            }
            if (res > 0) {
                if (currentItem.previous() == null) {
                    currentItem.setPrevious(itemToAdd);
                    return true;
                } else {
                    currentItem = currentItem.previous();
                }
            } else { // res < 0
                if (currentItem.next() == null) {
                    currentItem.setNext(itemToAdd);
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
        if (itemToRemove == null)
            return false;

        var currentItem = root;
        var parentItem = currentItem;

        while (currentItem != null) {
            var res = currentItem.compareTo(itemToRemove);
            if (res == 0) {
                performRemoval(currentItem, parentItem);
                return true;
            } else if (res > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                parentItem = currentItem;
                currentItem = currentItem.next();
            }
        }
        return false;
    }

    private void performRemoval(ListItem itemToRemove, ListItem parent) {

        if(itemToRemove.next() == null){    //no right child
            if(itemToRemove == parent.next()){ // right child?
                parent.setNext(itemToRemove.previous());
            } else if (itemToRemove == parent.previous()) { // left child?
                parent.setPrevious(itemToRemove.previous());
            } else{
                root = itemToRemove.previous();
            }
        } else if (itemToRemove.previous() == null) {   // no left child
            if(itemToRemove == parent.next()){
                parent.setNext(itemToRemove.next());
            } else if (itemToRemove == parent.previous()) {
                parent.setPrevious(itemToRemove.next());
            } else {
                root = itemToRemove.next();
            }
        } else{ // two children
            var currentItem = itemToRemove.next();
            var leftParent = currentItem;

            while(currentItem.previous() != null){
                leftParent = currentItem;
                currentItem = currentItem.previous();
            }
            itemToRemove.setValue(currentItem.getValue());
            if(leftParent == itemToRemove){
                itemToRemove.setNext(currentItem.next());
            }
            else{
                leftParent.setPrevious(currentItem.next());
            }
        }

    }

    @Override
    public void traverse(ListItem root) {

        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
