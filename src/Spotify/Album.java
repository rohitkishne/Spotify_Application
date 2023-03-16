package Spotify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    public String albumName;
    public String artistName;
    public List<Song> songList;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }

    //check whether song is present in album or not
    //if present then we simply return true;
    //otherwise return false;
    boolean findSong(String title) {
        for (Song song : songList) {
            if ((song.title).equals(title)) {
                return true;
            }
        }
        return false;
    }


    //create a addSongToAlbum function
    //add a song to the album
    public String addSongToAlbum(String title, double duration) {
        //search a song in songlist
        //if found --> already present in album, dont add it
        //otherwise add it in songlist
        if (!findSong(title)) {
            Song song = new Song(title, duration);
            songList.add(song);
            return "Song is Successfully Added";
        }
        return "Song is already Present in the Album";
    }

    //create a addSongToPlaylist function
    //add song to playlist
    public String addSongToPlayList(String title, LinkedList<Song> playlist) {

        //first search a perticular song with title
        //if find the song i.e., present in album --> add it

        for (Song song : songList) {
            if ((song.title).equals(title)) {
                playlist.add(song);
                return "Song has been Successfully added in PlayList";
            }
        }
        return "Song is not Exist";
    }

    public String addSongToPlayList(int trackNo, LinkedList<Song> playlist)
    {
        // track no shows the song present at trackNo-1 in songlist
        // it present ---> add it
        //otherwise shows --> not present in songlist as trackno-1 is not exist

        int index = trackNo-1;
        if(index>=0 && index<this.songList.size())
        {
            Song song = this.songList.get(index);
            playlist.add(song);
            return "Song has been Successfully added";
        }
        return "Song is not Trackable";
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumName='" + albumName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", songList=" + songList +
                '}';
    }
}
