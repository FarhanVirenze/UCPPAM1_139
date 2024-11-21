package com.pam.ucp1_pam_c_139

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.tan

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp), // Tambahan padding untuk ruang antar element
    ) {

        Text(
            text = "Good Aftenoon,",
            modifier = Modifier.padding(bottom = 5.dp)
        )

        Text(
            text = "Muhamad Farhan",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp), // Tambahan padding untuk ruang antar elemen
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Title "LogIn" dengan style yang lebih besar dan tebal
            Text(
                text = "Pemesanan",
                modifier = Modifier.padding(top = 20.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            var asalkota by remember { mutableStateOf("") }
            var tujuankota by remember { mutableStateOf("") }
            var tanggalpergi by remember { mutableStateOf("") }
            var tanggalpulang by remember { mutableStateOf("") }
            var kelas by remember { mutableStateOf("") }

            val datakelas = listOf("Ekonomi", "Bussiness")

            var confasalkota by remember { mutableStateOf("") }
            var conftujuankota by remember { mutableStateOf("") }
            var conftanggalpergi by remember { mutableStateOf("") }
            var conftanggalpulang by remember { mutableStateOf("") }
            var confkelas by remember { mutableStateOf("") }

            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = asalkota,
                    onValueChange = { asalkota = it },
                    label = { Text("Dari") },
                    placeholder = { Text("Isi Asal Kota Keberangkatan") },
                    modifier = modifier.fillMaxWidth().padding(5.dp)
                )

                TextField(
                    value = tujuankota,
                    onValueChange = { tujuankota = it },
                    label = { Text("Ke") },
                    placeholder = { Text("Isi tujuan kota") },
                    modifier = modifier.fillMaxWidth().padding(5.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
                TextField(
                    value = tanggalpergi,
                    onValueChange = { tanggalpulang = it },
                    label = { Text("Tanggal Pergi") },
                    placeholder = { Text("Isi Tanggal Keberanglatan Anda") },
                    modifier = modifier.fillMaxWidth().padding(5.dp)
                )
                TextField(
                    value = tanggalpulang,
                    onValueChange = { tanggalpulang = it },
                    label = { Text("Tanggal Kepulangan") },
                    placeholder = { Text("Isi Tanggal Pulang Anda") },
                    modifier = modifier.fillMaxWidth().padding(5.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(16.dp), // Tambahan padding untuk ruang antar element
                ) {

                    Text(
                        text = "Class",
                        modifier = Modifier.padding(bottom = 5.dp),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        datakelas.forEach { selectedGender ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(end = 8.dp)
                            ) {
                                RadioButton(
                                    selected = kelas == selectedGender,
                                    onClick = { kelas = selectedGender }
                                )
                                Text(text = selectedGender)
                            }
                        }
                    }

                    Column(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(10.dp), // Tambahan padding untuk ruang antar elemen
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Button(onClick = {
                            confasalkota = asalkota
                            conftujuankota = tujuankota
                            conftanggalpergi = tanggalpergi
                            conftanggalpulang = tanggalpulang
                            confkelas = kelas
                        }) {
                            Text(text = "Submit")
                        }

                        TampilData(param = "Keberangkatan", argu = confasalkota)
                        TampilData(param = "Kedatangan", argu = conftujuankota)
                        TampilData(param = "Tanggal pergi", argu = conftanggalpergi)
                        TampilData(param = "Tanggal pulang", argu = conftanggalpulang)
                        TampilData(param = "Class", argu = confkelas)
                    }
                }
            }
        }
    }
}

@Composable
fun TampilData(
    param: String, argu: String
) {
    Column(
        modifier = Modifier.padding(top = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = param, modifier = Modifier.weight(2.3f))
            Text(text = ": ", modifier = Modifier.weight(1f))
            Text(text = argu, modifier = Modifier.weight(2f))
        }
    }
}

