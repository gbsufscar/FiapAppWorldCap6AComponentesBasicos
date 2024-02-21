package br.com.fiap.basiccomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.basiccomponents.ui.theme.BasicComponentsTheme
import br.com.fiap.basiccomponents.ui.theme.Righteous

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComponentsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BasicComponentsScreen()
                }
            }
        }
    }
}

@Composable
fun BasicComponentsScreen() {
    // Variáreis do compontente
    var textFieldValue = remember {
        // Função dentro do componente composable
        mutableStateOf("") // Vazio, "", é o valor de inicialização do estado da variável,
    }

    var quantidade = remember {
        mutableStateOf("")
    }

    var cidade = remember {
        mutableStateOf("")
    }


    // Componentes/Composables da tela
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        Text(
            modifier = Modifier
                .background(Color.Yellow)
                .fillMaxWidth(),
            text = "FIAP",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(237, 20, 91),
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Left
            )
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Desenvolvendo aplicações Android",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            fontFamily = Righteous // Utilizando a fonte importada do Google Fonts.
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Composable TextField para digitar um texto
        TextField(
            modifier = Modifier.fillMaxWidth(),

            value = textFieldValue.value, // Pega o valor da variável (que é um objeto)
            onValueChange = {novoValor -> textFieldValue.value = novoValor}, // Função Lambda; Leia-se: A cada novo texto digitado (novoValor), atualiza o valor da variável (textFieldVAlue.value).
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words), // Disponibiliza um teclado maiúsculo para digitação.
            label = {
                Text(text = "Nome e sobrenome")
            },
            leadingIcon = { // Posiciona o ícone no início do TextField
                Icon(
                    imageVector = Icons.Default.Person, // Figurinha de pessoa
                    contentDescription = "",
                    tint = Color(237, 20, 91)
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Composable TextField para digitar uma quantidade via teclado numérico
        TextField(
            modifier = Modifier.fillMaxWidth(),

            value = "${quantidade.value}",
            onValueChange = {novoValor -> quantidade.value = novoValor},
            placeholder = {
                          Text(text = "Qual a quantidade desejada?") // Um objeto Composable dentro do placeholder (dica para o usuário).
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), // parâmetro que permite mudar o teclado exibido para o usuário.
            // Definir um conjunto de cores do TextField
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.Green,
                unfocusedPlaceholderColor = Color.Magenta

            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = cidade.value,
            onValueChange = {cidade.value = it},
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.Gray),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors
                (
                unfocusedBorderColor = Color.Yellow,
                focusedBorderColor = Color.Cyan
            ),
            label ={                        // O lable é um Composable
                   Text(text = "e-mail")
            },
            placeholder = {                 // O placeholder é um Composable
                Text(text = "Digite o seu e-mail")
            },
            trailingIcon = {
                Icon(imageVector = Icons.Default.Email,
                    contentDescription = "",
                    tint = Color(94, 90, 91, 255)
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row (modifier = Modifier.height(32.dp)){
            Checkbox(
                checked = false,
                onCheckedChange = {},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.White,
                    uncheckedColor = Color(0xffed1456)
                )
            )
            Text(
                text = "Opção 1",
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BasicComponentsScreenPreview() {
    BasicComponentsTheme {
        BasicComponentsScreen()
    }

}