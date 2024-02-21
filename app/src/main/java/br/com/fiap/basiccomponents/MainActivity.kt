package br.com.fiap.basiccomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
            textAlign = TextAlign.End
            )
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Desenvolvendo aplicações Android",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            fontFamily = Righteous // Utilizando a fonte importada do Google Fonts.
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),

            value = textFieldValue.value, // Pega o valor da variável (que é um objeto)
            onValueChange = {novoValor -> textFieldValue.value = novoValor}
            // Função Lambda; Leia-se: A cada novo texto digitado (novoValor), atualiza o valor da variável (textFieldVAlue.value).
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BasicComponentsScreenPreview() {
    BasicComponentsTheme {
        BasicComponentsScreen()
    }

}