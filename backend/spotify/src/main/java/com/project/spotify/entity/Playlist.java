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
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;
    String description;
    String coverImagePath;
    LocalDate createdAt;
    LocalDate updatedAt;
    boolean isPublic;

    @ManyToMany(mappedBy = "playlists")
    Set<Account> accounts;

    @ManyToMany(mappedBy = "favouritePlaylists")
    Set<Account> favouriteAccounts;

    @ManyToMany
    @JoinTable(
            name = "playlist_has_song",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    Set<Song> songs;
}