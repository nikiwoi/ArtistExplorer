package com.example.artistexplorer_niki.data.service

import com.example.artistexplorer_niki.data.dto.AlbumArtisResponse
import com.example.artistexplorer_niki.data.dto.AlbumResponse
import com.example.artistexplorer_niki.data.dto.ArtistResponse
import com.example.artistexplorer_niki.data.dto.TrackResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicService {
    @GET("search.php")
    suspend fun searchArtist(
        @Query("s") artistName: String
    ): ArtistResponse

    @GET("searchalbum.php")
    suspend fun searchAlbums(
        @Query("s") artistName: String
    ): AlbumArtisResponse


    @GET("album.php")
    suspend fun getAlbumDetail(
        @Query("m") albumId: String
    ): AlbumResponse


    @GET("track.php")
    suspend fun getAlbumTracks(
        @Query("m") albumId: String
    ): TrackResponse

}