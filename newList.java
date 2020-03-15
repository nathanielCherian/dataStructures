public class newList {

    Node head; // making the first head pointer

    static class Node {

        int strLength;
        String str;
        Node next;

        Node(int d, String s) {
            strLength = d;
            str = s;
            next = null;

        }


    }

    public static newList insert(newList list, int strLength, String str) {
        Node newNode = new Node(strLength, str);
        newNode.next = null;         // setting up the new node

        if (list.head == null){
            list.head = newNode;
        }else {
            Node current = list.head;
            while (true) {
                if(newNode.strLength >= list.head.strLength){ // first case H->8 insert 9
                    newNode.next = list.head;
                    list.head = newNode;
                    break;
                }else if (newNode.strLength >= current.strLength){ // middle condition ->8->7->6
                     newNode.next = current.next;
                     current.next = newNode;
                     break;
                 }else if(current.next == null){  // last condition ->4->3->null
                    current.next = newNode;
                    break;
                }
                current= current.next;
            } // end of while

        }
        return list;
    }


    public static void printList(newList list){
        Node currentNode = list.head;
        while (currentNode != null){
            System.out.print(currentNode.strLength + " " + currentNode.str + " | ");
            currentNode = currentNode.next;

        }

    }



    public static void main(String[] args) {
        newList list = new newList();

        String[] strArray = new String[] {"able", "ale", "apple", "bale", "kangaroo"};


        for (int i = 0; i < strArray.length; i++){
            list = insert(list, strArray[i].length(), strArray[i]);

        }
/*
        list = insert(list, wrd.length(), wrd);
        list = insert(list, wrd2.length(), wrd2);
        list = insert(list, wrd.length(), wrd); */


        printList(list);
    }
}
