import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String artist;
    private String name; // song name
    private List<Song> songs;

    public Album() {
    }

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs = new ArrayList<Song>();

    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    // fuctionalites
    //find song
    public boolean findsong(String name){ // name of song
        for(Song song : songs){
            if(song.getTitle().equals(name)){ // to see fuctinality of equals. click on control + keep cursor on equals
                return true;
            }
        }
        return false;
    }
    // add song
    public String addsongToAlbum(String title,double duration){
        if(!findsong(title)){
            Song song = new Song(title,duration);
            this.songs.add(song);
            return"song added successfully";
        }
        return "Song already exits";
    }
    public String addtoplaylistfromalbum(String title, LinkedList<Song>playlist){
        for(Song song : this.songs){
            if(song.getTitle().equals(title)){
                playlist.add(song);
                return "Song has been added successfully";
            }
        }
        return "Song does'nt exits in album";
    }
    //we can also add song to playlist based on song number
    // we used polymorphism - method overloading
    public  String addtoplaylistfromalbum(int songno , LinkedList<Song> playlist){
        int index = songno-1; // index start ffrom 0 but songno in app are start from 1 so we are substractiong -1 from songno
        if(index >0 && index< songs.size()){
            playlist.add(songs.get(index));
            return "Song added successfully ";
        }
        return "Incorrect song number";
    }

}
