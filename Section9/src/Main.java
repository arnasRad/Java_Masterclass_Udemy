import jdk.jshell.execution.Util;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Player arnas = new Player("Arnas", 10, 15);
//        System.out.println(arnas.toString());
//        Utils.saveObject(arnas);
//
//
//        arnas.setHitPoints(8);
//        System.out.println(arnas);
//        arnas.setWeapon("Stormbringer");
//        Utils.saveObject(arnas);
//        Utils.loadObject(arnas);
//        System.out.println(arnas);
//
//        Saveable wereworlf = new Monster("Werewolf", 20, 15);
//        System.out.println(wereworlf);
//        Utils.saveObject(wereworlf);


//        MusicApp app = new MusicApp();
//        app.run();

        ArrayList<IntegerNode> data = Utils.getRandomIntegerNodeArray(20, -159, 204);

        MyLinkedList<IntegerNode> myLinkedList = new MyLinkedList<>();
        for(IntegerNode integerNode : data) {
            myLinkedList.add(integerNode);
        }
        myLinkedList.print();


        MyLinkedList<StringNode> myStringLL = new MyLinkedList<>();
        String[] stringData = Utils.stringToArray("One two three four five this is great man im doin it", " ");
        for(String s : stringData) {
            myStringLL.add(new StringNode(s));
        }
        myStringLL.print();

    }
}
