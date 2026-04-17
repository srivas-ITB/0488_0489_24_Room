import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app24_Room.R
import com.example.app24_Room.ui.screen.Pantalles_ViewModel

@Composable
fun DetailScreen(idCharacter: Int, navigateBack: () -> Unit) {

    val vm: Pantalles_ViewModel = viewModel()
    val character by vm.character.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        vm.getCharacterById(idCharacter)
    }

    Column(
        Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(character?.name ?: "Personatge", fontSize = 28.sp,fontWeight = FontWeight.Bold)
        Text(text = "Type: ${character?.id ?: "Id: "}")
        Button(navigateBack) {Text("Return")}
    }
}