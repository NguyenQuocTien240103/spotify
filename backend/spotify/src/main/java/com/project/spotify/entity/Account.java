package com.project.spotify.entity;

import com.project.spotify.enums.Plan;
import com.project.spotify.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Account {
    @Id
    String email; // use as username
    String password; // use as password
    String phone; // use as recovery phone number
    String username; // use as show name
    String avatarPath;
    String country;
    Date birthDate;
    Role role;
    Plan plan;
    boolean isActive;
    boolean isDeleted; // for soft delete

    /* ============================= Follow Relationship ============================= */
    @ManyToMany
    @JoinTable(
            name = "account_follows_account",
            joinColumns = @JoinColumn(name = "follower_account_id"),
            inverseJoinColumns = @JoinColumn(name = "followed_account_id")
    )
    Set<Account> followingAccounts;

    @ManyToMany(mappedBy = "followingAccounts")
    Set<Account> followedAccounts;

    /* ============================= Playlist Relationship ============================= */
    @ManyToMany
    @JoinTable(
            name = "account_has_playlist",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "playlist_id")
    )
    Set<Playlist> playlists;

    /* =========================== Fav Playlist Relationship =========================== */
    @ManyToMany
    @JoinTable(
            name = "account_favourite_playlist",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "playlist_id")
    )
    Set<Playlist> favouritePlaylists;

    /* ============================= Fav Song Relationship ============================= */
    @ManyToMany
    @JoinTable(
            name = "account_favourite_song",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    Set<Song> favouriteSongs;

    /* =========================== Collaborators Relationship =========================== */
    @ManyToMany(mappedBy = "collaborators")
    Set<Song> collaboratedSongs;
}