import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
    Album tejaalbum = new Album("Teja","mujike");
    Album kanthialbum = new Album("Kranthi","dere dere");

    //add songs to album teja
    tejaalbum.addsongToAlbum("Tinmar",3.6);
    tejaalbum.addsongToAlbum("Dichak",4.6);
    tejaalbum.addsongToAlbum("jil jil jiga",3.8);
    tejaalbum.addsongToAlbum("milky beauty",2.8);

    // add songs to album kranthi
        kanthialbum.addsongToAlbum("Sakhiya",4.5);
        kanthialbum.addsongToAlbum("Cheliya Cheliya",4.7);
        kanthialbum.addsongToAlbum("Priya Priyathama",3.5);
        kanthialbum.addsongToAlbum("challagali",3.8);

        //create playlist
        LinkedList<Song> myplaylist = new LinkedList<>();
        //add songs from album to playlist
        System.out.println(tejaalbum.addtoplaylistfromalbum("Dichak",myplaylist));
        System.out.println(tejaalbum.addtoplaylistfromalbum(3,myplaylist));
        System.out.println(tejaalbum.addtoplaylistfromalbum("Dichaki",myplaylist));
        System.out.println(tejaalbum.addtoplaylistfromalbum(7,myplaylist));
        System.out.println(kanthialbum.addtoplaylistfromalbum("Sakhiya",myplaylist));
        System.out.println(kanthialbum.addtoplaylistfromalbum(3,myplaylist));
        System.out.println(kanthialbum.addtoplaylistfromalbum("sakhiyai",myplaylist));
        play(myplaylist);

    }

    private static void play(LinkedList<Song> myplaylist) {
        if(myplaylist.size() ==0){
            System.out.println("your playlist is empty");
            return;
        }
        ListIterator<Song> itr = myplaylist.listIterator();
        System.out.println("Now playing"+itr.next());
        boolean wasnext = true; // intially it goes to next song so true
        Scanner sc = new Scanner(System.in);
        PrintMenu();
        boolean quit = false;
        while(!quit){
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    PrintMenu();
                    break;
                case 2:
                    if(wasnext==false){ // it means we are coming ffrom privous we need to jump one more extra next
                        itr.next();
                        wasnext=true;
                    }
                    if(!itr.hasNext()){ // hasnext will say whether we have next node or not
                        System.out.println("you have reached the end of the playlist");
                    }else{
                        System.out.println("currently playing : "+itr.next());
                        wasnext=true;
                    }
                    break;
                case 3:
                    if(wasnext== true){ // it means we are coming from  next so we need to jump one more extra proivous
                        itr.previous();
                        wasnext=false;
                    }
                    if(!itr.hasPrevious()){ //hasprevious  will say whether we have privious  node or not
                        System.out.println("your at the start of the playlist");
                    } else{
                        System.out.println("Previous song is :"+itr.previous());
                        wasnext=false;
                    }
                    break;
                case 4:
                    if(wasnext==true){
                        System.out.println("currently playing : "+itr.previous());
                        wasnext=false;
                    } else{
                        System.out.println("currently playing: "+itr.next());
                        wasnext=true;
                    }
                    break;
                case 5:
                    break;
                case 6:
                    printsong(myplaylist);
                    break;
                case 7:
                    quit=true;
                    break;
                default:
                    System.out.println("Wrong choice.please enter again");

            }
        }
        return;
    }

    private static void printsong(LinkedList<Song> myplaylist) {
        for(Song song : myplaylist){
            System.out.println(song);
        }
        return;
    }

    private static void PrintMenu() {
        System.out.println("1.Show the menu again");
        System.out.println("2.play next song");
        System.out.println("3.play previous song");
        System.out.println("4.play current song again");
        System.out.println("5.Delete current song from playlist");
        System.out.println("6.print all the songs from playlist");
        System.out.println("7.Quit Application");
    }

    }


