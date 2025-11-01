package com.example.artistexplorer_niki.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.artistexplorer_niki.data.container.RetrofitInstance.api
import com.example.artistexplorer_niki.data.dto.Album
import com.example.artistexplorer_niki.data.dto.AlbumResponse
import com.example.artistexplorer_niki.data.dto.Artist
import com.example.artistexplorer_niki.data.dto.Track
import com.example.artistexplorer_niki.data.repository.MusicRepository
import com.example.artistexplorer_niki.data.service.MusicService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MusicViewModel() : ViewModel() {
    private val repository = MusicRepository(api)
    private val _albums = MutableStateFlow<List<Album>>(emptyList())
    val albums: StateFlow<List<Album>> = _albums

    private val _artist = MutableStateFlow<List<Artist>>(emptyList())
    val artist: StateFlow<List<Artist>> = _artist
    private val _albumDetail = MutableStateFlow<AlbumResponse?>(null)
    val albumDetail: StateFlow<AlbumResponse?> = _albumDetail
    private val _albumTracks = MutableStateFlow<List<Track>>(emptyList())
    val albumTracks: StateFlow<List<Track>> = _albumTracks

    init {
        fetchArtist()
        fetchAlbums()
    }

    private fun fetchArtist() {
        viewModelScope.launch {
            try {
                val response = repository.getArtist()
                _artist.value = response.artists ?: emptyList()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun fetchAlbums() {
        viewModelScope.launch {
            try {
                val response = repository.getAlbum()
                _albums.value = response.album ?: emptyList()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun fetchAlbumDetail(albumId: String) {
        viewModelScope.launch {
            try {
                println("Fetching album detail for albumId: $albumId")
                val response = repository.getAlbumDetail(albumId)
                println("Album detail response: $response")
                _albumDetail.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun fetchAlbumTracks(albumId: String) {
        viewModelScope.launch {
            try {
                println("Fetching album tracks for albumId: $albumId")
                val response = repository.getAlbumTracks(albumId)
                println("Album tracks response: $response")
                _albumTracks.value = response.track ?: emptyList()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun formatDuration(milliseconds: Long): String {
        val totalSeconds = milliseconds / 1000
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60
        return String.format("%d:%02d", minutes, seconds)
    }

}