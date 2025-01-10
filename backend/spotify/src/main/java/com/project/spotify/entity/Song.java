package com.project.spotify.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String title;
    String album;
    long duration; // in seconds
    String filePath; // path to the audio file
    String coverImagePath; // path to the cover image file

    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "TEXT")
    String lyrics; // lyrics of the song
    String genre; // genre of the song
    long listens; // number of listens
    LocalDate releaseDate; // release date of the song
    boolean isPremiumOnly; // whether the song is only available for premium users

    @ManyToMany(mappedBy = "songs")
    Set<Playlist> playlists;

    @ManyToMany
    @JoinTable(
            name = "song_has_genre",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_name")
    )
    Set<Genre> genres;

    @ManyToMany(mappedBy = "favouriteSongs")
    Set<Account> accounts;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    Account owner;

    @ManyToMany
    @JoinTable(
            name = "song_collaborators",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    Set<Account> collaborators;
}