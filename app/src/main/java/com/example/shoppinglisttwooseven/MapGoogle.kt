package com.example.shoppinglisttwooseven

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


@OptIn(ExperimentalMaterial3Api::class) // Указывает, что мы используем экспериментальные API Material3
@Composable
fun MapScreen(navController: NavController)
{
    // Состояние для хранения текущего местоположения
    var currentLocation by remember { mutableStateOf<LatLng?>(null) }

    // Запоминаем состояние позиции камеры
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(
            // Начальная позиция камеры (можно изменить на нужные координаты)
            LatLng(55.75, 37.61), // Координаты Москвы по умолчанию
            10f // Уровень масштабирования
        )
    }

    // Основная колонка для размещения элементов интерфейса
    Column(
        modifier = Modifier.fillMaxSize() // Заполнение всей доступной области
    )
    {
        // Панель инструментов (Toolbar)
        TopAppBar(
            title = { Text("Место покупки") }, // Заголовок панели
            navigationIcon =
            {
                IconButton(onClick = { navController.navigateUp() }) // Кнопка навигации назад
                {
                    Icon(Icons.Default.ArrowBack, "Вернуться") // Иконка стрелки назад
                }
            }
        )

        // Отображение карты Google с использованием Compose
        GoogleMap(
            modifier = Modifier.weight(1f), // Занимает оставшееся пространство
            cameraPositionState = cameraPositionState, // Состояние камеры
            properties = MapProperties(isMyLocationEnabled = false), // Свойства карты
            uiSettings = MapUiSettings(zoomControlsEnabled = true), // Настройки интерфейса карты
            onMapClick = { latLng -> // Обработчик клика на карте
                currentLocation = latLng // Сохраняем выбранное местоположение
                cameraPositionState.position = CameraPosition.fromLatLngZoom(latLng, 15f) // Перемещаем камеру на выбранные координаты
            }
        ) {
            // Добавляем маркер для выбранного местоположения
            currentLocation?.let { location ->
                Marker(
                    state = MarkerState(position = location), // Позиция маркера
                    title = "Выбранное место", // Заголовок маркера
                    snippet = "Lat: ${location.latitude}, Lng: ${location.longitude}" // Подсказка с координатами
                )
            }
        }

        // Кнопка сохранения
        Button(
            modifier = Modifier
                .fillMaxWidth() // Заполнение всей ширины
                .padding(16.dp), // Отступы
            onClick = {
                currentLocation?.let {
                    // Сохраняем выбранное местоположение в предыдущем состоянии навигации
                    navController.previousBackStackEntry
                        ?.savedStateHandle
                        ?.set("selected_location", it)
                }
                navController.navigateUp() // Возвращаемся на предыдущий экран
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue)
        ) {
            Text("Сохранить местоположение") // Текст на кнопке
        }
    }
}