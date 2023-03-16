package Spotify;

import java.util.*;

public class Main {
    public static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        Album album = new Album("Rolling Papers", "Wiz khalifa");

        album.addSongToAlbum("When I'm Gone", 4.08);
        album.addSongToAlbum("On My Level", 4.32);
        album.addSongToAlbum("Black and Yellow",3.37);

        albums.add(album);

        album = new Album("Rang De Basanti", "A.R. Rehman");

        album.addSongToAlbum("Roobaroo", 4.42);
        album.addSongToAlbum("Masti Ki Pathshala", 3.39);
        album.addSongToAlbum("Luka Chuppi",6.36);

        albums.add(album);

        LinkedList<Song> playlist_1 = new LinkedList<>();

        albums.get(0).addSongToPlayList("Black and Yellow", playlist_1);
        albums.get(0).addSongToPlayList("On My Level", playlist_1);
        albums.get(1).addSongToPlayList("Masti Ki Pathshala", playlist_1);
        albums.get(1).addSongToPlayList("Roobaroo", playlist_1);

        runApplication(playlist_1);



    }
    public static void runApplication(LinkedList<Song> playlist ){

        ListIterator<Song> listIterator = playlist.listIterator();

        //validation check
        if(playlist.size()==0)
        {
            return;
        }
        Scanner sc = new Scanner(System.in);
        playlistMenu();
        System.out.println("Now Playing : "+listIterator.next());

        boolean forward = true;
        boolean quit = false;

        while(quit == false){

            int press = sc.nextInt();

            switch(press) {
                case 1:
                    //play next song
                    if(playlist.size()==0)
                    {
                        System.out.println("No song Present in your playlist");
                    }
                    else
                    {
                        if(forward == false)
                        {
                            listIterator.next();
                            forward = true;
                        }
                        if(listIterator.hasNext())
                        {
                            System.out.println("Now Playing : "+listIterator.next());
                        }
                        else
                        {
                            System.out.println("You are already at the last Song");
                        }
                    }

                    break;
                case 2:
                    //play prev song
                    if(playlist.size()==0)
                    {
                        System.out.println("No song Present in your playlist");
                    }
                    else
                    {
                        if(forward == true)
                        {
                            listIterator.previous();
                            forward = false;
                        }

                        if(listIterator.hasPrevious())
                        {
                            System.out.println("Now Playing : "+listIterator.previous());
                        }
                        else
                        {
                            System.out.println("You are already at the first song");
                        }
                    }
                    break;
                case 3:
                    //Replay current song
                    if(playlist.size()==0)
                    {
                        System.out.println("No song Present in your playlist");
                    }
                    else
                    {
                        if(forward == true)
                        {
                            System.out.println("Now Playing : "+listIterator.previous());
                            forward = false;
                        }
                        else
                        {
                            System.out.println("Now Playing : "+listIterator.next());
                            forward = true;
                        }
                    }
                    break;
                case 4:
                    //Show Playlist
                    if(playlist.size()==0)
                    {
                        System.out.println("No song Present in your playlist");
                    }
                    else
                    {
                        showPlaylist(playlist);
                    }

                    break;
                case 5:
                    //See Playlist Menu
                    playlistMenu();
                    break;
                case 6:
                    //Delete Current Song
                    if(playlist.size()==0)
                    {
                        System.out.println("No song Present in your playlist");
                    }
                    else
                    {
                        if(forward == true)
                        {
                            System.out.println("You have Deleted the Current "+ listIterator.previous().toString() +"Successfully.");
                            listIterator.remove();
                            if(listIterator.hasPrevious())
                            {
                                listIterator.previous();
                                forward = false;
                            }
                            else if(listIterator.hasNext())
                            {
                                listIterator.next();
                                forward = true;
                            }
                            else
                            {
                                System.out.println("Your Playlist is Empty Now.");
                            }
                        }
                        else
                        {
                            System.out.println("You have Deleted the Current "+ listIterator.next().toString() +"Successfully.");
                            listIterator.remove();
                            if(listIterator.hasNext())
                            {
                                listIterator.next();
                                forward = true;
                            }
                            else if(listIterator.hasPrevious())
                            {
                                listIterator.previous();
                                forward = false;
                            }
                            else
                            {
                                System.out.println("Your Playlist is Empty Now.");
                            }
                        }
                    }

                    break;
                case 0:
                    //Exit
                    quit = true;
                    break;
            }
        }
        System.out.println("Exit");
    }
    public static void showPlaylist(LinkedList<Song> song)
    {
        ListIterator<Song> listIterator = song.listIterator();
        while(listIterator.hasNext())
        {
            System.out.println(listIterator.next().toString());
        }
    }
    public static void playlistMenu(){
        System.out.println("Access the Playlist Menu");
        System.out.println("Enter 1 --> To Play Next Song");
        System.out.println("Enter 2 --> To Play Previous Song");
        System.out.println("Enter 3 --> To Repeat Current Song");
        System.out.println("Enter 4  --> To See Playlist");
        System.out.println("Enter 5 --> To See PlayList Menu");
        System.out.println("Enter 6 --> To Delete Current Song");
        System.out.println("Enter 0 --> To Exit");
    }
}