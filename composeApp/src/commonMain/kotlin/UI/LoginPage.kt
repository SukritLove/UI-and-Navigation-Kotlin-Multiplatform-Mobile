package UI

import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.NavigationRail
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

enum class ScreenList {
    LoginPage,
    RegisterPage
}


@OptIn(ExperimentalResourceApi::class)
@Composable
fun LoginPage() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility)
        painterResource("show.png")
    else
        painterResource("hide.png")



    Scaffold(
        topBar = {
            TopBar(modifier = Modifier)
        }
    ) {


        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(painterResource("drawable/profile-user.png"), null, Modifier.size(100.dp))

            Spacer(Modifier.padding(20.dp))
            CreateTextField(
                label = "Username",
                value = username,
                onValueChange = { username = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                visualTransformation = VisualTransformation.None,
                trailingIcon = {}
            )

            Spacer(Modifier.padding(20.dp))

            CreateTextField(
                label = "Password",
                value = password,
                onValueChange = { password = it },
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        Icon(
                            painter = icon,
                            contentDescription = "Visibility Icon",
                            Modifier.size(20.dp)
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = if (passwordVisibility) VisualTransformation.None
                else PasswordVisualTransformation()
            )
            Spacer(Modifier.padding(20.dp))
            CreateButton(
                modifier = Modifier.size(width = 200.dp, height = 50.dp),
                btnName = "Login",
                onClick = {},
            )
            Spacer(Modifier.padding(10.dp))
            CreateButton(
                modifier = Modifier.size(width = 200.dp, height = 50.dp),
                btnName = "Register",
                onClick = {},
            )
        }
    }
}

@Composable
fun CreateTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    visualTransformation: VisualTransformation,
    keyboardOptions: KeyboardOptions,
    trailingIcon: @Composable (() -> Unit)? = null
) {


    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        singleLine = true,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions, trailingIcon = trailingIcon
    )
}


@Composable
fun CreateButton(modifier: Modifier = Modifier, btnName: String, onClick: () -> Unit) {
    Button(onClick = onClick, modifier = modifier, shape = RoundedCornerShape(20.dp)) {
        Text(btnName)
    }
}


@Composable
fun TopBar(modifier: Modifier = Modifier) {
    TopAppBar(modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(0.dp)) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "Login",
                style = TextStyle(fontSize = 20.sp),
            )
        }
    }
}