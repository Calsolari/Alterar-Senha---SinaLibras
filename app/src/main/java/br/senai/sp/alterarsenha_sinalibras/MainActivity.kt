package br.senai.sp.alterarsenha_sinalibras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.alterarsenha_sinalibras.ui.theme.AlterarSenhaSinaLibrasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlterarSenhaSinaLibrasTheme {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlterarSenha() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD0E6FF))
            .padding(16.dp)
    ) {
        IconButton(
            onClick = { /* Ação de voltar */ },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Voltar", tint = Color.Black)
        }

        Text(
            text = "Alterar Senha",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 24.dp)
        )

        Box(
            modifier = Modifier
                .background(Color(0xFF485F9A), shape = RoundedCornerShape(12.dp))
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Um código de verificação foi enviado ao seu email.\nPor favor, insira-o no campo abaixo",
                    color = Color.White,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextField(
                        value = "AH293HN",
                        onValueChange = {},
                        modifier = Modifier.weight(1f),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        ),
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(onClick = { /* Ação enviar código */ }) {
                        Icon(Icons.Default.Send , contentDescription = "Enviar Código", tint = Color.White)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Sua senha precisa ter pelo menos seis caracteres e incluir uma combinação de números, letras e caracteres especiais (!@#$)",
            color = Color(0xFF485F9A),
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Nova Senha", color = Color(0xFF485F9A)) },
            visualTransformation = PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { /* Ação exibir senha */ }) {
                    Icon(Icons.Default.VisibilityOff, contentDescription = null, tint = Color(0xFF485F9A))
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color(0xFF485F9A),
                unfocusedIndicatorColor = Color(0xFF485F9A),
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Confirmar Senha", color = Color(0xFF485F9A)) },
            visualTransformation = PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { /* Ação exibir senha */ }) {
                    Icon(Icons.Default.VisibilityOff, contentDescription = null, tint = Color(0xFF485F9A))
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color(0xFF485F9A),
                unfocusedIndicatorColor = Color(0xFF485F9A),
            )
        )

        Spacer(modifier = Modifier.height(134.dp))

        Button(
            onClick = { /* Ação confirmar */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF485F9A))
        ) {
            Text(text = "Confirmar", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "obs: caso não o encontre na caixa de entrada, verifique a caixa Spam",
            fontSize = 12.sp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AlterarSenhaPreview() {
    AlterarSenhaSinaLibrasTheme {
        AlterarSenha()
    }
}
