package com.healthifyme.ui.screens.onboarding.gender

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.healthifyme.R
import com.healthifyme.domain.Gender
import com.healthifyme.ui.screens.onboarding.components.ActionButton
import com.healthifyme.ui.screens.onboarding.components.SelectableButton
import  com.healthifyme.ui.screens.onboarding.gender.GenderSelectionViewModel.GenderSelectionEvent

@Composable
fun GenderSelectionScreen(
    navClickCallback: () -> Unit,
    viewModel: GenderSelectionViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { uiEvent ->
            when (uiEvent) {
                GenderSelectionEvent.NavigateUser -> {
                    navClickCallback()
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(24.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.what_is_your_gender),
                color = Color.White,
                fontSize = 26.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.padding(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SelectableButton(
                    buttonText = stringResource(R.string.gender_male),
                    isSelected = viewModel.selectedGender is Gender.Male,
                    defaultColor = Color.White,
                    selectedColor = Color.Green
                ) {
                    viewModel.onEvent(
                        GenderSelectionViewModel.GenderSelectionUIEvent.OnGenderSelected(
                            Gender.Male
                        )
                    )
                }

                SelectableButton(
                    buttonText = stringResource(R.string.gender_female),
                    isSelected = viewModel.selectedGender is Gender.Female,
                    defaultColor = Color.White,
                    selectedColor = Color.Green,
                ) {
                    viewModel.onEvent(
                        GenderSelectionViewModel.GenderSelectionUIEvent.OnGenderSelected(
                            Gender.Female
                        )
                    )
                }
            }


        }

        ActionButton(
            buttonText = stringResource(R.string.next),
            buttonColor = ButtonDefaults.buttonColors(Color(0XFF00C713)),
            textColor = Color.White,
            modifier = Modifier.align(alignment = Alignment.BottomEnd),
            onClick = {
                viewModel.onEvent(GenderSelectionViewModel.GenderSelectionUIEvent.OnNextSelected)
            }
        )
    }


}

@Preview
@Composable
fun ShowPreview() {
    GenderSelectionScreen({})
}