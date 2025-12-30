package com.example.unsplashclient.data.repository

import com.example.unsplashclient.data.remote.PhotoDetailDto
import com.example.unsplashclient.data.remote.SearchPhotosResultDto
import com.example.unsplashclient.data.remote.UnsplashApiService
import com.example.unsplashclient.domain.repository.PhotoRepository
import javax.inject.Inject

class DefaultPhotoRepository
    @Inject
    constructor(
        private val apiService: UnsplashApiService,
    ) : PhotoRepository {
        override suspend fun searchPhotos(query: String): SearchPhotosResultDto {
            return apiService.searchPhotos(query)
        }

        override suspend fun getPhotoById(id: String): PhotoDetailDto {
            return apiService.getPhotoById(id)
        }
    }
