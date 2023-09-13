package com.example.imveganbtw.screens

import android.annotation.SuppressLint
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.imveganbtw.RestrictButton
import com.example.imveganbtw.ui.theme.md_theme_light_primary
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.imveganbtw.R
import com.example.imveganbtw.ui.theme.AppTheme

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun HomeScreen(navController: NavController, languageViewModel: LanguageViewModel) {
    val viewModel: CardsViewModel = viewModel()

    AppTheme{
        Column(modifier = Modifier.fillMaxSize()) {
            CardItem("Vegan", viewModel.isVeganText, languageViewModel.selectedLanguageValue) {
                viewModel.isVeganText = !viewModel.isVeganText
                if (viewModel.isVeganText) {
                    viewModel.isDairyText = true
                    viewModel.isEggsText = true
                    viewModel.isMeatText = true
                    viewModel.isFishText = true
                } else {
                    viewModel.isDairyText = false
                    viewModel.isEggsText = false
                    viewModel.isMeatText = true
                    viewModel.isFishText = true
                }
            }
            CardItem("Dairy", viewModel.isDairyText, languageViewModel.selectedLanguageValue) {
                viewModel.isDairyText = !viewModel.isDairyText
            }
            CardItem("Eggs", viewModel.isEggsText, languageViewModel.selectedLanguageValue) {
                viewModel.isEggsText = !viewModel.isEggsText
            }
            CardItem("Meat", viewModel.isMeatText, languageViewModel.selectedLanguageValue) {
                viewModel.isMeatText = !viewModel.isMeatText
            }
            CardItem("Fish", viewModel.isFishText, languageViewModel.selectedLanguageValue) {
                viewModel.isFishText = !viewModel.isFishText
            }
            CardItem("Gluten", viewModel.isGlutenText, languageViewModel.selectedLanguageValue) {
                viewModel.isGlutenText = !viewModel.isGlutenText
            }
            Spacer(modifier = Modifier.weight(1f))
            RestrictButtonRow(viewModel)
        }
    }

}

@Composable
fun CardItem(title: String, checked: Boolean, selectedLanguage: String, language: () -> Unit) {
    val cardModifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp)
        .height(60.dp)

    val backgroundColor = if (isSystemInDarkTheme()) {
        Color.DarkGray
    } else {
        Color.White
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Card(
            modifier = cardModifier,
            colors = CardDefaults.elevatedCardColors(containerColor = backgroundColor),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Text(
                    text = stringResource(id = getTitleResourceId(title, checked, selectedLanguage)),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = stringResource(id = getLocalizedResourceId(title, checked)),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onSurface
                )

            }
        }
    }
}



