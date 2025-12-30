package com.example.unsplashclient.presentation.search_photos.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.unsplashclient.domain.model.Photo
import com.example.unsplashclient.presentation.ui.theme.UnsplashClientTheme

@Composable
fun PhotoThumbnail(
    photo: Photo,
    onClick: (Photo) -> Unit,
) {
    Box(
        modifier =
            Modifier
                .background(Color.Black)
                .heightIn(min = 200.dp)
                .clickable { onClick(photo) },
        contentAlignment = Alignment.BottomCenter,
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
        )
        AsyncImage(
            model = photo.imageUrl,
            contentDescription = photo.description,
            modifier = Modifier.fillMaxWidth(),
        )
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .padding(10.dp),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(0.8f),
            ) {
                Text(
                    text = photo.description ?: "No Description",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall,
                )
                Text(
                    text = photo.photographer ?: "Unknown Photographer",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Likes",
                tint = Color.Magenta,
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = photo.likes.toString(),
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}

@Preview
@Composable
private fun PhotoThumbnailPreview() {
    val photo =
        Photo(
            photoId = "",
            description = "Sample Photo",
            likes = 100,
            imageUrl = "https://images.unsplash.com/photo-1764617988939-034265354ad6?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHw1fHx8ZW58MHx8fHx8",
            photographer = "Kevin Mueller",
        )
    UnsplashClientTheme {
        PhotoThumbnail(photo = photo, onClick = {})
    }
}
