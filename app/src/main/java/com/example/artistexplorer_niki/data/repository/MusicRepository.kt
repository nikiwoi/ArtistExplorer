package com.example.artistexplorer_niki.data.repository

import com.example.artistexplorer_niki.data.dto.AlbumArtisResponse
import com.example.artistexplorer_niki.data.dto.AlbumResponse
import com.example.artistexplorer_niki.data.dto.ArtistResponse
import com.example.artistexplorer_niki.data.dto.TrackResponse
import com.example.artistexplorer_niki.data.service.MusicService

class MusicRepository(private val api: MusicService) {
    suspend fun getAlbum(): AlbumArtisResponse {
        return api.searchAlbums(artistName = "Taylor%20Swift")
    }

    suspend fun getAlbumDetail(albumId: String): AlbumResponse {
        return api.getAlbumDetail(albumId = albumId)
    }

    suspend fun getAlbumTracks(albumId: String): TrackResponse{
        return api.getAlbumTracks(albumId = albumId)
    }

    suspend fun getArtist(): ArtistResponse {
        return api.searchArtist(artistName = "Taylor%20Swift")
    }
}