@Composable
fun getTitleResourceId(title: String, checked: Boolean, selectedLanguage: String): Int {
    return when (selectedLanguage) {
        "Spanish" -> {
            when (title) {
                "Vegan" -> if (checked) R.string.vegan_spanish else R.string.vegetarian_spanish
                "Dairy" -> if (checked) R.string.no_dairy_spanish else R.string.yes_dairy_spanish
                "Eggs" -> if (checked) R.string.no_eggs_spanish else R.string.yes_eggs_spanish
                "Meat" -> if (checked) R.string.no_meat_spanish else R.string.yes_meat_spanish
                "Fish" -> if (checked) R.string.no_fish_spanish else R.string.yes_fish_spanish
                "Gluten" -> if (checked) R.string.yes_gluten_spanish else R.string.no_gluten_spanish
                else -> R.string.app_name // Placeholder
            }
        }
        "German" -> {
            when (title) {
                "Vegan" -> if (checked) R.string.vegan_german else R.string.vegetarian_german
                "Dairy" -> if (checked) R.string.no_dairy_german else R.string.yes_dairy_german
                "Eggs" -> if (checked) R.string.no_eggs_german else R.string.yes_eggs_german
                "Meat" -> if (checked) R.string.no_meat_german else R.string.yes_meat_german
                "Fish" -> if (checked) R.string.no_fish_german else R.string.yes_fish_german
                "Gluten" -> if (checked) R.string.yes_gluten_german else R.string.no_gluten_german
                else -> R.string.app_name // Placeholder
            }
        }
        "French" -> {
            when (title) {
                "Vegan" -> if (checked) R.string.vegan_french else R.string.vegetarian_french
                "Dairy" -> if (checked) R.string.no_dairy_french else R.string.yes_dairy_french
                "Eggs" -> if (checked) R.string.no_eggs_french else R.string.yes_eggs_french
                "Meat" -> if (checked) R.string.no_meat_french else R.string.yes_meat_french
                "Fish" -> if (checked) R.string.no_fish_french else R.string.yes_fish_french
                "Gluten" -> if (checked) R.string.yes_gluten_french else R.string.no_gluten_french
                else -> R.string.app_name // Placeholder
            }
        }
        "Italian" -> {
            when (title) {
                "Vegan" -> if (checked) R.string.vegan_italian else R.string.vegetarian_italian
                "Dairy" -> if (checked) R.string.no_dairy_italian else R.string.yes_dairy_italian
                "Eggs" -> if (checked) R.string.no_eggs_italian else R.string.yes_eggs_italian
                "Meat" -> if (checked) R.string.no_meat_italian else R.string.yes_meat_italian
                "Fish" -> if (checked) R.string.no_fish_italian else R.string.yes_fish_italian
                "Gluten" -> if (checked) R.string.yes_gluten_italian else R.string.no_gluten_italian
                else -> R.string.app_name // Placeholder
            }
        }
        "Japanese" -> {
            when (title) {
                "Vegan" -> if (checked) R.string.vegan_japanese else R.string.vegetarian_japanese
                "Dairy" -> if (checked) R.string.no_dairy_japanese else R.string.yes_dairy_japanese
                "Eggs" -> if (checked) R.string.no_eggs_japanese else R.string.yes_eggs_japanese
                "Meat" -> if (checked) R.string.no_meat_japanese else R.string.yes_meat_japanese
                "Fish" -> if (checked) R.string.no_fish_japanese else R.string.yes_fish_japanese
                "Gluten" -> if (checked) R.string.yes_gluten_japanese else R.string.no_gluten_japanese
                else -> R.string.app_name // Placeholder
            }
        }
        "Korean" -> {
            when (title) {
                "Vegan" -> if (checked) R.string.vegan_korean else R.string.vegetarian_korean
                "Dairy" -> if (checked) R.string.no_dairy_korean else R.string.yes_dairy_korean
                "Eggs" -> if (checked) R.string.no_eggs_korean else R.string.yes_eggs_korean
                "Meat" -> if (checked) R.string.no_meat_korean else R.string.yes_meat_korean
                "Fish" -> if (checked) R.string.no_fish_korean else R.string.yes_fish_korean
                "Gluten" -> if (checked) R.string.yes_gluten_korean else R.string.no_gluten_korean
                else -> R.string.app_name // Placeholder
            }
        }
        "Thai" -> {
            when (title) {
                "Vegan" -> if (checked) R.string.vegan_thai else R.string.vegetarian_thai
                "Dairy" -> if (checked) R.string.no_dairy_thai else R.string.yes_dairy_thai
                "Eggs" -> if (checked) R.string.no_eggs_thai else R.string.yes_eggs_thai
                "Meat" -> if (checked) R.string.no_meat_thai else R.string.yes_meat_thai
                "Fish" -> if (checked) R.string.no_fish_thai else R.string.yes_fish_thai
                "Gluten" -> if (checked) R.string.yes_gluten_thai else R.string.no_gluten_thai
                else -> R.string.app_name // Placeholder
            }
        }
        "Chinese" -> {
            when (title) {
                "Vegan" -> if (checked) R.string.vegan_chinese else R.string.vegetarian_chinese
                "Dairy" -> if (checked) R.string.no_dairy_chinese else R.string.yes_dairy_chinese
                "Eggs" -> if (checked) R.string.no_eggs_chinese else R.string.yes_eggs_chinese
                "Meat" -> if (checked) R.string.no_meat_chinese else R.string.yes_meat_chinese
                "Fish" -> if (checked) R.string.no_fish_chinese else R.string.yes_fish_chinese
                "Gluten" -> if (checked) R.string.yes_gluten_chinese else R.string.no_gluten_chinese
                else -> R.string.app_name // Placeholder
            }
        }
        else -> {
            when (title) {
                "Vegan" -> if (checked) R.string.vegan_localized else R.string.vegetarian_localized
                "Dairy" -> if (checked) R.string.no_dairy_localized else R.string.yes_dairy_localized
                "Eggs" -> if (checked) R.string.no_eggs_localized else R.string.yes_eggs_localized
                "Meat" -> if (checked) R.string.no_meat_localized else R.string.yes_meat_localized
                "Fish" -> if (checked) R.string.no_fish_localized else R.string.yes_fish_localized
                "Gluten" -> if (checked) R.string.yes_gluten_localized else R.string.no_gluten_localized
                else -> R.string.app_name // Placeholder
            }
        }
    }
}


