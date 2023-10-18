package com.androidhell.imveganbtw.screens

import android.annotation.SuppressLint
import android.widget.RadioGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.androidhell.imveganbtw.R
import com.androidhell.imveganbtw.RestrictButton
import com.androidhell.imveganbtw.Screens
import com.androidhell.imveganbtw.ui.theme.AppTheme
import com.androidhell.imveganbtw.ui.theme.md_theme_light_primary
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch



@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun LanguageScreen(navController: NavController, languageViewModel: LanguageViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Text(
            text = "Select Language",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(16.dp))

        RadioGroup(
            options = listOf("English", "Spanish", "French", "German", "Italian", "Japanese", "Korean", "Chinese", "Thai", "Bangla"),
            selectedOption = languageViewModel.selectedLanguageValue,
            onOptionSelected = { language ->
                languageViewModel.setSelectedLanguage(language)
            }
        )

        Spacer(modifier = Modifier.weight(1f))


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            RestrictButton(
                label = stringResource(id = R.string.save_button),
                modifier = Modifier
                    .background(md_theme_light_primary)
                    .weight(1f)
                    .padding(8.dp),
                onClick = {
                    navController.navigate(Screens.Home.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}

@Composable
fun RadioGroup(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Column {
        options.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (option == selectedOption),
                        onClick = { onOptionSelected(option) }
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = option, style = MaterialTheme.typography.bodyMedium)
            }
            Divider(
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                modifier = Modifier.padding(start = 24.dp)
            )
        }
    }
}

class LanguageViewModel : ViewModel() {
    var selectedLanguageValue by mutableStateOf("English")
        private set

    fun setSelectedLanguage(language: String) {
        selectedLanguageValue = language
    }
}


@Composable
@Preview
fun LanguageScreenPreview() {
    val navController = rememberNavController()
    val languageViewModel = LanguageViewModel()
    AppTheme(darkTheme = false) {
        LanguageScreen(navController, languageViewModel)
    }
}