@Composable
fun getLocalizedResourceId(title: String, checked: Boolean): Int {
    return when (title) {
        "Vegan" -> if (checked) R.string.vegan_localized else R.string.vegetarian_localized
        "Dairy" -> if (checked) R.string.no_dairy_localized else R.string.yes_dairy_localized
        "Eggs" -> if (checked) R.string.no_eggs_localized else R.string.yes_eggs_localized
        "Meat" -> if (checked) R.string.no_meat_localized else R.string.yes_meat_localized
        "Fish" -> if (checked) R.string.no_fish_localized else R.string.yes_fish_localized
        "Gluten" -> if (checked) R.string.yes_gluten_localized else R.string.no_gluten_localized
        else -> R.string.app_name // Placeholder
    }
}

@Composable
fun RestrictButtonRow(viewModel: CardsViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                RestrictButton(
                    label = stringResource(id = R.string.vegan_button),
                    modifier = Modifier
                        .background(md_theme_light_primary)
                        .weight(1f)
                        .padding(4.dp)
                        .fillMaxHeight(),
                    onClick = {
                        viewModel.isVeganText = !viewModel.isVeganText
                        if (viewModel.isVeganText) {
                            viewModel.isDairyText = true
                            viewModel.isEggsText = true
                            viewModel.isMeatText = true
                            viewModel.isFishText = true
                        } else {
                            viewModel.isDairyText = false
                            viewModel.isEggsText = false
                            viewModel.isMeatText = true
                            viewModel.isFishText = true
                        }
                    },
                )
                Spacer(modifier = Modifier.width(8.dp))
                RestrictButton(
                    label = stringResource(id = R.string.dairy_button),
                    modifier = Modifier
                        .background(md_theme_light_primary)
                        .weight(1f)
                        .padding(4.dp)
                        .fillMaxHeight(),
                    onClick = { viewModel.isDairyText = !viewModel.isDairyText },
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                RestrictButton(
                    label = stringResource(id = R.string.eggs_button),
                    modifier = Modifier
                        .background(md_theme_light_primary)
                        .weight(1f)
                        .padding(4.dp)
                        .fillMaxHeight(),
                    onClick = { viewModel.isEggsText = !viewModel.isEggsText },
                )
                Spacer(modifier = Modifier.width(8.dp))
                RestrictButton(
                    label = stringResource(id = R.string.meat_button),
                    modifier = Modifier
                        .background(md_theme_light_primary)
                        .weight(1f)
                        .padding(4.dp)
                        .fillMaxHeight(),
                    onClick = { viewModel.isMeatText = !viewModel.isMeatText },
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                RestrictButton(
                    label = stringResource(id = R.string.fish_button),
                    modifier = Modifier
                        .background(md_theme_light_primary)
                        .weight(1f)
                        .padding(4.dp)
                        .fillMaxHeight(),
                    onClick = { viewModel.isFishText = !viewModel.isFishText },
                )
                Spacer(modifier = Modifier.width(8.dp))
                RestrictButton(
                    label = stringResource(id = R.string.gluten_button),
                    modifier = Modifier
                        .background(md_theme_light_primary)
                        .weight(1f)
                        .padding(4.dp)
                        .fillMaxHeight(),
                    onClick = { viewModel.isGlutenText = !viewModel.isGlutenText }
                )
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    val navController = rememberNavController()
    val languageViewModel = LanguageViewModel()
    AppTheme(darkTheme = false) {
        LanguageScreen(navController, languageViewModel)
    }
}


class CardsViewModel : ViewModel() {
    var isVeganText by mutableStateOf(true)
    var isDairyText by mutableStateOf(true)
    var isEggsText by mutableStateOf(true)
    var isMeatText by mutableStateOf(true)
    var isFishText by mutableStateOf(true)
    var isGlutenText by mutableStateOf(true)
}